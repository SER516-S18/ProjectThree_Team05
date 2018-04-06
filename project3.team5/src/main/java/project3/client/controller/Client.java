package project3.client.controller;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.Session;


import org.glassfish.tyrus.client.ClientManager;

import project3.server.controller.Server;

public class Client implements Runnable{
	
	
	 public static final String SERVER = "ws://localhost:1726/ws/server";
	 private static Client clientObject = null;
	 
	public void startClient() throws Exception {
		        ClientManager client = ClientManager.createClient();
		        String message;

		        // connect to server
		        Scanner scanner = new Scanner(System.in);
		        
		        ExpressiveModelObserver expressiveModelObserver = new ExpressiveModelObserver();
		        ExpressiveModelObservable.getExpressiveModelObservableInstance().addObserver(expressiveModelObserver);
		      
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
