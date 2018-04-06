package project3.client.controller;

import java.util.Observable;
import java.util.Observer;

public class ExpressiveModelObserver implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO update values (facial , performance , etc values)
		System.out.println("in Update");
	}

}
