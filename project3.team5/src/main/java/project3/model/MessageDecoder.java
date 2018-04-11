/**
 * @SER516 Project3_Team05
 */

package project3.model;

import project3.model.ExpressiveModel;
import com.google.gson.Gson;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/*
 *  Decodes the JSON values received from the server and saves it as an ExpressiveModel Object
 */
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
