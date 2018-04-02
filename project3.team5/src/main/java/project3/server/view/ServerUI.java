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
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Choice;

public class ServerUI extends JFrame {

	private JPanel contentPane;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 14);

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
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//creates the panel for Interaction
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 100};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		

		Border interaction = new TitledBorder(null, "Interaction", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border interactionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		Border interactionBorder = BorderFactory.createCompoundBorder(interactionMargin, interaction);
		panel.setBorder(interactionBorder);
		
		//creates spinner to genrerate numbers at required intervals.
		SpinnerModel value = new SpinnerNumberModel(0.25, 0.01, 10, 0.25);
		
		JLabel lblEmoti = new JLabel("Time Interval (Sec)");
		GridBagConstraints gbc_lblEmoti = new GridBagConstraints();
		gbc_lblEmoti.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmoti.gridx = 4;
		gbc_lblEmoti.gridy = 2;
		panel.add(lblEmoti, gbc_lblEmoti);
		JSpinner spinner = new JSpinner(value);
		panel.add(spinner);
		
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 6;
		gbc_spinner.gridy = 2;
		panel.add(spinner, gbc_spinner);
		
// Check box and Button

        JButton buttonToggle = new JButton("Send");
		
		JCheckBox autoRepeatCheckBox = new JCheckBox("Auto Repeat", false);
		GridBagConstraints gbc_chckbxAutoReset = new GridBagConstraints();
		gbc_chckbxAutoReset.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAutoReset.gridx = 4;
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
		GridBagConstraints gbc_tglbtnSend = new GridBagConstraints();
		gbc_tglbtnSend.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSend.gridx = 6;
		gbc_tglbtnSend.gridy = 3;
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
		JLabel lblUpperface = new JLabel("UpperFace");
		GridBagConstraints gbc_lblUpperface = new GridBagConstraints();
		gbc_lblUpperface.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpperface.gridx = 1;
		gbc_lblUpperface.gridy = 1;
		panel_1.add(lblUpperface, gbc_lblUpperface);
		
		Choice choice_2 = new Choice();
		choice_2.add("Raise Brow");
		choice_2.add("Furrow Brow");
				
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 1;
		panel_1.add(spinner_1, gbc_spinner_1);

		GridBagConstraints gbc_choice_2 = new GridBagConstraints();
		gbc_choice_2.gridwidth = 2;
		gbc_choice_2.insets = new Insets(0, 0, 5, 5);
		gbc_choice_2.gridx = 1;
		gbc_choice_2.gridy = 2;
		panel_1.add(choice_2, gbc_choice_2);

		//Adding lowerFace and its options
		JLabel lblLowerface = new JLabel("LowerFace");
		GridBagConstraints gbc_lblLowerface = new GridBagConstraints();
		gbc_lblLowerface.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowerface.gridx = 1;
		gbc_lblLowerface.gridy = 3;
		panel_1.add(lblLowerface, gbc_lblLowerface);
		
		Choice choice_3 = new Choice();
		choice_3.add("smile");
		choice_3.add("laugh");
		
		JSpinner spinner_2 = new JSpinner();
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.gridx = 2;
		gbc_spinner_2.gridy = 3;
		panel_1.add(spinner_2, gbc_spinner_2);
		GridBagConstraints gbc_choice_3 = new GridBagConstraints();
		gbc_choice_3.gridwidth = 2;
		gbc_choice_3.insets = new Insets(0, 0, 5, 5);
		gbc_choice_3.gridx = 1;
		gbc_choice_3.gridy = 4;
		panel_1.add(choice_3, gbc_choice_3);
		
		//Creating Radio Active button
		JRadioButton rdbtnActive = new JRadioButton("Active");
		GridBagConstraints gbc_rdbtnActive = new GridBagConstraints();
		gbc_rdbtnActive.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnActive.gridx = 2;
		gbc_rdbtnActive.gridy = 9;
		panel_1.add(rdbtnActive, gbc_rdbtnActive);
		
		//Creating options
		Choice choice_1 = new Choice();
		choice_1.add("Blink");
		choice_1.add("Wink Left");
		choice_1.add("Wink Right");
		choice_1.add("Look Left");
		choice_1.add("Look Right");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Auto Reset");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 9;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		//Creating Eye Label
		JLabel lblEye = new JLabel("Eye");
		GridBagConstraints gbc_lblEye = new GridBagConstraints();
		gbc_lblEye.insets = new Insets(0, 0, 5, 5);
		gbc_lblEye.gridx = 2;
		gbc_lblEye.gridy = 10;
		panel_1.add(lblEye, gbc_lblEye);
		
		GridBagConstraints gbc_choice_1 = new GridBagConstraints();
		gbc_choice_1.gridwidth = 3;
		gbc_choice_1.insets = new Insets(0, 0, 5, 0);
		gbc_choice_1.gridx = 3;
		gbc_choice_1.gridy = 10;
		panel_1.add(choice_1, gbc_choice_1);
		
		//Performance Metrics added
		JLabel lblPerformanceMetrics = new JLabel("Performance Metrics");
		GridBagConstraints gbc_lblPerformanceMetrics = new GridBagConstraints();
		gbc_lblPerformanceMetrics.insets = new Insets(0, 0, 0, 5);
		gbc_lblPerformanceMetrics.gridx = 1;
		gbc_lblPerformanceMetrics.gridy = 11;
		panel_1.add(lblPerformanceMetrics, gbc_lblPerformanceMetrics);
		
		Choice choice = new Choice();
		choice.add("OK");
		choice.add("Requires More Data");
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.insets = new Insets(0, 0, 0, 5);
		gbc_choice.gridx = 3;
		gbc_choice.gridy = 11;
		panel_1.add(choice, gbc_choice);

	}
}
