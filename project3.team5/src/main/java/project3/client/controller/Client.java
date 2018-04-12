/*
 * SER516-Project3_Team05
 */
package project3.client.controller;

import project3.client.view.ClientUI;
import project3.model.ConnectionIpAndPortValues;
import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;
import utilities.Constants;

/*
 * Implements connection of client to the server
 * */
public class Client implements Runnable {

	public static String SERVER;
	private static Client clientObject = null;

	public void startClient() throws Exception {
		ClientManager client = ClientManager.createClient();
		String message;

		Scanner scanner = new Scanner(System.in);

		ExpressiveModelObservable.getExpressiveModelObservableInstance()
				.addObserver(ClientUI.setObserver().setAsObserver());
		ExpressiveModelObservable.getExpressiveModelObservableInstance()
				.addObserver(ClientUI.setObserver().setPerformanceAsObserver());

		StringBuilder sb = new StringBuilder();
		sb.append(Constants.CONNECTIONSTRING_START);
		sb.append(ConnectionIpAndPortValues.getIpAddress());
		sb.append(":");
		sb.append(ConnectionIpAndPortValues.getPortAddress());
		sb.append(Constants.WS);
		sb.append(Constants.SERVER);
		SERVER = sb.toString();

		Session session = client.connectToServer(ClientEndPoint.class, URI.create(SERVER));
		do {
			message = scanner.nextLine();
		} while (!message.equalsIgnoreCase("quit"));
	}

    /*
     * gets an instance of the client and returns it
     * */
	public static Client getClientInstance() {
		if (clientObject == null)
			clientObject = new Client();
		return clientObject;
	}
	
    /*
     * starts the client in a new thread
     * */
	@Override
	public void run() {
		try {
			startClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}