package project3.client.controller;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.Session;


import org.glassfish.tyrus.client.ClientManager;

public class Client {
	
	
	 public static final String SERVER = "ws://localhost:1726/ws/server";
	 
	public static void main(String[] args)  throws Exception {
		        ClientManager client = ClientManager.createClient();
		        String message;

		        // connect to server
		        Scanner scanner = new Scanner(System.in);
		      
		        Session session = client.connectToServer(ClientEndPoint.class, URI.create(SERVER));
	
		        do {
		        	message = scanner.nextLine();
		        } while (!message.equalsIgnoreCase("quit"));
		    }
	

}
