package project3.server.controller;


import javax.websocket.DeploymentException;

import project3.model.ConnectionIpAndPortValues;
import project3.model.serverConfiguations;
import utilities.Constants;

public class Server implements Runnable{

	private static Server serverObject = null;

	public void Start() {
	org.glassfish.tyrus.server.Server server =
            new org.glassfish.tyrus.server.Server(ConnectionIpAndPortValues.getIpAddress(),
            		ConnectionIpAndPortValues.getPortAddress(), Constants.WS, ServerEndPoint.class);
            try {
				server.start();
			} catch (DeploymentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void setAutoReset(boolean autoResetValue) {
		serverConfiguations serverConfig = serverConfiguations.getServerDataInstance();
		serverConfig.setAutoReset(autoResetValue);
		
		if(autoResetValue)
			serverConfig.setSendOneTime(false);
		else
			serverConfig.setSendOneTime(true);
	}
	
	public static Server getServerInstance(){
		if(serverObject == null)
			serverObject = new Server();
		return serverObject;
	}

	@Override
	public void run() {
		Start();
	}
}
