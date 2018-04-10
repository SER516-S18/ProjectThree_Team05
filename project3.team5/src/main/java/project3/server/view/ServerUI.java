package project3.server.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project3.server.controller.DetectionController;

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

public class ServerUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 16);

	/**
	 * Launches the server UI application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ServerUI().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the UI for Server 
	 */
	public ServerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 30, 500, 550);
		setMinimumSize(new Dimension(470,400));
		setTitle(" Server");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SpinnerModel value_1 = new SpinnerNumberModel(0, 0, 1.0, 0.1); 
		SpinnerModel value_2 = new SpinnerNumberModel(0, 0, 1.0, 0.1); 
		SpinnerModel value_3 = new SpinnerNumberModel(0.25, 0.01, 10, 0.25);
		SpinnerModel value_4 = new SpinnerNumberModel(0, 0, 5.0, 0.5);
		JSpinner spinner_upperface = new JSpinner(value_1);
		JSpinner spinner_lowerface = new JSpinner(value_2);
		JSpinner spinnertimevalue = new JSpinner(value_3);
 		JSpinner spinner_metrics = new JSpinner(value_4);
		
		Choice choicemetrics = new Choice();
		Choice choiceupperface = new Choice();
		Choice choicelowerface = new Choice();
		Choice choiceeye = new Choice();
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Auto Reset");
		JCheckBox autoRepeatCheckBox = new JCheckBox("Auto Repeat", false);
		JButton eyerdbtnActive = new JButton("Activate");
		JButton buttonToggle = new JButton("Send");
		 
		//creates the panel for Interaction
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 40};
		//gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		

		Border interaction = new TitledBorder(null, "Interaction", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border interactionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border interactionBorder = BorderFactory.createCompoundBorder(interactionMargin, interaction);
		panel.setBorder(interactionBorder);
		
		//creates spinner to genrerate numbers at required intervals.
		JLabel lblEmoti = new JLabel("Time Interval (Sec): ");
		GridBagConstraints gbc_lblEmoti = new GridBagConstraints();
		gbc_lblEmoti.insets = new Insets(10, 10, 5, 5);
		gbc_lblEmoti.gridx = 4;
		gbc_lblEmoti.gridy = 2;
		panel.add(lblEmoti, gbc_lblEmoti);
		panel.add(spinnertimevalue);
		
		
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(10, 12, 5, 5);
		gbc_spinner.ipady = 6;
		gbc_spinner.gridx = 5;
		gbc_spinner.gridy = 2;
		panel.add(spinnertimevalue, gbc_spinner);
		
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
            	
            	//send value only once
            	
            	    if(autoRepeatCheckBox.isSelected()){
            	    	
            	        buttonToggle.setText("Start");
        	        	autoRepeatCheckBox.setEnabled(true);
            	        buttonToggle.addActionListener(new ActionListener() {

            	            @Override
            	            public void actionPerformed(ActionEvent e) {
            	            	if(buttonToggle.getText().equals("Start"))
            	            	{
            	            		// implement start functionality here
                	            	buttonToggle.setText("Stop");
                    	        	autoRepeatCheckBox.setEnabled(false);	
            	            	}
            	            	else
            	            	{

                	            	buttonToggle.setText("Start");
                    	        	autoRepeatCheckBox.setEnabled(true);
            	            	}
            	            }
            	        });
            	        
            	    
            	    }
            	    else {
            	    	buttonToggle.setText("Send");
            	    	autoRepeatCheckBox.setEnabled(true);
            	    }
            }
		});
		
		buttonToggle.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						DetectionController detectionController = new DetectionController(spinner_upperface, 
								spinner_lowerface, spinnertimevalue, spinner_metrics, 
								choiceupperface, choicelowerface, choiceeye, choicemetrics, 
								chckbxNewCheckBox, eyerdbtnActive, autoRepeatCheckBox);
						
					}
			
				});
		GridBagConstraints gbc_tglbtnSend = new GridBagConstraints();
		gbc_tglbtnSend.insets = new Insets(0, 5, 0, 5);
		gbc_tglbtnSend.ipadx = 10;
        gbc_tglbtnSend.ipady = 10;
		gbc_tglbtnSend.gridx = 8;
		gbc_tglbtnSend.gridy = 2;
		panel.add(buttonToggle, gbc_tglbtnSend);
		
		//Detection Panel
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		

		Border detection = new TitledBorder(null, "Detection", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border detectionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border detectionBorder = BorderFactory.createCompoundBorder(detectionMargin, detection);
		panel_1.setBorder(detectionBorder);
		
		//Creating Upperface labels and options
		JLabel lblUpperface = new JLabel("Upper Face ");
		GridBagConstraints gbc_lblUpperface = new GridBagConstraints();
		gbc_lblUpperface.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpperface.gridx = 1;
		gbc_lblUpperface.gridy = 2;
		panel_1.add(lblUpperface, gbc_lblUpperface);
		
		
		choiceupperface.add("Raise Brow");
		choiceupperface.add("Furrow Brow");
		
				
		
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.ipadx = 12;
		gbc_spinner_1.ipady = 6;
		gbc_spinner_1.gridx = 3;
		gbc_spinner_1.gridy = 2;
		panel_1.add(spinner_upperface, gbc_spinner_1);
		
		
		GridBagConstraints gbc_choice_2 = new GridBagConstraints();
		//gbc_choice_2.gridwidth = 2;
		gbc_choice_2.insets = new Insets(0, 0, 5, 5);
		gbc_choice_2.gridx = 2;
		gbc_choice_2.gridy = 2;
		panel_1.add(choiceupperface, gbc_choice_2);

		//Adding lowerFace and its options
		JLabel lblLowerface = new JLabel("Lower Face");
		GridBagConstraints gbc_lblLowerface = new GridBagConstraints();
		gbc_lblLowerface.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowerface.gridx = 1;
		gbc_lblLowerface.gridy = 6;
		panel_1.add(lblLowerface, gbc_lblLowerface);
		
		choicelowerface.add("Smile");
		choicelowerface.add("Clench");
		choicelowerface.add("Smirk Left");
		choicelowerface.add("Smirk Right");
		choicelowerface.add("Laugh");
		
	
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.ipadx = 12;
		gbc_spinner_2.ipady = 6;
		gbc_spinner_2.gridx = 3;
		gbc_spinner_2.gridy = 6;
		panel_1.add(spinner_lowerface, gbc_spinner_2);
		GridBagConstraints gbc_choice_3 = new GridBagConstraints();
		//gbc_choice_3.gridwidth = 2;
		gbc_choice_3.insets = new Insets(0, 0, 5, 5);
		gbc_choice_3.gridx = 2;
		gbc_choice_3.gridy = 6;
		panel_1.add(choicelowerface, gbc_choice_3);
		
		
		//Creating Radio Active button
		GridBagConstraints gbc_rdbtnActive = new GridBagConstraints();
		gbc_rdbtnActive.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnActive.gridx = 3;
		gbc_rdbtnActive.gridy = 9;
		panel_1.add(eyerdbtnActive, gbc_rdbtnActive);
		
		//Creating options
		choiceeye.add("Blink");
		choiceeye.add("Wink Left");
		choiceeye.add("Wink Right");
		choiceeye.add("Look Left");
		choiceeye.add("Look Right");
		
		
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 4;
		gbc_chckbxNewCheckBox.gridy = 9;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		//Creating Eye Label
		JLabel lblEye = new JLabel("Eye");
		GridBagConstraints gbc_lblEye = new GridBagConstraints();
		gbc_lblEye.insets = new Insets(0, 0, 5, 5);
		gbc_lblEye.gridx = 1;
		gbc_lblEye.gridy = 9;
		panel_1.add(lblEye, gbc_lblEye);
		
		GridBagConstraints gbc_choice_1 = new GridBagConstraints();
		//gbc_choice_1.gridwidth = 3;
		gbc_choice_1.insets = new Insets(0, 0, 5, 5);
		gbc_choice_1.gridx = 2;
		gbc_choice_1.gridy = 9;
		panel_1.add(choiceeye, gbc_choice_1);
		
		//Performance Metrics added
 		JLabel lblPerformanceMetrics = new JLabel("Performance Metrics");
 		lblPerformanceMetrics.setForeground(Color.BLUE);
 		GridBagConstraints gbc_lblPerformanceMetrics = new GridBagConstraints();
 		gbc_lblPerformanceMetrics.insets = new Insets(0, 0, 5, 5);
 		gbc_lblPerformanceMetrics.gridwidth = 2;
 		gbc_lblPerformanceMetrics.gridx = 1;
 		gbc_lblPerformanceMetrics.gridy = 10;
 		panel_1.add(lblPerformanceMetrics, gbc_lblPerformanceMetrics);
 		
 		choicemetrics.add("Interest");
 		choicemetrics.add("Engagement");
 		choicemetrics.add("Stress");
 		choicemetrics.add("Relaxation");
 		choicemetrics.add("Excitement");
 		choicemetrics.add("Focus");

 		GridBagConstraints gbc_choice = new GridBagConstraints();
 		gbc_choice.insets = new Insets(0, 0, 5, 5);
 		gbc_choice.gridx = 3;
 		gbc_choice.gridy = 10;
 		panel_1.add(choicemetrics, gbc_choice);
 
 		
 		GridBagConstraints gbc_spinner_3 = new GridBagConstraints();
 		gbc_spinner_3.insets = new Insets(0, 0, 1, 1);
 		gbc_spinner_3.ipadx = 12;
 		gbc_spinner_3.ipady = 5;
 		gbc_spinner_3.gridx = 4;
 		gbc_spinner_3.gridy = 10;
 		panel_1.add(spinner_metrics, gbc_spinner_3);
 		

		
		//Console
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
				
		Border console = new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border consoleMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border consoleBorder = BorderFactory.createCompoundBorder(consoleMargin, console);
		panel_2.setBorder(consoleBorder);
	        // To Do add console log 
	}
}
