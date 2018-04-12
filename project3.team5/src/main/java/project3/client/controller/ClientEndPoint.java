/**
 * @SER516 Project3_Team05
 */

package project3.client.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.ClientEndpoint;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import project3.model.MessageDecoder;
import project3.model.MessageEncoder;
import project3.model.ExpressiveModel;

/*
 * Manipulates data received from the server
 * */
@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndPoint {

	/*
	 * Client receives data from the server and adds it to an array to plot graph
	 * and calculate performance
	 */
	private static Set<ClientEndPoint> chatEndpoints = new CopyOnWriteArraySet<>();

	/*
	 * On receiving the data, get an instance of the expressive model and add to it
	 */
	@OnMessage
	public void onMessage(ExpressiveModel message) {
		ExpressiveModelObservable.getExpressiveModelObservableInstance().AddToListExpressiveModel(message);
	}

	/*
	 * close connection by ending session
	 */
	@OnClose
	public void onClose(Session Session) throws IOException, EncodeException {
		chatEndpoints.remove(this);
		Session.close();
	}
}
