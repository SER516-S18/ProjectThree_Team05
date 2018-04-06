package project3.client.controller;

import java.util.ArrayList;
import java.util.Observable;

import project3.model.ExpressiveModel;

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
		if(expressiveModelObservableInstance == null)
		{
			expressiveModelObservableInstance = new ExpressiveModelObservable();
		}
		return expressiveModelObservableInstance;
	}
	
	public void AddToListExpressiveModel(ExpressiveModel expressiveModel)
	{
		System.out.println("In add to list"+expressiveModel.getBlink() + expressiveModel.getFurrowBrow());
		expressiveModel.setBlink(1);
		this.expressiveData.add(expressiveModel);
		System.out.println(expressiveModel.getBlink());
		setChanged();
		this.notifyObservers(expressiveModel);
	}
	
	
}
