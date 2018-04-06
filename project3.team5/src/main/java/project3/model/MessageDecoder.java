package project3.model;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import project3.client.controller.ExpressiveModelObservable;
import project3.model.ExpressiveModel;

public class MessageDecoder implements Decoder.Text<ExpressiveModel> {
	 
    private static Gson gson = new Gson();
 
    @Override
    public ExpressiveModel decode(String s) throws DecodeException {
    	
        return gson.fromJson(s, ExpressiveModel.class);
    }
 
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }
 
    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }
 
    @Override
    public void destroy() {
        // Close resources
    }
}