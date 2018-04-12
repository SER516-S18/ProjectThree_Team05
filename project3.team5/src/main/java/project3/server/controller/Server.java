/**
 * @SER516 Project3_Team05
 */

package project3.server.controller;

import project3.model.ConnectionIpAndPortValues;
import project3.model.ServerConfigurations;
import project3.server.view.ServerConsolePanel;
import javax.websocket.DeploymentException;
import utilities.Constants;

/**
 * Setting up websocket for server
 *
 *
 * @Version 1.0
 */

public class Server implements Runnable {

	private static Server serverObject = null;

	/*
	 * Setting up the connection
	 */
	public void Start() {
		org.glassfish.tyrus.server.Server server = new org.glassfish.tyrus.server.Server(
				ConnectionIpAndPortValues.getIpAddress(), ConnectionIpAndPortValues.getPortAddress(), Constants.WS,
				ServerEndPoint.class);
		try {
			ServerConsolePanel.getServerConsoleInstance()
					.appendLogMessage("Server is Started on Port number " + ConnectionIpAndPortValues.getPortAddress());
			server.start();

		} catch (DeploymentException e) {
			ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * adding autoreset functionality through websocket
	 */
	public void setAutoReset(boolean autoResetValue) {

		ServerConfigurations serverConfig = ServerConfigurations.getServerDataInstance();
		serverConfig.setAutoRepeat(autoResetValue);

		if (autoResetValue)
			serverConfig.setSendOneTime(false);
		else
			serverConfig.setSendOneTime(true);
	}

	/*
	 * Initializing server to start connection
	 */
	public static Server getServerInstance() {
		if (serverObject == null)
			serverObject = new Server();
		return serverObject;
	}

	/*
	 * Start the connection
	 */
	@Override
	public void run() {
		Start();
	}
}
