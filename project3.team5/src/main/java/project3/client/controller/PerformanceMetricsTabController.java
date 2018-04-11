/**
 * @SER516 Project3_Team05
 */

package project3.client.controller;

import project3.model.ExpressiveModel;
import project3.model.GraphsPropertiesModel;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

/*
 * Plots the graph for performance metrics with the data it receives
 * from the server which are set by the user
 */
public class PerformanceMetricsTabController extends ApplicationFrame {
	private static final long serialVersionUID = 1L;
	private double xaxisStartValue = 0.0;
	private double xaxisEndValue;
	private double yaxisValue;
	private XYPlot plot;
	Color colorlist[] = new Color[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.MAGENTA };

	/*
	 * Constructor for PerformanceMetricsTabController that calls its super class constructor
	 * @param Title for the graph 
	 */
	public PerformanceMetricsTabController(String title) {
		super(title);

	}
	
	/*
	 * Generates a JFreeChart for performance data
	 * @param ArrayList of integer values
	 * @return this.xyLineChart
	 */
	public JFreeChart PlotPerformanceGraph(ExpressiveModel expressiveModel, double xAxisLength) {

		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "", createDataset(), PlotOrientation.VERTICAL,
				true, false, false);
		xyLineChart.removeLegend();

		plot = xyLineChart.getXYPlot();
		xaxisEndValue = xAxisLength;

		yaxisValue = expressiveModel.getInterest();
		XYLineAnnotation interestLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getInterestColor());
		plot.addAnnotation(interestLine);

		yaxisValue = expressiveModel.getEngagement();
		XYLineAnnotation engagementLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getEngagementColor());
		plot.addAnnotation(engagementLine);

		yaxisValue = expressiveModel.getStress();
		XYLineAnnotation stressLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getStressColor());
		plot.addAnnotation(stressLine);

		yaxisValue = expressiveModel.getRelaxation();
		XYLineAnnotation relaxationLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getRelaxationColor());
		plot.addAnnotation(relaxationLine);

		yaxisValue = expressiveModel.getExcitement();
		XYLineAnnotation excitementLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getExcitementColor());
		plot.addAnnotation(excitementLine);

		yaxisValue = expressiveModel.getFocus();
		XYLineAnnotation focusLine = new XYLineAnnotation(xaxisStartValue, yaxisValue, xaxisEndValue, yaxisValue,
				new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getFocusColor());
		plot.addAnnotation(focusLine);

		NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
		xAxis.setRange(0.0, xAxisLength);
		plot.setRangeGridlinesVisible(false);

		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		yAxis.setRange(0.0, 5.0);
		yAxis.setTickUnit(new NumberTickUnit(0.5));
		plot.setDomainGridlinesVisible(false);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);

		return xyLineChart;

	}

	private XYDataset createDataset() {
		return null;
	}

}
