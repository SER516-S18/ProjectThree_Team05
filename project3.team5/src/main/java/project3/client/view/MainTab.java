/**
 * @SER516 Project3_Team05
 */

package project3.client.view;

import java.awt.Color;
import javax.swing.JTabbedPane;

/*
 * Defines the two tabs: Facial Expressions and Performance metrics
 * */
public class MainTab extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private FaceMetricsPanel faceMetricsPanel;
	private PerformanceMetricsPanel performanceMetricsPanel;

	/*
	 * The two tabs are added to the main Tab
	 */
	public MainTab() {
		setBounds(6, 40, 1003, 548);
		setBackground(Color.WHITE);
		faceMetricsPanel = new FaceMetricsPanel();
		performanceMetricsPanel = new PerformanceMetricsPanel();
		addTab("Facial Expressions", faceMetricsPanel);
		addTab("Performance Metrics", performanceMetricsPanel);
	}

	/*
	 * Set observer for face metrics panel
	 */
	public FaceMetricsPanel setAsObserver() {
		return faceMetricsPanel;
	}

	/*
	 * Set observer for Performance metrics panel
	 */
	public PerformanceMetricsPanel setPerformanceAsObserver() {
		return performanceMetricsPanel;
	}
}
