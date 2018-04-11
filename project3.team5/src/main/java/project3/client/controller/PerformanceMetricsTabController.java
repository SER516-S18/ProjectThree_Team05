package project3.client.controller;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import project3.model.ExpressiveModel;
import project3.model.GraphsPropertiesModel;

public class PerformanceMetricsTabController extends ApplicationFrame{
	private static final long serialVersionUID = 1L;
	private XYSeries plotValues;
	double x1 = 0.0;
	double x2;
	double y;
	private XYPlot plot;
	Color colorlist[] = new Color[] { Color.RED, Color.GREEN, Color.BLUE, 
			Color.YELLOW, Color.PINK, Color.MAGENTA };
	
	public PerformanceMetricsTabController(String title) {
		super(title);
		
	}

	public JFreeChart PlotPerformanceGraph(ExpressiveModel expressiveModel, double xAxisLength) {
		
		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
				createDataset(),
		PlotOrientation.VERTICAL, true, false, false);
		xyLineChart.removeLegend();
		
		/*ChartPanel chartPanel = new ChartPanel(xyLineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(641, 483));*/
		
		plot = xyLineChart.getXYPlot();
		
		x2 = xAxisLength;
		//TODO add multiple graphs to show different performance metrics
		System.out.println(GraphsPropertiesModel.getGraphsPropertiesModelInstance().getInterestColor());
		y = expressiveModel.getInterest();
		XYLineAnnotation interestLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getInterestColor());
		//interestLine.se
		plot.addAnnotation(interestLine);
		
		
		
		y = expressiveModel.getEngagement();
		XYLineAnnotation engagementLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getEngagementColor());
		plot.addAnnotation(engagementLine);
		
		y = expressiveModel.getStress();
		XYLineAnnotation stressLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getStressColor());
		plot.addAnnotation(stressLine);
		
		y = expressiveModel.getRelaxation();
		XYLineAnnotation relaxationLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getRelaxationColor());
		plot.addAnnotation(relaxationLine);
		
		y = expressiveModel.getExcitement();
		XYLineAnnotation excitementLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getExcitementColor());
		plot.addAnnotation(excitementLine);
		
		y = expressiveModel.getFocus();
		XYLineAnnotation focusLine = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), GraphsPropertiesModel.getGraphsPropertiesModelInstance().getFocusColor());
		plot.addAnnotation(focusLine);
		
		//TODO Change X-Axis length with change in value
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
