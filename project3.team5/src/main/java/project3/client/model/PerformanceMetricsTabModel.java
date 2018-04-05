package project3.client.model;
import java.awt.BasicStroke;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import com.sun.prism.paint.Color;
/*This class contains the model for the performance metrics tab*/

public class PerformanceMetricsTab {
 private double interest;
 private double engagement;
 private double relaxation;
 private double excitement;
 private double stress;
 private double focus;
 private double displayLength;
 
 public void setDisplayLength(int length) {
	 this.displayLength=length;
 }
 public double getDisplayLength() {
	 return displayLength;
 }
 public XYSeries drawInterest() {
	 final XYSeries interest = new XYSeries( "Interest" );
	 for(int i=0;i<displayLength;i++)
	 {
		 interest.add(displayLength, this.interest);
	 } 
	 return interest;	 
 }
 public XYSeries drawEngagement() {
	 final XYSeries engagement = new XYSeries( "" );
	 for(int i=0;i<displayLength;i++)
	 {
		 engagement.add(displayLength, this.engagement);
	 } 
	 return engagement;
	 
 }
 public XYSeries drawRelaxation() {
	 final XYSeries relaxation = new XYSeries( "" );
	 for(int i=0;i<displayLength;i++)
	 {
		 relaxation.add(displayLength, this.relaxation);
	 } 
	 return relaxation;	 
 }
 public XYSeries drawExcitement() {
	 final XYSeries excitement = new XYSeries( "excitement" );
	 for(int i=0;i<displayLength;i++)
	 {
		 excitement.add(displayLength, this.excitement);
	 } 
	 return excitement;	 
 }
 public XYSeries drawFocus() {
	 final XYSeries focus = new XYSeries( "focus" );
	 for(int i=0;i<displayLength;i++)
	 {
		 focus.add(displayLength, this.focus);
	 } 
	 return focus;	 
 }
 public XYSeries drawStress() {
	 final XYSeries stress = new XYSeries( "stress" );
	 for(int i=0;i<displayLength;i++)
	 {
		 stress.add(displayLength, this.stress);
	 } 
	 return stress;	 
 } 
}
