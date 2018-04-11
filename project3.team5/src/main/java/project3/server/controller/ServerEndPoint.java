package project3.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import javax.websocket.server.ServerEndpoint;
import project3.model.MessageDecoder;
import project3.model.MessageEncoder;
import project3.model.ConnectionIpAndPortValues;
import project3.model.ExpressiveModel;
import project3.model.TimeStamp;
import project3.model.serverConfigurations;
import project3.server.view.ServerConsolePanel;

@ServerEndpoint(value = "/server" ,decoders = MessageDecoder.class,  encoders = MessageEncoder.class)
public class ServerEndPoint{
	
	private Session session;
    private static Set<ServerEndPoint> connections  = new CopyOnWriteArraySet<>();
    private static ServerEndPoint serverEndPoint = new ServerEndPoint();
	private ExpressiveModel values = new ExpressiveModel();

  

    TimeStamp timeStamp = new TimeStamp(); 
    Timer time = new Timer() ;
    double secondspassed = 0.0;
    double timerOffset = 0.0;
    
    public static ServerEndPoint getServerEndPointInsctance() {
    	 if (serverEndPoint == null)
    		 serverEndPoint = new ServerEndPoint();
    	 
         return serverEndPoint;
    }
    
	@OnOpen
	public void onOpen(Session session ) throws IOException, EncodeException{
		 this.session = session;
	     connections.add(this);
	}
	
	@OnClose
	public void onClose(Session Session) throws IOException, EncodeException{
		connections.remove(this);
		Session.close();   
		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server has been Stopped");;
	}
	
	@OnError
	public void onError(Session session , Throwable throwable) {
		
	}
	
	public TimerTask createNewTimerTask()
	{
		return new TimerTask() {
			  public void run() {
				  System.out.println("ServerTimer : "+secondspassed);				  
				  values.setTimeStamp(timeStamp.getSecondspassed());
				  System.out.println("ServerData : "+ values.getEngagement());
				  System.out.println("Send multiple value");
				  
				  try {
					broadcast(values);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
					
						ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
											}
				  
				  secondspassed += timerOffset;
				  timeStamp.setSecondspassed(secondspassed);
				  timeStamp.setIntialTime();
			  }
			};
	}
	
	public void broadcast(ExpressiveModel values ) 
		      throws IOException, EncodeException {
  
        connections.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().
                      sendObject(values);
                } catch (IOException | EncodeException e) {
                	ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
                   
                }
            }
        });
    }

	public void haltSendingValues() {
		
		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server has stopped sending Values to client");
		 this.time.cancel();		
	}
	
	public void startSendingValues(ExpressiveModel receivedValues) {
		this.values = receivedValues;
		timerOffset = values.getTimeStamp();
		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server is sending Values to client");

		
		if(serverConfigurations.getServerDataInstance().isServerStatus()) {			

			 if(serverConfigurations.getServerDataInstance().isAutoRepeat()) {

				 this.time = new Timer();

				 time.scheduleAtFixedRate(createNewTimerTask(),(long) timeStamp.getIntialTime() ,250);

				 time.scheduleAtFixedRate(createNewTimerTask(),(long) timeStamp.getIntialTime() ,(long) (timerOffset*100));

			 }
			 else {

				 values.setTimeStamp(timeStamp.getSecondspassed());
				 System.out.println("ServerTimer : "+ timeStamp.getSecondspassed());
				 System.out.println("ServerData : "+ values.getEngagement());
				 System.out.println("send one value");
				 
				 secondspassed += timerOffset;
				 timeStamp.setSecondspassed(secondspassed);
			
				 serverConfigurations.getInstance().setDataSendingStatus(false);
				 				 
				try {
					broadcast(values);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch blockz
					ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
					
				}
			 }
		}
	}
}
