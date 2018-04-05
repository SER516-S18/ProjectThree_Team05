package project3.server.controller;


import java.util.Scanner;
import javax.websocket.DeploymentException;

public class Server implements Runnable{

	public void Start() {
		
		org.glassfish.tyrus.server.Server server =
	            new org.glassfish.tyrus.server.Server("localhost", 1726, "/ws", ServerEndPoint.class);
		
		ServerEndPoint serverEndPoint = ServerEndPoint.getServerEndPointInsctance();
		
		Thread thread = new Thread(serverEndPoint);
		
	        try {
	            server.start();
	            thread.start();
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
		Thread thread1 = new Thread(server);
		thread1.start();
		
	}

	@Override
	public void run() {
		Start();
	}

}
