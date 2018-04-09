package project3.server.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Choice;



public class ServerUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 16);

	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUI frame = new ServerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 500, 800);

		setMinimumSize(new Dimension(470,550));

		setTitle(" Server");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();

		panel.setBounds(15, 16, 448, 152);
		contentPane.add(panel);
		panel.setLayout(null);

		
		Border interaction = new TitledBorder(null, "INTERACTION", TitledBorder.LEADING, TitledBorder.TOP, FONT, Color.GRAY);
		Border interactionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border interactionBorder = BorderFactory.createCompoundBorder(interactionMargin, interaction);

		panel.setBorder(interactionBorder);

		JLabel lblNewLabel = new JLabel("TIME INTERVAL (in secs)");
		lblNewLabel.setFont(FONT);
		lblNewLabel.setForeground(Color.blue);
		lblNewLabel.setBounds(57, 41, 252, 20);
		panel.add(lblNewLabel);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setBounds(256, 86, 115, 29);
		panel.add(btnSend);
		
		JCheckBox chckbxAutorepeat = new JCheckBox("AUTO-REPEAT",false);
		chckbxAutorepeat.setBounds(58, 86, 176, 29);
		chckbxAutorepeat.setEnabled(true);
		//--added
		chckbxAutorepeat.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
            		//send value only once
            	    if(chckbxAutorepeat.isSelected()){
            	    	btnSend.setText("Start");
            	    	chckbxAutorepeat.setEnabled(true);
            	    	btnSend.addActionListener(new ActionListener() {
            	            @Override
            	            public void actionPerformed(ActionEvent e) {
            	            	if(btnSend.getText().equals("Start"))
            	            	{
            	            		// implement start functionality here
            	            		btnSend.setText("Stop");
            	            		chckbxAutorepeat.setEnabled(false);	
            	            	}
            	            	else
            	            	{
            	            		btnSend.setText("Start");
            	            		chckbxAutorepeat.setEnabled(true);
            	            	}
            	            }
            	        });
            	    }
            	    else {
            	    	btnSend.setText("Send");
            	    	chckbxAutorepeat.setEnabled(true);
            	    }
            }
		});

		//--ends
		
		panel.add(chckbxAutorepeat);
		
		SpinnerModel value = new SpinnerNumberModel(0.25, 0.01, 10, 0.25);
		JSpinner spinner = new JSpinner(value);
		spinner.setBounds(306, 41, 56, 29);
		panel.add(spinner);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 184, 448, 429);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Border detection = new TitledBorder(null, "DETECTION", TitledBorder.LEADING, TitledBorder.TOP, FONT, Color.GRAY);
		Border detectionMargin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border detectionBorder = BorderFactory.createCompoundBorder(detectionMargin, detection);
		panel_1.setBorder(detectionBorder);
		

		JLabel lblNewLabel_1 = new JLabel("UPPERFACE");
		lblNewLabel_1.setBounds(35, 121, 95, 36);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(FONT);
		panel_1.add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.add("Raise Brow");
		choice.add("Furrow Brow");
		choice.setBounds(176, 121, 106, 26);
		panel_1.add(choice);
		
		SpinnerModel value_1 = new SpinnerNumberModel(0, 0, 1.0, 0.1);
		JSpinner spinner_1 = new JSpinner(value_1);
		spinner_1.setBounds(315, 121, 86, 26);
		panel_1.add(spinner_1);
		
		JLabel lblLowerface = new JLabel("LOWERFACE");
		lblLowerface.setBounds(35, 153, 105, 36);
		lblLowerface.setForeground(Color.BLUE);
		lblLowerface.setFont(FONT);
		panel_1.add(lblLowerface);

		
		Choice choice_1 = new Choice();
		choice_1.add("smile");
		choice_1.add("clench");
		choice_1.add("smirk left");
		choice_1.add("smirk right");
		choice_1.add("laugh");
		choice_1.setBounds(176, 163, 104, 43);
		panel_1.add(choice_1);
		

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(315, 163, 86, 26);
		panel_1.add(spinner_2);
		
		JLabel lblEye = new JLabel("EYE");
		lblEye.setForeground(Color.BLUE);
		lblEye.setFont(FONT);
		lblEye.setBounds(90, 205, 69, 20);
		panel_1.add(lblEye);
		
		Choice choice_2 = new Choice();
		choice_2.add("Blink");
		choice_2.add("Wink Left");
		choice_2.add("Wink Right");
		choice_2.add("Look Left");
		choice_2.add("Look Right");
		choice_2.setBounds(176, 199, 104, 26);
		panel_1.add(choice_2);
		
		JButton btnActivate = new JButton("ACTIVATE");
		btnActivate.setBounds(298, 201, 115, 29);
		panel_1.add(btnActivate);
		
		JCheckBox chckbxAutoreset = new JCheckBox("AUTO_RESET");
		chckbxAutoreset.setBounds(277, 242, 139, 29);
		panel_1.add(chckbxAutoreset);
		
		JLabel lblPerformanceMetrics = new JLabel("PERFORMANCE METRICS");
		lblPerformanceMetrics.setForeground(Color.BLUE);
		lblPerformanceMetrics.setFont(FONT);
		lblPerformanceMetrics.setBounds(30, 297, 240, 36);
		panel_1.add(lblPerformanceMetrics);
		
		Choice choice_3 = new Choice();
		choice_3.add("OK");
		choice_3.add("NOt enough data");
		choice_3.setBounds(275, 308, 149, 26);
		panel_1.add(choice_3);
		
		JLabel lblTimeinSeconds = new JLabel("TIME (in seconds)");
		lblTimeinSeconds.setForeground(Color.BLUE);
		lblTimeinSeconds.setFont(FONT);
		lblTimeinSeconds.setBounds(40, 57, 130, 20);
		panel_1.add(lblTimeinSeconds);
		
		textField = new JTextField("0.0");
		textField.setBounds(197, 54, 146, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(15, 609, 448, 119);
		contentPane.add(panel_2);
	
		Border console = new TitledBorder(null, "CONSOLE", TitledBorder.LEADING, TitledBorder.TOP, FONT, Color.GRAY);
		Border consoleMargin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border consoleBorder = BorderFactory.createCompoundBorder(consoleMargin, console);

		panel_2.setBorder(consoleBorder);

	}
}
