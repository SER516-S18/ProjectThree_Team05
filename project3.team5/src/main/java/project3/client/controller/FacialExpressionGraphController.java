/**
 * @SER516 Project3_Team05
 */

package project3.client.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/*
 * Plots the graph for facial expression with the data it receives
 */
public class FacialExpressionGraphController extends ApplicationFrame{
	private static final long serialVersionUID = 1L;
	private XYSeries plotValues;
	private XYPlot plot;
	
	/*
	 * Constructor for FacialExpressionGraphController that calls its super class constructor
	 * @param Title for the graph
	 */
	public FacialExpressionGraphController(String title) {
		super(title);
	}
	
	/*
	 * Generates a JFreeChart for facial expression integer data
	 * @param ArrayList of integer values
	 * @return this.xyLineChart
	 */
	public JFreeChart PlotFacialExpressionIntegerGraph(ArrayList<Integer> receivedDataset) {
		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
				createIntegerDataset(receivedDataset),
		PlotOrientation.VERTICAL, true, false, false);
		xyLineChart.removeLegend();
		
		plot = xyLineChart.getXYPlot();
		
		NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
		xAxis.setTickLabelsVisible(false);
		plot.setRangeGridlinesVisible(false);
		
		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		yAxis.setTickLabelsVisible(false);
        plot.setDomainGridlinesVisible(false);
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(1.0f));
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);
		return xyLineChart;
	}

	/*
	 * Generates an XYSeries and adds it to a series collection
	 * @param ArrayList of integer values
	 * @return this.dataset
	 */
	private XYDataset createIntegerDataset(ArrayList<Integer> receivedDataset) {
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		plotValues = new XYSeries("");
		for(int i = 0; i < receivedDataset.size(); i++) {
			plotValues.add(receivedDataset.get(i), receivedDataset.get(i) );
		}
		dataset.addSeries(plotValues);
		return dataset;
	}
	
	/*
	 * Generates a JFreeChart for facial expression double data
	 * @param ArrayList of double values
	 * @return this.xyLineChart
	 */
	public JFreeChart PlotFacialExpressionDoubleGraph(ArrayList<Double> receivedDataset) {
		
		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
				createDoubleDataset(receivedDataset),
		PlotOrientation.VERTICAL, true, false, false);
		xyLineChart.removeLegend();
		
		plot = xyLineChart.getXYPlot();
		
		NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
		xAxis.setTickLabelsVisible(false);
		plot.setRangeGridlinesVisible(false);
		
		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		yAxis.setTickLabelsVisible(false);
        plot.setDomainGridlinesVisible(false);
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(1.0f));
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);
		return xyLineChart;
		
	}

	/*
	 * Generates an XYSeries and adds it to a series collection
	 * @param ArrayList of double values
	 * @return this.dataset
	 */
	private XYDataset createDoubleDataset(ArrayList<Double> receivedDataset) {
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		plotValues = new XYSeries("");
		for(int i = 0; i < receivedDataset.size(); i++) {
			plotValues.add(receivedDataset.get(i), receivedDataset.get(i) );
		}
		dataset.addSeries(plotValues);
		return dataset;
	}

}
