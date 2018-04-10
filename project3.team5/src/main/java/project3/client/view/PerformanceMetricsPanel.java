package project3.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import project3.client.controller.PerformanceMetricsButtonController;
import project3.client.controller.PerformanceMetricsTabController;
import project3.client.model.PerformanceMetricsTabModel;

public class PerformanceMetricsPanel extends JPanel {
	public JPanel performanceGraphPanel;
	public JPanel performanceColorPanel;
	public JButton interestButton;
	public JButton engagementButton;
	public JButton stressButton;
	public JButton relaxationButton;
	public JButton excitementButton;
	public JButton focusButton;
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
		performanceColorPanel.setPreferredSize(new Dimension(900, 478));
		performanceColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceColorPanel.setBackground(Color.white);
		performanceColorPanel.setLayout(null);
		
		GridBagConstraints c = new GridBagConstraints();
		
		interestButton = new JButton("IN");
		interestButton.setBackground(Color.red);
		interestButton.setBounds(100, 34, 50, 50);
		performanceColorPanel.add(interestButton, c);
		
		engagementButton = new JButton("EN");
		engagementButton.setBounds(155, 34, 50, 50);
		engagementButton.setBackground(Color.blue);
		performanceColorPanel.add(engagementButton, c);
		
		stressButton = new JButton("ST");
		stressButton.setBounds(210, 34, 50,50);
		stressButton.setBackground(Color.yellow);
		performanceColorPanel.add(stressButton, c);
		
		relaxationButton = new JButton("RE");
		relaxationButton.setBounds(100, 89,50,50);
		relaxationButton.setBackground(Color.pink);
		performanceColorPanel.add(relaxationButton, c);
		
		excitementButton = new JButton("EX");
		excitementButton.setBackground(Color.green);
		excitementButton.setBounds(155, 89, 50, 50);
		performanceColorPanel.add(excitementButton, c);
		
		focusButton = new JButton("FO");
		stressButton.setBackground(Color.gray);
		focusButton.setBounds(210, 89, 50,50);
		PerformanceMetricsButtonController performanceMBController=new PerformanceMetricsButtonController(performanceColorPanel,interestButton,engagementButton,focusButton,stressButton,relaxationButton,excitementButton);
		performanceColorPanel.add(focusButton, c); 
		
		
		
		displayLengthLabel = new JLabel("Display Length",displayLengthLabel.CENTER);
		displayLengthLabel.setBounds(100,470,110,26);
		performanceColorPanel.add(displayLengthLabel, c);
				
		xAxisLength = new JTextField("30",JTextField.CENTER);
		xAxisLength.setBounds(216,470,50,26);
		xAxisLength.setColumns(10);
		performanceColorPanel.add(xAxisLength,c);
		
		
		secondsLabel = new JLabel("Seconds",secondsLabel.CENTER);
		secondsLabel.setBounds(276,470,61,26);
		performanceColorPanel.add(secondsLabel, c);
		
		
		this.add(performanceColorPanel, BorderLayout.NORTH);
	}

}
