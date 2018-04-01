package project3.client.view;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollBar;

public class ClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JButton connectToServer;
	private JTabbedPane mainTab;
	private JPanel faceMetricsPanel;
	private JPanel facePanel;
	private JPanel faceGraphPanel;
	private JPanel faceFeaturesPanel;
	private JSlider blinkSlider;
	private JSlider rightWinkSlider;
	private JSlider leftWinkSlider;
	private JSlider lookRLSlider;
	private JSlider furrowBrowSlider;
	private JSlider raiseBrowSlider;
	private JSlider smileSlider;
	private JSlider clenchSlider;
	private JSlider leftSmirkSlider;
	private JSlider rightSmirkSlider;
	private JSlider laughSlider;
	private JLabel blinkLabel;
	private JLabel rightWinkLabel;
	private JLabel leftWinkLabel;
	private JLabel lookRLLabel;
	private JLabel furrowBrowLabel;
	private JLabel raiseBrowLabel;
	private JLabel smileLabel;
	private JLabel clenchLabel;
	private JLabel leftSmirkLabel;
	private JLabel rightSmirkLabel;
	private JLabel laughLabel;
	private JPanel performanceMetricsPanel;
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
	private JLabel clockLabel;
	private JLabel timeLabel;
	private String[] performanceMetricColors = new String[] { "Red", "Green", "Blue", "Yellow", "Pink", "Brown" };

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI clientMainFrame = new ClientUI();
					clientMainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public ClientUI() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 616);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		connectToServer = new JButton("Connect");
		connectToServer.setBounds(863, 15, 117, 29);
		mainPanel.add(connectToServer);
		
		mainTab =new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBounds(6, 40, 1003, 548);
		mainPanel.add(mainTab);
		
		faceMetricsPanel = new JPanel();
		faceMetricsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainTab.addTab("Facial Expressions", null, faceMetricsPanel, null);
		faceMetricsPanel.setLayout(null);
		
		facePanel = new JPanel();
		facePanel.setBounds(16, 11, 300, 478);
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		faceMetricsPanel.add(facePanel);
		
		faceGraphPanel = new JPanel();
		faceGraphPanel.setBounds(326, 11, 341, 478);
		faceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		faceMetricsPanel.add(faceGraphPanel);
		
		faceFeaturesPanel = new JPanel();
		faceFeaturesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		faceFeaturesPanel.setBounds(677, 11, 292, 478);
		faceMetricsPanel.add(faceFeaturesPanel);
		faceFeaturesPanel.setLayout(null);
		
		blinkSlider = new JSlider();
		blinkSlider.setBounds(96, 40, 195, 26);
		faceFeaturesPanel.add(blinkSlider);
		
		blinkLabel = new JLabel("Blink");
		blinkLabel.setBounds(10, 40, 86, 26);
		faceFeaturesPanel.add(blinkLabel);
		
		rightWinkSlider = new JSlider();
		rightWinkSlider.setBounds(96, 72, 195, 26);
		faceFeaturesPanel.add(rightWinkSlider);
		
		leftWinkSlider = new JSlider();
		leftWinkSlider.setBounds(96, 109, 195, 26);
		faceFeaturesPanel.add(leftWinkSlider);
		
		lookRLSlider = new JSlider();
		lookRLSlider.setBounds(96, 146, 195, 26);
		faceFeaturesPanel.add(lookRLSlider);
		
		furrowBrowSlider = new JSlider();
		furrowBrowSlider.setBounds(96, 205, 195, 26);
		faceFeaturesPanel.add(furrowBrowSlider);
		
		raiseBrowSlider = new JSlider();
		raiseBrowSlider.setBounds(96, 242, 195, 26);
		faceFeaturesPanel.add(raiseBrowSlider);
		
		smileSlider = new JSlider();
		smileSlider.setBounds(96, 293, 195, 26);
		faceFeaturesPanel.add(smileSlider);
		
		clenchSlider = new JSlider();
		clenchSlider.setBounds(96, 330, 195, 26);
		faceFeaturesPanel.add(clenchSlider);
		
		leftSmirkSlider = new JSlider();
		leftSmirkSlider.setBounds(96, 367, 195, 26);
		faceFeaturesPanel.add(leftSmirkSlider);
		
		rightSmirkSlider = new JSlider();
		rightSmirkSlider.setBounds(96, 404, 195, 26);
		faceFeaturesPanel.add(rightSmirkSlider);
		
		laughSlider = new JSlider();
		laughSlider.setBounds(96, 441, 195, 26);
		faceFeaturesPanel.add(laughSlider);
		
		rightWinkLabel = new JLabel("Right Wink");
		rightWinkLabel.setBounds(10, 72, 86, 26);
		faceFeaturesPanel.add(rightWinkLabel);
		
		leftWinkLabel = new JLabel("Left Wink");
		leftWinkLabel.setBounds(10, 109, 86, 26);
		faceFeaturesPanel.add(leftWinkLabel);
		
		lookRLLabel = new JLabel("Look R/L");
		lookRLLabel.setBounds(10, 146, 86, 26);
		faceFeaturesPanel.add(lookRLLabel);
		
		furrowBrowLabel = new JLabel("Furrow Brow");
		furrowBrowLabel.setBounds(10, 205, 86, 26);
		faceFeaturesPanel.add(furrowBrowLabel);
		
		raiseBrowLabel = new JLabel("Raise Brow");
		raiseBrowLabel.setBounds(10, 242, 86, 26);
		faceFeaturesPanel.add(raiseBrowLabel);
		
		smileLabel = new JLabel("Smile");
		smileLabel.setBounds(10, 293, 86, 26);
		faceFeaturesPanel.add(smileLabel);
		
		clenchLabel = new JLabel("Clench");
		clenchLabel.setBounds(10, 330, 86, 26);
		faceFeaturesPanel.add(clenchLabel);
		
		leftSmirkLabel = new JLabel("Left Smirk");
		leftSmirkLabel.setBounds(10, 367, 86, 26);
		faceFeaturesPanel.add(leftSmirkLabel);
		
		rightSmirkLabel = new JLabel("Right Smirk");
		rightSmirkLabel.setBounds(10, 404, 86, 26);
		faceFeaturesPanel.add(rightSmirkLabel);
		
		laughLabel = new JLabel("Laugh");
		laughLabel.setBounds(10, 441, 86, 26);
		faceFeaturesPanel.add(laughLabel);
		
		performanceMetricsPanel = new JPanel();
		mainTab.addTab("Performance Metrics", null, performanceMetricsPanel, null);
		performanceMetricsPanel.setLayout(null);
		
		performanceGraphPanel = new JPanel();
		performanceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		performanceGraphPanel.setBounds(6, 6, 641, 483);
		performanceMetricsPanel.add(performanceGraphPanel);
		
		interestComboBox = new JComboBox<String>(performanceMetricColors);
		interestComboBox.setSelectedIndex(0);
		interestComboBox.setBounds(657, 34, 115, 27);
		performanceMetricsPanel.add(interestComboBox);
		
		engagementComboBox = new JComboBox<String>(performanceMetricColors);
		engagementComboBox.setSelectedIndex(1);
		engagementComboBox.setBounds(834, 34, 108, 27);
		performanceMetricsPanel.add(engagementComboBox);
		
		stressComboBox = new JComboBox<String>(performanceMetricColors);
		stressComboBox.setSelectedIndex(2);
		stressComboBox.setBounds(657, 100, 108, 27);
		performanceMetricsPanel.add(stressComboBox);
		
		relaxationComboBox = new JComboBox<String>(performanceMetricColors);
		relaxationComboBox.setSelectedIndex(3);
		relaxationComboBox.setBounds(834, 100, 108, 27);
		performanceMetricsPanel.add(relaxationComboBox);
		
		excitementComboBox = new JComboBox<String>(performanceMetricColors);
		excitementComboBox.setSelectedIndex(4);
		excitementComboBox.setBounds(657, 163, 108, 27);
		performanceMetricsPanel.add(excitementComboBox);
		
		focusComboBox = new JComboBox<String>(performanceMetricColors);
		focusComboBox.setSelectedIndex(5);
		focusComboBox.setBounds(834, 163, 108, 27);
		performanceMetricsPanel.add(focusComboBox);
		
		interestLabel = new JLabel("Interest");
		interestLabel.setBounds(657, 18, 61, 16);
		performanceMetricsPanel.add(interestLabel);
		
		engagementLabel = new JLabel("Engagement");
		engagementLabel.setBounds(837, 18, 77, 16);
		performanceMetricsPanel.add(engagementLabel);
		
		stressLabel = new JLabel(" Stress");
		stressLabel.setBounds(666, 84, 61, 16);
		performanceMetricsPanel.add(stressLabel);
		
		relaxationLabel = new JLabel("Relaxation");
		relaxationLabel.setBounds(837, 84, 77, 16);
		performanceMetricsPanel.add(relaxationLabel);
		
		excitementLabel = new JLabel("Excitement");
		excitementLabel.setBounds(665, 148, 74, 16);
		performanceMetricsPanel.add(excitementLabel);
		
		focusLabel = new JLabel("Focus");
		focusLabel.setBounds(834, 148, 61, 16);
		performanceMetricsPanel.add(focusLabel);
		
		displayLengthLabel = new JLabel("Display Length");
		displayLengthLabel.setBounds(700, 341, 94, 16);
		performanceMetricsPanel.add(displayLengthLabel);
		
		xAxisLength = new JTextField("30");
		xAxisLength.setBounds(804, 336, 91, 26);
		performanceMetricsPanel.add(xAxisLength);
		xAxisLength.setColumns(10);
		
		secondsLabel = new JLabel("Seconds");
		secondsLabel.setBounds(908, 341, 61, 16);
		performanceMetricsPanel.add(secondsLabel);
		
		clockLabel = new JLabel("Time: ");
		clockLabel.setBounds(731, 11, 45, 45);
		mainPanel.add(clockLabel);
		clockLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		/*Image img = new ImageIcon(this.getClass().getResource("res/clck.png")).getImage();
		ImageIcon icon = new ImageIcon(img);
		clockLabel.setIcon(icon);*/
		
		timeLabel = new JLabel("");
		timeLabel.setBounds(764, 11, 61, 16);
		mainPanel.add(timeLabel);
	}
}
