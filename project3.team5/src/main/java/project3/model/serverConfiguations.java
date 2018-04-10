package project3.model;

public class serverConfiguations {
	
	private  boolean autoRepeat = false;
	private  boolean sendOneTime = true;
	private static serverConfiguations serverConfig = new serverConfiguations();
	
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
		
	public  static serverConfiguations getServerDataInstance()
	{
		if(serverConfig == null)
			serverConfig = new serverConfiguations();
		
		return serverConfig;
	}
    
}
