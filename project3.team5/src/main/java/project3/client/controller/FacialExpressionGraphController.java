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
import org.jfree.ui.ApplicationFrame;

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
	
	public ChartPanel PlotFacialExpressionGraph() {
		
		JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
				createDataset(),
		PlotOrientation.VERTICAL, true, false, false);
		xyLineChart.removeLegend();
		
		ChartPanel chartPanel = new ChartPanel(xyLineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		
		plot = xyLineChart.getXYPlot();
		
		/*XYLineAnnotation line = new XYLineAnnotation(
			    x1, y, x2, y, new BasicStroke(2.0f), Color.black);
		plot.addAnnotation(line);
		
		//TODO Change X-Axis length with change in value
		NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
		xAxis.setRange(0.0, 30.0);
		plot.setRangeGridlinesVisible(false);
		
		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setRange(0.0, 5.0);
        yAxis.setTickUnit(new NumberTickUnit(0.5));
        plot.setDomainGridlinesVisible(false);*/
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);
		setContentPane(chartPanel);
		
		return chartPanel;
		
	}

	private XYDataset createDataset() {
		return null;
	}

}
