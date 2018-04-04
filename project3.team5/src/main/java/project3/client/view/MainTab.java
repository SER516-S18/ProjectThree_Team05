package project3.client.view;

import java.awt.Color;

import javax.swing.JTabbedPane;

public class MainTab extends JTabbedPane {

	public MainTab()  {
		setBounds(6, 40, 1003, 548);
		setBackground(Color.WHITE);
		
		addTab("Facial Expressions", new FaceMetricsPanel());
		addTab("Performance Metrics",  new PerformanceMetricsPanel());

	}
}
