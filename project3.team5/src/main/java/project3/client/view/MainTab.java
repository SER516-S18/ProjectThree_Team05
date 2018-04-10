package project3.client.view;

import java.awt.Color;

import javax.swing.JTabbedPane;

public class MainTab extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FaceMetricsPanel faceMetricsPanel;
	public MainTab()  {
		setBounds(6, 40, 1003, 548);
		setBackground(Color.WHITE);
		faceMetricsPanel = new FaceMetricsPanel();
		addTab("Facial Expressions", faceMetricsPanel);
		addTab("Performance Metrics",  new PerformanceMetricsPanel());

	}
	public FaceMetricsPanel setAsObserver() {
		return faceMetricsPanel;
	}
}
