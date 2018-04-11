package project3.model;

import java.awt.Color;

public class GraphsPropertiesModel {

	private Color interestColor;
	private Color engagementColor;
	private Color excitementColor;
	private Color focusColor;
	private Color stressColor;
	private Color relaxationColor;
	private double displayLength;
	private static GraphsPropertiesModel graphProperties;
	
	private GraphsPropertiesModel() {
		
	}
	
	public static GraphsPropertiesModel getGraphsPropertiesModelInstance() {
		if(graphProperties == null) {
			graphProperties = new GraphsPropertiesModel();
		}
		return graphProperties;
	}
	public Color getInterestColor() {
		return interestColor;
	}
	public void setInterestColor(Color interestColor) {
		this.interestColor = interestColor;
	}
	public Color getEngagementColor() {
		return engagementColor;
	}
	public void setEngagementColor(Color engagementColor) {
		this.engagementColor = engagementColor;
	}
	public Color getExcitementColor() {
		return excitementColor;
	}
	public void setExcitementColor(Color excitementColor) {
		this.excitementColor = excitementColor;
	}
	public Color getFocusColor() {
		return focusColor;
	}
	public void setFocusColor(Color focusColor) {
		this.focusColor = focusColor;
	}
	public Color getStressColor() {
		return stressColor;
	}
	public void setStressColor(Color stressColor) {
		this.stressColor = stressColor;
	}
	public Color getRelaxationColor() {
		return relaxationColor;
	}
	public void setRelaxationColor(Color relaxationColor) {
		this.relaxationColor = relaxationColor;
	}
	public double getDisplayLength() {
		return displayLength;
	}
	public void setDisplayLength(double displayLength) {
		this.displayLength = displayLength;
	}
	
	
}
