package project3.model;

public class ServerConfigurations {
	
	private boolean autoRepeat = false;
	private boolean sendOneTime = true;
	private static ServerConfigurations serverConfig = new ServerConfigurations();

	public boolean isServerStatus() {
		return isServerStatus;
	}
	public void setServerStatus(boolean isServerStatus) {
		this.isServerStatus = isServerStatus;
	}

	private boolean isServerStatus = false;
	
	public boolean isAutoRepeat() {
		return this.autoRepeat;
	}
	public void setAutoRepeat(boolean autoResetValue) {
		this.autoRepeat = autoResetValue;
	}
	public boolean isSendOneTime() {
		return this.sendOneTime;
	}
	public void setSendOneTime(boolean sendOneTimeValue) {
		this.sendOneTime = sendOneTimeValue;
	}
		
	public  static ServerConfigurations getServerDataInstance()
	{
		if(serverConfig == null)
			serverConfig = new ServerConfigurations();
		
		return serverConfig;
	}
    
}
