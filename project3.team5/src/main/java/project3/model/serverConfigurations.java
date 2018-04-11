package project3.model;

public class serverConfigurations {
	
	private boolean autoRepeat = false;
	private boolean sendOneTime = true;
	private static serverConfigurations serverConfig = new serverConfigurations();

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
		
	public  static serverConfigurations getServerDataInstance()
	{
		if(serverConfig == null)
			serverConfig = new serverConfigurations();
		
		return serverConfig;
	}
    
}
