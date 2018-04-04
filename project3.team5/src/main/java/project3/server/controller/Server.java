package project3.server.controller;


import java.util.Scanner;
import javax.websocket.DeploymentException;

public class Server {

	public void Start() {
		org.glassfish.tyrus.server.Server server =
	            new org.glassfish.tyrus.server.Server("localhost", 1726, "/ws", ServerEndPoint.class);
	        try {
	            server.start();
	            System.out.println("Press any key to stop the server..");
	           new Scanner(System.in).nextLine();
	            
	        } catch (DeploymentException e) {
	            throw new RuntimeException(e);
	        } finally {
	            server.stop();
	        }

	}
	
	public static void main(String[] args) {
		
		Server server = new Server();
		server.Start();
		
	}

}
