package project3.client.controller;

import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;
import project3.client.view.FaceMetricsPanel;
import project3.model.ConnectionIpAndPortValues;
import utilities.Constants;

public class Client implements Runnable{
	
	 public static String SERVER;
	 private static Client clientObject = null;
	 
	 public void startClient() throws Exception {
        ClientManager client = ClientManager.createClient();
        String message;

        // connect to server
        Scanner scanner = new Scanner(System.in);
        
        FaceMetricsPanel expressiveModelObserver = new FaceMetricsPanel();
        ExpressiveModelObservable.getExpressiveModelObservableInstance().addObserver(expressiveModelObserver);

        StringBuilder sb = new StringBuilder();
        sb.append(Constants.CONNECTIONSTRING_START);
        sb.append(ConnectionIpAndPortValues.getIpAddress());
        sb.append(":");
        sb.append(ConnectionIpAndPortValues.getPortAddress());
        sb.append(Constants.WS);
        sb.append(Constants.SERVER);
        SERVER = sb.toString();
        
        System.out.println(SERVER);
        
        Session session = client.connectToServer(ClientEndPoint.class, URI.create(SERVER));
        do {
        		message = scanner.nextLine();
        } while (!message.equalsIgnoreCase("quit"));
    }
	
	public static Client getClientInstance() {
		if(clientObject == null)
			clientObject = new Client();
		return clientObject;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			startClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
