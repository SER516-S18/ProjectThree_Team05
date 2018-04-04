package project3.model;

import java.util.Timer;

public class TimeStamp {
	 private static  Timer timer = new Timer();
		
	  private int secondspassed;
	  private int intialTime ;
	 
	  public int getIntialTime() {
		return intialTime;
	  }
	  
	  public void setIntialTime() {
			this.intialTime = this.intialTime + 1000;
	  }
	  		 
	  public  Timer gettimer() {
			return timer;
	  }

	  public int getSecondspassed() {
		  	return secondspassed;
	  }

	  public void setSecondspassed(int secondspassed) {
		  this.secondspassed = secondspassed;
	  }
}
