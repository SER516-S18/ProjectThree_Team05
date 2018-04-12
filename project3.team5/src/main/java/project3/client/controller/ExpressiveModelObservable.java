/**
 * @SER516 Project3_Team05
 */

package project3.client.controller;

import project3.model.ExpressiveModel;
import java.util.ArrayList;
import java.util.Observable;

/*
 * Implements observer pattern to notify observers of changed data 
 */
public class ExpressiveModelObservable extends Observable{

	private static ArrayList<ExpressiveModel> expressiveData;
	private static ExpressiveModelObservable expressiveModelObservableInstance ;
	
	/*
	 * Constructor for the ExpressiveModelObservable to initialize an ArrayList to store 
	 * data being sent from server
	 */
	private ExpressiveModelObservable() {
		expressiveData = new ArrayList<ExpressiveModel>();
	}
	
	/*
	 * Creates a singleton instance of the ExpressiveModelObservable class and checks if it is null 
	 * @return this.expressiveModelObservableInstance
	 */
	public static ExpressiveModelObservable getExpressiveModelObservableInstance() {
		if(expressiveModelObservableInstance == null) {
			expressiveModelObservableInstance = new ExpressiveModelObservable();
		}
		return expressiveModelObservableInstance;
	}
	
	/*
	 * Returns the data being sent from server in the form of an ArrayList 
	 * of ExpressiveModel object
	 * @return this.expressiveData
	 */
	public static ArrayList<ExpressiveModel> GetExpressiveData() {
		return expressiveData;
	}
	
	/*
	 * Notifies all the observers of the change in data
	 * @param ExpressiveModel object
	 */
	public void AddToListExpressiveModel(ExpressiveModel expressiveModel) {
		ExpressiveModelObservable.expressiveData.add(expressiveModel);
		setChanged();
		this.notifyObservers(expressiveModel);
	}
		
}