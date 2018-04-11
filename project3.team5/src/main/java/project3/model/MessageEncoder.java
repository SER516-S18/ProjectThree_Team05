/**
 * @SER516 Project3_Team05
 */

package project3.model;

import project3.model.ExpressiveModel;
import com.google.gson.Gson;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/*
 *  Encodes the message in order to send values to the Client
 */
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
