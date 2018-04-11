package project3.server.controller;


import javax.websocket.DeploymentException;

import project3.model.ConnectionIpAndPortValues;
import project3.model.serverConfigurations;
import project3.server.view.ServerConsolePanel;
import utilities.Constants;

public class Server implements Runnable{

	private static Server serverObject = null;

	public void Start() {
	org.glassfish.tyrus.server.Server server =
            new org.glassfish.tyrus.server.Server(ConnectionIpAndPortValues.getIpAddress(),
            		ConnectionIpAndPortValues.getPortAddress(), Constants.WS, ServerEndPoint.class);
            try {
            	ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server is Started on Port number "+ ConnectionIpAndPortValues.getPortAddress());
				server.start();
				
			} catch (DeploymentException e) {
				// TODO Auto-generated catch block
				ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
				e.printStackTrace();
			}
	}

	public void setAutoReset(boolean autoResetValue) {

		  serverConfigurations serverConfig = serverConfigurations.getServerDataInstance();
		  serverConfig.setAutoRepeat(autoResetValue);


		
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
