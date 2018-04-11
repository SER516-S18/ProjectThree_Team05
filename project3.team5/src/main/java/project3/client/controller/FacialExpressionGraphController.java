package project3.client.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import project3.model.ExpressiveModel;

public class FacialExpressionGraphController extends ApplicationFrame{

	private static final long serialVersionUID = 1L;
	private XYSeries plotValues;
	double x1 = 0.0;
	double x2 = 30.0;
	double y = 3.0;
	private XYPlot plot;
	public FacialExpressionGraphController(String title) {
		super(title);
	}
	
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
		//System.out.println("After getting double plot");
		return xyLineChart;
		
	}

	private XYDataset createIntegerDataset(ArrayList<Integer> receivedDataset) {
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		plotValues = new XYSeries("");
		for(int i = 0; i < receivedDataset.size(); i++) {
			plotValues.add(receivedDataset.get(i), receivedDataset.get(i) );
		}
		dataset.addSeries(plotValues);
		//System.out.println("In int create dataset");
		return dataset;
	}
	
public JFreeChart PlotFacialExpressionDoubleGraph(ArrayList<Double> receivedDataset) {
		
		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
				createDoubleDataset(receivedDataset),
		PlotOrientation.VERTICAL, true, false, false);
		xyLineChart.removeLegend();
		
		ChartPanel chartPanel = new ChartPanel(xyLineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		
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
		setContentPane(chartPanel);
		//System.out.println("After getting double plot");
		return xyLineChart;
		
	}

	private XYDataset createDoubleDataset(ArrayList<Double> receivedDataset) {
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		plotValues = new XYSeries("");
		for(int i = 0; i < receivedDataset.size(); i++) {
			//System.out.println("Size: "+ receivedDataset.size());
			plotValues.add(receivedDataset.get(i), receivedDataset.get(i) );
		}
		dataset.addSeries(plotValues);
		//System.out.println("In int create dataset");
		return dataset;
}

}
