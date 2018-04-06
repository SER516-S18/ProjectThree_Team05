package project3.model;

public class serverConfiguations {
	
	private  boolean autoReset = false;
	private  boolean sendOneTime = true;
	private static serverConfiguations serverConfig = new serverConfiguations();
	
	public boolean isAutoReset() {
		return this.autoReset;
	}
	public void setAutoReset(boolean autoResetValue) {
		this.autoReset = autoResetValue;
	}
	public boolean isSendOneTime() {
		return this.sendOneTime;
	}
	public void setSendOneTime(boolean sendOneTimeValue) {
		this.sendOneTime = sendOneTimeValue;
	}
		
	public  static serverConfiguations getServerDataInstance()
	{
		if(serverConfig == null)
			serverConfig = new serverConfiguations();
		
		return serverConfig;
	}
    
}
