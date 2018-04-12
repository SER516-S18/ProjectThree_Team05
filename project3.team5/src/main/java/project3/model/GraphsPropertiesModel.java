/*
 * SER516-Project3_Team05
 */
package project3.model;

import java.awt.Color;

/*
 * Model to display the graph of the values set in the server on the performance metrics panel
 */
public class GraphsPropertiesModel {

	private Color interestColor = Color.RED;
	private Color engagementColor = Color.YELLOW;
	private Color excitementColor = Color.BLUE;
	private Color focusColor = Color.GREEN;
	private Color stressColor = Color.GRAY;
	private Color relaxationColor = Color.PINK;
	private double displayLength = 30.0;
	private static GraphsPropertiesModel graphProperties;

	private GraphsPropertiesModel() {

	}

	/*
	 * to get the instance of the graph properties model created
	 * 
	 * @return graphProperties
	 */
	public static GraphsPropertiesModel getGraphsPropertiesModelInstance() {
		if (graphProperties == null) {
			graphProperties = new GraphsPropertiesModel();
		}
		return graphProperties;
	}

	/*
	 * The methods below will return the color set for the graph of each
	 * functionality
	 * 
	 * @return corresponding Color
	 */
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

	/*
	 * The methods below will set the graph color to the button color which is
	 * selected by the user
	 */
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
