package project3.client.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Canvas;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ClientUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI frame = new ClientUI();
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
	public ClientUI() {
		setTitle("Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Connect = new JButton("Connect");
		Connect.setBounds(647, 6, 117, 29);
		contentPane.add(Connect);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 43, 758, 430);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Facial Expressions", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(6, 6, 206, 372);
		panel.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(224, 6, 206, 372);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(439, 6, 292, 372);
		panel.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("Blink            ");
		panel_5.add(lblNewLabel);
		
		JSlider slider_1 = new JSlider();
		panel_5.add(slider_1);
		
		JLabel lblNewLabel_1 = new JLabel("Right Wink   ");
		panel_5.add(lblNewLabel_1);
		
		JSlider slider_2 = new JSlider();
		panel_5.add(slider_2);
		
		JLabel lblNewLabel_2 = new JLabel("Left Wink     ");
		panel_5.add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		panel_5.add(slider);
		
		JLabel lblNewLabel_3 = new JLabel("Look R/L     ");
		panel_5.add(lblNewLabel_3);
		
		JSlider slider_4 = new JSlider();
		panel_5.add(slider_4);
		
		JLabel lblNewLabel_4 = new JLabel("Furrow Brow");
		panel_5.add(lblNewLabel_4);
		
		JSlider slider_5 = new JSlider();
		panel_5.add(slider_5);
		
		JLabel lblNewLabel_5 = new JLabel("Raise Brow  ");
		panel_5.add(lblNewLabel_5);
		
		JSlider slider_6 = new JSlider();
		panel_5.add(slider_6);
		
		JLabel lblNewLabel_6 = new JLabel("Smile           ");
		panel_5.add(lblNewLabel_6);
		
		JSlider slider_3 = new JSlider();
		panel_5.add(slider_3);
		
		JLabel lblNewLabel_7 = new JLabel("Clench         ");
		panel_5.add(lblNewLabel_7);
		
		JSlider slider_8 = new JSlider();
		panel_5.add(slider_8);
		
		JLabel lblNewLabel_8 = new JLabel("Left Smirk    ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_8);
		
		JSlider slider_9 = new JSlider();
		panel_5.add(slider_9);
		
		JLabel lblNewLabel_9 = new JLabel("Right Smirk  ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_9);
		
		JSlider slider_7 = new JSlider();
		panel_5.add(slider_7);
		
		JLabel lblNewLabel_10 = new JLabel("Laugh           ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_10);
		
		JSlider slider_10 = new JSlider();
		panel_5.add(slider_10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Performance Metrics", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(6, 6, 428, 372);
		panel_1.add(panel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(452, 34, 115, 27);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(607, 34, 108, 27);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(459, 100, 108, 27);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(607, 100, 108, 27);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(459, 163, 108, 27);
		panel_1.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(607, 163, 108, 27);
		panel_1.add(comboBox_5);
		
		JLabel lblInterest = new JLabel("Interest");
		lblInterest.setBounds(462, 18, 61, 16);
		panel_1.add(lblInterest);
		
		JLabel lblEngagement = new JLabel("Engagement");
		lblEngagement.setBounds(613, 18, 77, 16);
		panel_1.add(lblEngagement);
		
		JLabel lblStress = new JLabel(" Stress");
		lblStress.setBounds(462, 84, 61, 16);
		panel_1.add(lblStress);
		
		JLabel lblRelaxation = new JLabel("Relaxation");
		lblRelaxation.setBounds(617, 84, 77, 16);
		panel_1.add(lblRelaxation);
		
		JLabel lblExcitement = new JLabel("Excitement");
		lblExcitement.setBounds(469, 148, 74, 16);
		panel_1.add(lblExcitement);
		
		JLabel lblFocus = new JLabel("Focus");
		lblFocus.setBounds(617, 148, 61, 16);
		panel_1.add(lblFocus);
		
		JLabel lblDisplayLength = new JLabel("Display Length");
		lblDisplayLength.setBounds(452, 341, 94, 16);
		panel_1.add(lblDisplayLength);
		
		textField = new JTextField();
		textField.setBounds(551, 336, 91, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setBounds(654, 341, 61, 16);
		panel_1.add(lblSeconds);
		
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setBounds(506, 11, 39, 16);
		contentPane.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label = new JLabel("");
		label.setBounds(550, 11, 61, 16);
		contentPane.add(label);
	}
}
