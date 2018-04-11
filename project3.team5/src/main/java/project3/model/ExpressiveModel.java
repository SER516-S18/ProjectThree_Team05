package project3.model;

public class ExpressiveModel {
	
	private int blink;
	private int rightWlink;
	private int leftWink;
	private int lookLeft;
	private int lookRight;
	private double raiseBrow;
	private double furrowBrow;
	private double smile;
	private double clench;
	private double smirkLeft;
	private double smirkRight;
	private double laugh;
	private double TimeStamp;
	private String gifLabel;
	private boolean eyeReset;
	private double Interest;
	private double Engagement;
	private double Stress;
	private double Relaxation;
	private double Excitement;
	private double Focus;
	private boolean autoRepeat;
	private boolean ServerStatus;

	public boolean isServerStatus() {
		return ServerStatus;
	}
	public void setServerStatus(boolean serverStatus) {
		ServerStatus = serverStatus;
	}
	public boolean isAutoRepeat() {
		return autoRepeat;
	}
	public void setAutoRepeat(boolean autoRepeat) {
		this.autoRepeat = autoRepeat;
	}
	  
    public double getTimeStamp() {
    		return TimeStamp;
	}
    public void setTimeStamp(double timeStamp) {
		TimeStamp = timeStamp;
	}
	public int getBlink() {
		return blink;
	}
	public void setBlink(int blink) {
		System.out.println(blink);
    	this.blink = blink;
	}
	public int getRightWlink() {
		return rightWlink;
	}
	public void setRightWlink(int rightWlink) {
		this.rightWlink = rightWlink;
	}
	public int getLeftWink() {
		return leftWink;
	}
	public void setLeftWink(int leftWink) {
		this.leftWink = leftWink;
		System.out.println(leftWink);
	}
	public int getLookLeft() {
		return lookLeft;
	}
	public void setLookLeft(int lookLeft) {
		this.lookLeft = lookLeft;
	}
	public int getLookRight() {
		return lookRight;
	}
	public void setLookRight(int lookRight) {
		this.lookRight = lookRight;
	}
	public double getRaiseBrow() {
		return raiseBrow;
	}
	public void setRaiseBrow(double raiseBrow) {
		this.raiseBrow = raiseBrow;
	}
	public double getFurrowBrow() {
		return furrowBrow;
	}
	public void setFurrowBrow(double furrowBrow) {
		this.furrowBrow = furrowBrow;
	}
	public double getSmile() {
		return smile;
	}
	public void setSmile(double smile) {
		this.smile = smile;
	}
	public double getClench() {
		return clench;
	}
	public void setClench(double clench) {
		this.clench = clench;
	}
	public double getSmirkLeft() {
		return smirkLeft;
	}
	public void setSmirkLeft(double smirkLeft) {
		this.smirkLeft = smirkLeft;
	}
	public double getSmirkRight() {
		return smirkRight;
	}
	public void setSmirkRight(double smirkRight) {
		this.smirkRight = smirkRight;
	}
	public double getLaugh() {
		return laugh;
	}
	public void setLaugh(double laugh) {
		this.laugh = laugh;
	}

	public String getGifLabel() {
		return gifLabel;
	}

	public void setGifLabel(String gifLabel) {
		this.gifLabel = gifLabel;
	}
	public Boolean getEyeReset() {
		System.out.println("Eye Reset: " + eyeReset);
		return eyeReset;
	}
	public void setEyeReset(Boolean eyeReset) {
		this.eyeReset = eyeReset;
	}
	
	public double getInterest() {
		return Interest;
	}
	public void setInterest(double interest) {
		this.Interest = interest;
	}
	public double getEngagement() {
		return Engagement;
	}
	public void setEngagement(double engagement) {
		this.Engagement = engagement;
	}
	public double getStress() {
		return Stress;
	}
	public void setStress(double stress) {
		this.Stress = stress;
	}
	public double getRelaxation() {
		return Relaxation;
	}
	public void setRelaxation(double relaxation) {
		this.Relaxation = relaxation;
	}
	public double getExcitement() {
		return Excitement;
	}
	public void setExcitement(double excitement) {
		this.Excitement = excitement;
	}
	public double getFocus() {
		return Focus;
	}
	public void setFocus(double focus) {
		this.Focus = focus;
	}
}
