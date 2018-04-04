package project3.model;

public class serverConfiguations {
	
	private boolean autoReset = false;
	private boolean sendOneTime = false;
	private serverConfiguations serverConfig = new serverConfiguations();
	
	public boolean isAutoReset() {
		return autoReset;
	}
	public void setAutoReset(boolean autoReset) {
		this.autoReset = autoReset;
	}
	public boolean isSendOneTime() {
		return sendOneTime;
	}
	public void setSendOneTime(boolean sendOneTime) {
		this.sendOneTime = sendOneTime;
	}
		
	public serverConfiguations getServerDataInstance()
	{
		return this.serverConfig;
	}
    
}
