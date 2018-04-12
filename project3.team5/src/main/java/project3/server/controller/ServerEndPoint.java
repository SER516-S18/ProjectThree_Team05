/*
 * @SER516-Project3_Team05
 */

package project3.server.controller;

import project3.model.MessageDecoder;
import project3.model.MessageEncoder;
import project3.model.ExpressiveModel;
import project3.model.TimeStamp;
import project3.model.ServerConfigurations;
import project3.server.view.ServerConsolePanel;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
 * Manipulates data being sent by the server
 * */
@ServerEndpoint(value = "/server", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ServerEndPoint {

	private Session session;
	private static Set<ServerEndPoint> connections = new CopyOnWriteArraySet<>();
	private static ServerEndPoint serverEndPoint = new ServerEndPoint();
	private ExpressiveModel values = new ExpressiveModel();

	TimeStamp timeStamp = new TimeStamp();
	Timer time = new Timer();
	double secondspassed = 0.0;
	double timerOffset = 0.0;

	/*
	 * Returns object of ServerEndPoint class
	 */
	public static ServerEndPoint getServerEndPointInsctance() {
		if (serverEndPoint == null)
			serverEndPoint = new ServerEndPoint();

		return serverEndPoint;
	}

	/*
	 * opening the  connection by starting session
	 */
	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {
		this.session = session;
		connections.add(this);
	}

	/*
	 * close connection by ending session
	 */
	@OnClose
	public void onClose(Session Session) throws IOException, EncodeException {
		connections.remove(this);
		Session.close();
		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server has been Stopped");
		;
	}

	/*
	 * When there is an error in connection
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {

	}

	/*
	 * Displays the console based on the tasks being performed
	 */
	public TimerTask createNewTimerTask() {
		return new TimerTask() {
			public void run() {

				try {
					values.setServerStatus(true);
					broadcast(values);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block

					ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
				}

				secondspassed += timerOffset;
				timeStamp.setSecondspassed(secondspassed);
				timeStamp.setIntialTime();
			}
		};
	}

	/*
	 * Sends the data to client
	 */
	public void broadcast(ExpressiveModel values) throws IOException, EncodeException {

		connections.forEach(endpoint -> {
			synchronized (endpoint) {
				try {
					endpoint.session.getBasicRemote().sendObject(values);
				} catch (IOException | EncodeException e) {
					ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());

				}
			}
		});
	}

	/*
	 * Stops sending values when it is stooped by clicking the stop button
	 */
	public void haltSendingValues() {

		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server has stopped sending Values to client");
		values.setServerStatus(false);
		try {
			broadcast(values);
		} catch (IOException | EncodeException e) {
			ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());
		}
		this.time.cancel();
	}

	/*
	 * Starts sending values when autorepeat is checked
	 */
	public void startSendingValues(ExpressiveModel receivedValues) {
		this.values = receivedValues;
		timerOffset = values.getTimeStamp();
		ServerConsolePanel.getServerConsoleInstance().appendLogMessage("Server is sending Values to client");

		if (ServerConfigurations.getServerDataInstance().isServerStatus()) {
			if (ServerConfigurations.getServerDataInstance().isAutoRepeat()) {
				this.time = new Timer();
				time.scheduleAtFixedRate(createNewTimerTask(), (long) timeStamp.getIntialTime(), 5000);
			} else {
				values.setTimeStamp(timeStamp.getSecondspassed());
				secondspassed += timerOffset;
				timeStamp.setSecondspassed(secondspassed);
				ServerConfigurations.getServerDataInstance().setServerStatus(false);

				try {
					broadcast(values);
				} catch (IOException | EncodeException e) {
					ServerConsolePanel.getServerConsoleInstance().appendLogMessage(e.getMessage());

				}
			}
		}
	}
}
