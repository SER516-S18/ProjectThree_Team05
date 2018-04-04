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

@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndPoint {


    private static Set<ClientEndPoint> chatEndpoints  = new CopyOnWriteArraySet<>();
    @OnMessage
    public void onMessage(ExpressiveModel message) {
    	System.out.println("Timer:"+message.getTimeStamp());
    }

    @OnClose
	public void onClose(Session Session) throws IOException, EncodeException{
		
		chatEndpoints.remove(this);
		Session.close();
		System.out.println("Disconnected"+Session.isOpen());
      
    
	}
}