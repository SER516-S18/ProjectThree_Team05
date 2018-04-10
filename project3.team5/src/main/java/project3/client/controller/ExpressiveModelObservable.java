package project3.client.controller;

import java.util.ArrayList;
import java.util.Observable;
import org.glassfish.grizzly.http.server.ServerConfiguration;

import project3.model.ExpressiveModel;
import project3.model.serverConfiguations;

public class ExpressiveModelObservable extends Observable{

	private ArrayList<ExpressiveModel> expressiveData;
	private ExpressiveModel expressiveModelValue;
	private static ExpressiveModelObservable expressiveModelObservableInstance ;
	
	private ExpressiveModelObservable()
	{
		expressiveData = new ArrayList<ExpressiveModel>();
	}
	
	public static ExpressiveModelObservable getExpressiveModelObservableInstance()
	{
		if(expressiveModelObservableInstance == null) {
			expressiveModelObservableInstance = new ExpressiveModelObservable();
		}
		return expressiveModelObservableInstance;
	}
	
	public void AddToListExpressiveModel(ExpressiveModel expressiveModel)
	{
		System.out.println("In add to list "+expressiveModel.getEngagement() + 
				"/Set auto repeat "+ expressiveModel.isAutoRepeat() + 
				" /Auto reset "+ expressiveModel.getEyeReset());
		
		this.expressiveData.add(expressiveModel);
//		if(serverConfiguations.getServerDataInstance().isAutoReset()) {
//			expressiveModel.setAutoReset(true);
//		}
		setChanged();
		this.notifyObservers(expressiveModel);
	}
	
	
}
