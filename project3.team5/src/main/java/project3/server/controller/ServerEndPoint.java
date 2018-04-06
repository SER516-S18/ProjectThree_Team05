package project3.server.controller;


import java.io.IOException;
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
import project3.model.ExpressiveModel;
import project3.model.TimeStamp;
import project3.model.serverConfiguations;



@ServerEndpoint(value = "/server" ,decoders = MessageDecoder.class,  encoders = MessageEncoder.class)
public class ServerEndPoint implements Runnable{
	
	private Session session;
    private static Set<ServerEndPoint> connections  = new CopyOnWriteArraySet<>();
    private static ServerEndPoint serverEndPoint = new ServerEndPoint();
    private static boolean serverStatus = false;  
    
    
    public  boolean isServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(boolean serverStatus) {
		ServerEndPoint.serverStatus = serverStatus;
	}

	
    
    TimeStamp timeStamp = new TimeStamp(); 
    Timer time ;
    int secondspassed = 0;
    
    public static ServerEndPoint getServerEndPointInsctance()
    {
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
       // session.close();
		System.out.println(Session.isOpen());
		Session.close();
		System.out.println(Session.isOpen());
        
	}
	
	@OnError
	public void onError(Session session , Throwable throwable) {
		
	}
	
	TimerTask task = new TimerTask() {
		  public void run() {

			  ExpressiveModel values = new ExpressiveModel();
			  System.out.println("ServerTimer : "+secondspassed);
			  values.setTimeStamp(timeStamp.getSecondspassed());
			  try {
				broadcast(values);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  secondspassed++;
			  timeStamp.setSecondspassed(secondspassed);
			  timeStamp.setIntialTime();
			  
		  }
		};
		
	
	public void broadcast(ExpressiveModel values ) 
		      throws IOException, EncodeException {
		  
		        connections.forEach(endpoint -> {
		            synchronized (endpoint) {
		                try {
		                    endpoint.session.getBasicRemote().
		                      sendObject(values);
		                } catch (IOException | EncodeException e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		    }


	public void haltSendingValues()
	{
		System.out.println("In timer " + time);
			this.time.cancel();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Server status"+isServerStatus());
		while(isServerStatus())
		{
			this.time = new Timer();
			System.out.println(serverConfiguations.getServerDataInstance().isAutoReset() +","+serverConfiguations.getServerDataInstance().isSendOneTime());
			
			 if(serverConfiguations.getServerDataInstance().isAutoReset())
			 {
				 time.scheduleAtFixedRate(task,timeStamp.getIntialTime() ,5000);

			 }
			 else if (serverConfiguations.getServerDataInstance().isSendOneTime())
			 {
				 ExpressiveModel values = new ExpressiveModel();
				 secondspassed++;
				 timeStamp.setSecondspassed(secondspassed);
				 System.out.println("ServerTimer : "+ timeStamp.getSecondspassed());
				 System.out.println("send one value");
				 values.setTimeStamp(timeStamp.getSecondspassed());
				 setServerStatus(false);
				 
				 try {
					broadcast(values);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch blockz
					e.printStackTrace();
				}
			 }
		}
		
			 
			 
	}
	

}
