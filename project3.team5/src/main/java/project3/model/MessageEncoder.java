package project3.model;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import project3.model.ExpressiveModel;

public class MessageEncoder implements Encoder.Text<ExpressiveModel> {
	
	private static Gson gson = new Gson();
	
	@Override
	 public String encode(ExpressiveModel message) throws EncodeException {
        return gson.toJson(message);
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
