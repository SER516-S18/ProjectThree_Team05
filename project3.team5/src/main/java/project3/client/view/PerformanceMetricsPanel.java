package project3.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import project3.client.controller.PerformanceMetricsTabController;
import project3.client.model.PerformanceMetricsTabModel;

public class PerformanceMetricsPanel extends JPanel {
	private JPanel performanceGraphPanel;
	private JPanel performanceColorPanel;
	/*private JComboBox<String> interestComboBox;
	private JComboBox<String> engagementComboBox;
	private JComboBox<String> stressComboBox;
	private JComboBox<String> relaxationComboBox;
	private JComboBox<String> excitementComboBox;
	private JComboBox<String> focusComboBox;*/
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
		this.setLayout(new GridLayout(1,2,8,8));
		this.setBorder(new EmptyBorder(8, 8, 8, 8));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
			
		performanceMetricsModel = new PerformanceMetricsTabModel();
		performanceMetricsModel.setDisplayLength(30);
		displayLength = performanceMetricsModel.getDisplayLength();
		
		performanceMetricsController = new PerformanceMetricsTabController("");
		performanceGraphPanel =  performanceMetricsController.PlotPerformanceGraph(displayLength);
		performanceMetricsController.pack();
		performanceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceGraphPanel.setPreferredSize(new Dimension(641, 483));
		performanceGraphPanel.setBackground(Color.white);
		setBackground(Color.WHITE);
		this.add(performanceGraphPanel);

		performanceColorPanel = new JPanel();
		performanceColorPanel.setPreferredSize(new Dimension(416, 478));
		performanceColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceColorPanel.setBackground(Color.WHITE);
		performanceColorPanel.setLayout(new GridLayout(4,2,30,4));
		
		/*interestComboBox = new JComboBox<String>(performanceMetricColors);
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
		add(focusComboBox);*/
		
		interestLabel = new JLabel("Interest",JLabel.CENTER);
		interestLabel.setPreferredSize(new Dimension(61, 16));
		performanceColorPanel.add(interestLabel);
		
		engagementLabel = new JLabel("Engagement",JLabel.CENTER);
		engagementLabel.setPreferredSize(new Dimension(77, 16));
		performanceColorPanel.add(engagementLabel);
		
		stressLabel = new JLabel("Stress",JLabel.CENTER);
		stressLabel.setPreferredSize(new Dimension(61, 16));
		performanceColorPanel.add(stressLabel);
		
		relaxationLabel = new JLabel("Relaxation",JLabel.CENTER);
		relaxationLabel.setPreferredSize(new Dimension(77, 16));
		performanceColorPanel.add(relaxationLabel);
		
		excitementLabel = new JLabel("Excitement",JLabel.CENTER);
		excitementLabel.setPreferredSize(new Dimension(74, 16));
		performanceColorPanel.add(excitementLabel);
		
		focusLabel = new JLabel("Focus",JLabel.CENTER);
		focusLabel.setPreferredSize(new Dimension (61, 16));
		performanceColorPanel.add(focusLabel);
		
		displayLengthLabel = new JLabel("Display Length",JLabel.CENTER);
		displayLengthLabel.setPreferredSize(new Dimension (94, 16));
		performanceColorPanel.add(displayLengthLabel);
		
		xAxisLength = new JTextField("30",JTextField.CENTER);
		xAxisLength.setSize(new Dimension (11, 26));
		performanceColorPanel.add(xAxisLength,JPanel.CENTER_ALIGNMENT);
		xAxisLength.setColumns(10);
		
		/*secondsLabel = new JLabel("Seconds");
		secondsLabel.setPreferredSize(new Dimension (61, 16));
		performanceColorPanel.add(secondsLabel);*/
		
		this.add(performanceColorPanel);
	}

}
