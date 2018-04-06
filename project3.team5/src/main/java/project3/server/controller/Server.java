package project3.server.controller;


import javax.websocket.DeploymentException;

import project3.model.serverConfiguations;

public class Server implements Runnable{

	private static Server serverObject = null;
	
	private ServerEndPoint serverEndPoint = ServerEndPoint.getServerEndPointInsctance();
	
	public void Start() {
		
		org.glassfish.tyrus.server.Server server =
	            new org.glassfish.tyrus.server.Server("localhost", 1726, "/ws", ServerEndPoint.class);
		
		Thread thread = new Thread(serverEndPoint);
		
	            try {
					server.start();
					thread.start();
				} catch (DeploymentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	public synchronized void stopSendingValues()
	{
		serverEndPoint.haltSendingValues();
	  	
	}
	public void setAutoReset(boolean autoResetValue)
	{
		serverConfiguations serverConfig = serverConfiguations.getServerDataInstance();
		serverConfig.setAutoReset(autoResetValue);
		
		if(autoResetValue)
			serverConfig.setSendOneTime(false);
		else
			serverConfig.setSendOneTime(true);
	}
	
	public static Server getServerInstance()
	{
		if(serverObject == null)
			serverObject = new Server();
		
		return serverObject;
	}
	

	@Override
	public void run() {
		Start();
		
	}

}
