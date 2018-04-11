/**
 * @SER516 Project3_Team05
 */

package project3.client.view;

import java.awt.Color;
import javax.swing.JTabbedPane;

public class MainTab extends JTabbedPane {

	/**
	 * Configures main tab for ClientUI that consists of Facial Expressions and
	 * Performance metrics tabs
	 */
	private static final long serialVersionUID = 1L;
	private FaceMetricsPanel faceMetricsPanel;
	private PerformanceMetricsPanel performanceMetricsPanel;

	public MainTab() {
		setBounds(6, 40, 1003, 548);
		setBackground(Color.WHITE);
		faceMetricsPanel = new FaceMetricsPanel();
		performanceMetricsPanel = new PerformanceMetricsPanel();
		addTab("Facial Expressions", faceMetricsPanel);
		addTab("Performance Metrics", performanceMetricsPanel);

	}

	public FaceMetricsPanel setAsObserver() {
		return faceMetricsPanel;
	}

	public PerformanceMetricsPanel setPerformanceAsObserver() {
		return performanceMetricsPanel;
	}
}
