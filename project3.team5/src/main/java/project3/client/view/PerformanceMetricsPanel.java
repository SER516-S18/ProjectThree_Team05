/**
 * @SER516 Project3_Team05
 */

package project3.client.view;

import project3.client.controller.PerformanceMetricsTabController;
import project3.model.ExpressiveModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartPanel;
import project3.client.controller.ClientExpression;
import project3.client.controller.PerformanceMetricsButtonController;
import project3.client.controller.PerformanceMetricsTabController;
import project3.model.ExpressiveModel;
import project3.model.GraphsPropertiesModel;

/*
 *  This class configures various elements in the Performance metrics tab in ClientUI
 */
public class PerformanceMetricsPanel extends JPanel implements Observer{
	public ChartPanel performanceGraphPanel;
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
	private ExpressiveModel expressiveModel = new ExpressiveModel();
	private String[] performanceMetricColors = new String[] { "Red", "Green", "Blue", "Yellow", "Pink", "Magenta" };
	double displayLength;
	PerformanceMetricsTabController performanceMetricsController = new PerformanceMetricsTabController("");

	public PerformanceMetricsPanel() {
		this.setLayout(new GridLayout(1, 2, 8, 8));
		this.setBorder(new EmptyBorder(8, 8, 8, 8));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
			

		performanceColorPanel = new JPanel();
		performanceColorPanel.setPreferredSize(new Dimension(900, 478));
		performanceColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceColorPanel.setBackground(Color.white);
		performanceColorPanel.setLayout(null);

		GridBagConstraints c = new GridBagConstraints();

		interestButton = new JButton("IN");
		interestButton.setBackground(Color.RED);
		interestButton.setBounds(100, 34, 70, 50);
		interestButton.setOpaque(true);
		interestButton.setBorderPainted(false);
		performanceColorPanel.add(interestButton, c);

		interestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		engagementButton = new JButton("EN");
		engagementButton.setBounds(180, 34, 70, 50);
		engagementButton.setBackground(Color.YELLOW);
		engagementButton.setOpaque(true);
		engagementButton.setBorderPainted(false);
		performanceColorPanel.add(engagementButton, c);

		stressButton = new JButton("ST");
		stressButton.setBounds(260, 34, 70, 50);
		stressButton.setBackground(Color.GRAY);
		stressButton.setOpaque(true);
		stressButton.setBorderPainted(false);
		performanceColorPanel.add(stressButton, c);

		relaxationButton = new JButton("RE");
		relaxationButton.setBounds(100, 89, 70, 50);
		relaxationButton.setBackground(Color.PINK);
		relaxationButton.setOpaque(true);
		relaxationButton.setBorderPainted(false);
		performanceColorPanel.add(relaxationButton, c);

		excitementButton = new JButton("EX");
		excitementButton.setBackground(Color.BLUE);
		excitementButton.setBounds(180, 89, 70, 50);
		excitementButton.setOpaque(true);
		excitementButton.setBorderPainted(false);
		performanceColorPanel.add(excitementButton, c);

		focusButton = new JButton("FO");
		focusButton.setBackground(Color.GREEN);
		focusButton.setBounds(260, 89, 70, 50);
		focusButton.setOpaque(true);
		focusButton.setBorderPainted(false);
		performanceColorPanel.add(focusButton, c);

		displayLengthLabel = new JLabel("Display Length", displayLengthLabel.CENTER);
		displayLengthLabel.setBounds(100, 300, 110, 26);
		performanceColorPanel.add(displayLengthLabel, c);

		xAxisLength = new JTextField("30", JTextField.CENTER);
		xAxisLength.setBounds(216, 300, 50, 26);
		xAxisLength.setColumns(10);
		performanceColorPanel.add(xAxisLength, c);

		secondsLabel = new JLabel("Seconds", secondsLabel.CENTER);
		secondsLabel.setBounds(276, 300, 61, 26);
		performanceColorPanel.add(secondsLabel, c);

		new PerformanceMetricsButtonListener(performanceColorPanel, interestButton, engagementButton, focusButton,
				stressButton, relaxationButton, excitementButton);
		this.add(performanceColorPanel, BorderLayout.NORTH);

		displayLength = GraphsPropertiesModel.getGraphsPropertiesModelInstance().getDisplayLength();
		
		
		performanceGraphPanel = new ChartPanel(null);
		performanceGraphPanel
				.setChart(performanceMetricsController.PlotPerformanceGraph(expressiveModel, displayLength));
		performanceMetricsController.pack();
		performanceGraphPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		setBackground(Color.WHITE);
		add(performanceGraphPanel);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.remove(performanceGraphPanel);
		expressiveModel = (ExpressiveModel) arg;
		performanceGraphPanel = new ChartPanel(null);
		performanceGraphPanel
				.setChart(performanceMetricsController.PlotPerformanceGraph(expressiveModel, displayLength));
		performanceMetricsController.pack();
		performanceGraphPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		setBackground(Color.WHITE);
		add(performanceGraphPanel);
	}
}
