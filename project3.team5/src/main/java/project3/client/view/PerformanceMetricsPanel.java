package project3.client.view;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project3.client.controller.PerformanceMetricsTabController;
import project3.client.model.PerformanceMetricsTabModel;

public class PerformanceMetricsPanel extends JPanel {
	private JPanel performanceGraphPanel;
	private JComboBox<String> interestComboBox;
	private JComboBox<String> engagementComboBox;
	private JComboBox<String> stressComboBox;
	private JComboBox<String> relaxationComboBox;
	private JComboBox<String> excitementComboBox;
	private JComboBox<String> focusComboBox;
	private JLabel interestLabel;
	private JLabel engagementLabel;
	private JLabel stressLabel;
	private JLabel relaxationLabel;
	private JLabel excitementLabel;
	private JLabel focusLabel;
	private JLabel displayLengthLabel;
	private JTextField xAxisLength;
	private JLabel secondsLabel;
	private String[] performanceMetricColors = new String[] { "Red", "Green", "Blue", "Yellow", "Pink", "Magenta" };
	int displayLength;
	PerformanceMetricsTabModel performanceMetricsModel;
	PerformanceMetricsTabController performanceMetricsController;

	
	public PerformanceMetricsPanel() {
		setLayout(null);
			
		performanceMetricsModel = new PerformanceMetricsTabModel();
		performanceMetricsModel.setDisplayLength(30);
		displayLength = performanceMetricsModel.getDisplayLength();
		
		performanceMetricsController = new PerformanceMetricsTabController("");
		performanceGraphPanel =  performanceMetricsController.PlotPerformanceGraph(displayLength);
		performanceMetricsController.pack();
		performanceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceGraphPanel.setBounds(6, 6, 641, 483);
		performanceGraphPanel.setBackground(Color.white);
		setBackground(Color.WHITE);
		add(performanceGraphPanel);
		
		interestComboBox = new JComboBox<String>(performanceMetricColors);
		interestComboBox.setSelectedIndex(0);
		interestComboBox.setBounds(657, 34, 115, 27);
		add(interestComboBox);
		
		engagementComboBox = new JComboBox<String>(performanceMetricColors);
		engagementComboBox.setSelectedIndex(1);
		engagementComboBox.setBounds(834, 34, 108, 27);
		add(engagementComboBox);
		
		stressComboBox = new JComboBox<String>(performanceMetricColors);
		stressComboBox.setSelectedIndex(2);
		stressComboBox.setBounds(657, 100, 108, 27);
		add(stressComboBox);
		
		relaxationComboBox = new JComboBox<String>(performanceMetricColors);
		relaxationComboBox.setSelectedIndex(3);
		relaxationComboBox.setBounds(834, 100, 108, 27);
		add(relaxationComboBox);
		
		excitementComboBox = new JComboBox<String>(performanceMetricColors);
		excitementComboBox.setSelectedIndex(4);
		excitementComboBox.setBounds(657, 163, 108, 27);
		add(excitementComboBox);
		
		focusComboBox = new JComboBox<String>(performanceMetricColors);
		focusComboBox.setSelectedIndex(5);
		focusComboBox.setBounds(834, 163, 108, 27);
		add(focusComboBox);
		
		interestLabel = new JLabel("Interest");
		interestLabel.setBounds(657, 18, 61, 16);
		add(interestLabel);
		
		engagementLabel = new JLabel("Engagement");
		engagementLabel.setBounds(837, 18, 77, 16);
		add(engagementLabel);
		
		stressLabel = new JLabel(" Stress");
		stressLabel.setBounds(666, 84, 61, 16);
		add(stressLabel);
		
		relaxationLabel = new JLabel("Relaxation");
		relaxationLabel.setBounds(837, 84, 77, 16);
		add(relaxationLabel);
		
		excitementLabel = new JLabel("Excitement");
		excitementLabel.setBounds(665, 148, 74, 16);
		add(excitementLabel);
		
		focusLabel = new JLabel("Focus");
		focusLabel.setBounds(834, 148, 61, 16);
		add(focusLabel);
		
		displayLengthLabel = new JLabel("Display Length");
		displayLengthLabel.setBounds(700, 341, 94, 16);
		add(displayLengthLabel);
		
		xAxisLength = new JTextField("30");
		xAxisLength.setBounds(804, 336, 91, 26);
		add(xAxisLength);
		xAxisLength.setColumns(10);
		
		secondsLabel = new JLabel("Seconds");
		secondsLabel.setBounds(908, 341, 61, 16);
		add(secondsLabel);
	}

}
