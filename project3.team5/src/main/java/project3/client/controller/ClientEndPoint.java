/**
 * @SER516 Project3_Team05
 */
package project3.client.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Set;
import javax.websocket.ClientEndpoint;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import project3.model.ExpressiveModel;
import project3.model.MessageDecoder;
import project3.model.MessageEncoder;

/*
 * This class represents the client connection end point used to establish connection with the server
 */

@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndPoint {

	private static Set<ClientEndPoint> chatEndpoints = new CopyOnWriteArraySet<>();

	@OnMessage
	public void onMessage(ExpressiveModel message) {
		// Adding json data to Array list for plotting graph and calculate performance.
		ExpressiveModelObservable.getExpressiveModelObservableInstance().AddToListExpressiveModel(message);
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {
		chatEndpoints.remove(this);
		session.close();
		System.out.println("Disconnected" + session.isOpen());
	}
}
