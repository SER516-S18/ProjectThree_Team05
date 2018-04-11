/**
 * @SER516 Project3_Team05
 */

package project3.model;

import java.util.Timer;

/*
 * This class tracks the rate at which the values are being sent 
 */
public class TimeStamp {
	private static Timer timer = new Timer();

	private double secondspassed;
	private double intialTime;

	public double getIntialTime() {
		return intialTime;
	}

	public void setIntialTime() {
		this.intialTime = this.intialTime + 1000;
	}

	public Timer gettimer() {
		return timer;
	}

	public double getSecondspassed() {
		return secondspassed;
	}

	public void setSecondspassed(double secondspassed2) {
		this.secondspassed = secondspassed2;
	}
}
