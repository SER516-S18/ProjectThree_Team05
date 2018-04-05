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



@ServerEndpoint(value = "/server" ,decoders = MessageDecoder.class,  encoders = MessageEncoder.class)
public class ServerEndPoint implements Runnable{
	
	private Session session;
    private static Set<ServerEndPoint> connections  = new CopyOnWriteArraySet<>();
    private static Thread thread; 
    private static ServerEndPoint serverEndPoint = new ServerEndPoint();
    
    ExpressiveModel values = new ExpressiveModel();
    TimeStamp timeStamp = new TimeStamp(); 
    Timer time = timeStamp.gettimer();
    int secondspassed = 0;
    
    public static ServerEndPoint getServerEndPointInsctance()
    {
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

			  
			  System.out.println("Timer : "+secondspassed);
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


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		   time.scheduleAtFixedRate(task,timeStamp.getIntialTime() ,5000);
		
	}
	

}
