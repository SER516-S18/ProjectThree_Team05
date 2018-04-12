/**
 * @SER516 Project3_Team05
 */

package project3.server.view;

import project3.server.controller.Server;
import project3.server.controller.ServerEndPoint;
import project3.model.ServerConfigurations;
import project3.server.controller.DetectionController;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

/**
 * ServerUI builds the Server Window by placing all the modules in the JFrame
 * window. This window is the interface which collects all values to be sent to
 * the client for use.
 */

public class ServerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 16);

	/**
	 * * Constructor creates the UI for Server. Creates JFrame and other JSpinner
	 * elements which set the values for the Detection Controller Class Object. This
	 * is where the client picks up the values for graph and facial expressions
	 */
	public ServerUI() {

		ServerEndPoint serverEndPoint = ServerEndPoint.getServerEndPointInsctance();
		Server serverInstance = Server.getServerInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 30, 600, 700);
		setMinimumSize(new Dimension(470, 400));
		setTitle(" Server");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		SpinnerModel value_upperface = new SpinnerNumberModel(0, 0, 1.0, 0.1);
		SpinnerModel value_lowerface = new SpinnerNumberModel(0, 0, 1.0, 0.1);
		SpinnerModel value_time = new SpinnerNumberModel(0.25, 0.01, 10, 0.25);
		SpinnerModel value_metrics = new SpinnerNumberModel(0, 0, 1.0, 0.1);
		JSpinner spinner_upperface = new JSpinner(value_upperface);
		JSpinner spinner_lowerface = new JSpinner(value_lowerface);
		JSpinner spinner_time = new JSpinner(value_time);
		JSpinner spinner_metrics = new JSpinner(value_metrics);

		Choice choicemetrics = new Choice();
		Choice choiceupperface = new Choice();
		Choice choicelowerface = new Choice();
		Choice choiceeye = new Choice();

		JCheckBox chckbxNewCheckBox = new JCheckBox("Auto Reset");
		JCheckBox autoRepeatCheckBox = new JCheckBox("Auto Repeat", false);
		JButton eyerdbtnActive = new JButton("Activate");
		JButton buttonToggle = new JButton("Send");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 40 };
		panel.setLayout(gbl_panel);

		Border interaction = new TitledBorder(null, "Interaction", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border interactionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border interactionBorder = BorderFactory.createCompoundBorder(interactionMargin, interaction);
		panel.setBorder(interactionBorder);

		// creates spinner to generate numbers at required intervals.
		JLabel timeLabel = new JLabel("Time Interval (Sec): ");
		GridBagConstraints gbcTimeLabel = new GridBagConstraints();
		gbcTimeLabel.insets = new Insets(10, 10, 5, 5);
		gbcTimeLabel.gridx = 4;
		gbcTimeLabel.gridy = 2;
		panel.add(timeLabel, gbcTimeLabel);
		panel.add(spinner_time);

		GridBagConstraints gbc_timespinner = new GridBagConstraints();
		gbc_timespinner.insets = new Insets(10, 12, 5, 5);
		gbc_timespinner.ipady = 6;
		gbc_timespinner.gridx = 5;
		gbc_timespinner.gridy = 2;
		panel.add(spinner_time, gbc_timespinner);

		// Check box and Button

		GridBagConstraints gbc_chckbxAutoReset = new GridBagConstraints();
		gbc_chckbxAutoReset.insets = new Insets(10, 10, 10, 10);
		gbc_chckbxAutoReset.gridx = 5;
		gbc_chckbxAutoReset.gridy = 3;
		panel.add(autoRepeatCheckBox, gbc_chckbxAutoReset);
		autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		autoRepeatCheckBox.setEnabled(true);

		autoRepeatCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (autoRepeatCheckBox.isSelected()) {
					serverInstance.setAutoReset(autoRepeatCheckBox.isSelected());
					buttonToggle.setText("Start");
				} else {
					serverInstance.setAutoReset(autoRepeatCheckBox.isSelected());
					buttonToggle.setText("Send");
				}
			}
		});

		buttonToggle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DetectionController detectionController = new DetectionController(spinner_upperface, spinner_lowerface,
						spinner_time, spinner_metrics, choiceupperface, choicelowerface, choiceeye, choicemetrics,
						chckbxNewCheckBox, eyerdbtnActive, autoRepeatCheckBox);

				if (buttonToggle.getText().equals("Start")) {

					ServerConfigurations.getServerDataInstance().setServerStatus(true);
					buttonToggle.setText("Stop");
					autoRepeatCheckBox.setEnabled(false);
					serverEndPoint.startSendingValues(detectionController.emodel);
				} else if (buttonToggle.getText().equals("Stop")) {

					ServerConfigurations.getServerDataInstance().setServerStatus(false);
					buttonToggle.setText("Start");
					autoRepeatCheckBox.setEnabled(true);
					serverEndPoint.haltSendingValues();
				} else if (buttonToggle.getText().equals("Send")) {

					ServerConfigurations.getServerDataInstance().setServerStatus(true);
					autoRepeatCheckBox.setEnabled(true);
					serverEndPoint.startSendingValues(detectionController.emodel);
				}
			}
		});

		GridBagConstraints gbcSendButton = new GridBagConstraints();
		gbcSendButton.insets = new Insets(0, 5, 0, 5);
		gbcSendButton.ipadx = 10;
		gbcSendButton.ipady = 10;
		gbcSendButton.gridx = 8;
		gbcSendButton.gridy = 2;
		panel.add(buttonToggle, gbcSendButton);

		// Detection Panel
		JPanel detectionPanel = new JPanel();
		contentPane.add(detectionPanel, BorderLayout.CENTER);
		GridBagLayout gblDetectionPanel = new GridBagLayout();
		gblDetectionPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gblDetectionPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gblDetectionPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gblDetectionPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		detectionPanel.setLayout(gblDetectionPanel);

		Border detection = new TitledBorder(null, "Detection", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border detectionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border detectionBorder = BorderFactory.createCompoundBorder(detectionMargin, detection);
		detectionPanel.setBorder(detectionBorder);

		// Creating Upperface labels and options
		JLabel upperfaceLabel = new JLabel("Upper Face ");
		GridBagConstraints gbcUpperfaceLabel = new GridBagConstraints();
		gbcUpperfaceLabel.insets = new Insets(0, 0, 5, 5);
		gbcUpperfaceLabel.gridx = 1;
		gbcUpperfaceLabel.gridy = 2;
		detectionPanel.add(upperfaceLabel, gbcUpperfaceLabel);

		choiceupperface.add("Raise Brow");
		choiceupperface.add("Furrow Brow");

		GridBagConstraints gbcUpperfaceSpinner = new GridBagConstraints();
		gbcUpperfaceSpinner.insets = new Insets(0, 0, 5, 5);
		gbcUpperfaceSpinner.ipadx = 12;
		gbcUpperfaceSpinner.ipady = 6;
		gbcUpperfaceSpinner.gridx = 3;
		gbcUpperfaceSpinner.gridy = 2;
		detectionPanel.add(spinner_upperface, gbcUpperfaceSpinner);

		GridBagConstraints gbcUpperfacechoice = new GridBagConstraints();
		gbcUpperfacechoice.insets = new Insets(0, 0, 5, 5);
		gbcUpperfacechoice.gridx = 2;
		gbcUpperfacechoice.gridy = 2;
		detectionPanel.add(choiceupperface, gbcUpperfacechoice);

		// Adding lowerFace and its options
		JLabel lowerfaceLabel = new JLabel("Lower Face");
		GridBagConstraints gbcLowerfaceLabel = new GridBagConstraints();
		gbcLowerfaceLabel.insets = new Insets(0, 0, 5, 5);
		gbcLowerfaceLabel.gridx = 1;
		gbcLowerfaceLabel.gridy = 6;
		detectionPanel.add(lowerfaceLabel, gbcLowerfaceLabel);

		choicelowerface.add("Smile");
		choicelowerface.add("Clench");
		choicelowerface.add("Smirk Left");
		choicelowerface.add("Smirk Right");
		choicelowerface.add("Laugh");

		GridBagConstraints gbcLowerface = new GridBagConstraints();
		gbcLowerface.insets = new Insets(0, 0, 5, 5);
		gbcLowerface.ipadx = 12;
		gbcLowerface.ipady = 6;
		gbcLowerface.gridx = 3;
		gbcLowerface.gridy = 6;
		detectionPanel.add(spinner_lowerface, gbcLowerface);

		GridBagConstraints gbcLowerfaceChoice = new GridBagConstraints();
		gbcLowerfaceChoice.insets = new Insets(0, 0, 5, 5);
		gbcLowerfaceChoice.gridx = 2;
		gbcLowerfaceChoice.gridy = 6;
		detectionPanel.add(choicelowerface, gbcLowerfaceChoice);

		// Creating Radio Active button
		GridBagConstraints gbcEyeButton = new GridBagConstraints();
		gbcEyeButton.insets = new Insets(0, 0, 5, 5);
		gbcEyeButton.gridx = 3;
		gbcEyeButton.gridy = 9;
		detectionPanel.add(eyerdbtnActive, gbcEyeButton);

		// Creating options
		choiceeye.add("Blink");
		choiceeye.add("Wink Left");
		choiceeye.add("Wink Right");
		choiceeye.add("Look Left");
		choiceeye.add("Look Right");

		GridBagConstraints gbcMetricsCheckBox = new GridBagConstraints();
		gbcMetricsCheckBox.insets = new Insets(0, 0, 5, 5);
		gbcMetricsCheckBox.gridx = 4;
		gbcMetricsCheckBox.gridy = 9;
		detectionPanel.add(chckbxNewCheckBox, gbcMetricsCheckBox);

		// Creating Eye Label
		JLabel eyeLabel = new JLabel("Eye");
		GridBagConstraints gbcEyeLabel = new GridBagConstraints();
		gbcEyeLabel.insets = new Insets(0, 0, 5, 5);
		gbcEyeLabel.gridx = 1;
		gbcEyeLabel.gridy = 9;
		detectionPanel.add(eyeLabel, gbcEyeLabel);

		GridBagConstraints gbcEyeChoice = new GridBagConstraints();
		gbcEyeChoice.insets = new Insets(0, 0, 5, 5);
		gbcEyeChoice.gridx = 2;
		gbcEyeChoice.gridy = 9;
		detectionPanel.add(choiceeye, gbcEyeChoice);

		// Performance Metrics added
		JLabel performanceMetricsLabel = new JLabel("Performance Metrics");
		performanceMetricsLabel.setForeground(Color.BLUE);
		GridBagConstraints gbcPerformanceMetrics = new GridBagConstraints();
		gbcPerformanceMetrics.insets = new Insets(0, 0, 5, 5);
		gbcPerformanceMetrics.gridwidth = 2;
		gbcPerformanceMetrics.gridx = 1;
		gbcPerformanceMetrics.gridy = 10;
		detectionPanel.add(performanceMetricsLabel, gbcPerformanceMetrics);

		choicemetrics.add("Interest");
		choicemetrics.add("Engagement");
		choicemetrics.add("Stress");
		choicemetrics.add("Relaxation");
		choicemetrics.add("Excitement");
		choicemetrics.add("Focus");

		GridBagConstraints gbcMetrics = new GridBagConstraints();
		gbcMetrics.insets = new Insets(0, 0, 5, 5);
		gbcMetrics.gridx = 3;
		gbcMetrics.gridy = 10;
		detectionPanel.add(choicemetrics, gbcMetrics);

		GridBagConstraints gbcMetricsSpinner = new GridBagConstraints();
		gbcMetricsSpinner.insets = new Insets(0, 0, 1, 1);
		gbcMetricsSpinner.ipadx = 12;
		gbcMetricsSpinner.ipady = 5;
		gbcMetricsSpinner.gridx = 4;
		gbcMetricsSpinner.gridy = 10;
		detectionPanel.add(spinner_metrics, gbcMetricsSpinner);

		// Console
		contentPane.add(ServerConsolePanel.getServerConsoleInstance(), BorderLayout.SOUTH);
		GridBagLayout gblConsolePanel = new GridBagLayout();
		gblConsolePanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gblConsolePanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100 };
		gblConsolePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gblConsolePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		ServerConsolePanel.getServerConsoleInstance().setLayout(gblConsolePanel);

		Border console = new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border consoleMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border consoleBorder = BorderFactory.createCompoundBorder(consoleMargin, console);
		ServerConsolePanel.getServerConsoleInstance().setBorder(consoleBorder);

	}
}
