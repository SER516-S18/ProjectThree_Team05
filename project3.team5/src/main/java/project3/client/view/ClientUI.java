package project3.client.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Connect = new JButton("Connect");
		Connect.setBounds(863, 5, 117, 29);
		contentPane.add(Connect);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 41, 984, 528);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Facial Expressions", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 11, 310, 478);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(326, 11, 341, 478);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(677, 11, 292, 478);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(82, 35, 200, 26);
		
		panel_3.add(slider);
		
		JLabel lblBlink = new JLabel("Blink");
		lblBlink.setBounds(10, 40, 72, 14);
		panel_3.add(lblBlink);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(82, 72, 200, 26);
		panel_3.add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setBounds(82, 109, 200, 26);
		panel_3.add(slider_2);
		
		JSlider slider_3 = new JSlider();
		slider_3.setBounds(82, 146, 200, 26);
		panel_3.add(slider_3);
		
		JSlider slider_4 = new JSlider();
		slider_4.setBounds(82, 205, 200, 26);
		panel_3.add(slider_4);
		
		JSlider slider_5 = new JSlider();
		slider_5.setBounds(82, 242, 200, 26);
		panel_3.add(slider_5);
		
		JSlider slider_6 = new JSlider();
		slider_6.setBounds(82, 293, 200, 26);
		panel_3.add(slider_6);
		
		JSlider slider_7 = new JSlider();
		slider_7.setBounds(82, 330, 200, 26);
		panel_3.add(slider_7);
		
		JSlider slider_8 = new JSlider();
		slider_8.setBounds(82, 367, 200, 26);
		panel_3.add(slider_8);
		
		JSlider slider_9 = new JSlider();
		slider_9.setBounds(82, 404, 200, 26);
		panel_3.add(slider_9);
		
		JSlider slider_10 = new JSlider();
		slider_10.setBounds(82, 441, 200, 26);
		panel_3.add(slider_10);
		
		JLabel lblRightWink = new JLabel("Right Wink");
		lblRightWink.setBounds(10, 72, 72, 14);
		panel_3.add(lblRightWink);
		
		JLabel lblLeftWink = new JLabel("Left Wink");
		lblLeftWink.setBounds(10, 109, 72, 14);
		panel_3.add(lblLeftWink);
		
		JLabel lblLookRl = new JLabel("Look R/L");
		lblLookRl.setBounds(10, 146, 72, 14);
		panel_3.add(lblLookRl);
		
		JLabel lblFurrowBrow = new JLabel("Furrow Brow");
		lblFurrowBrow.setBounds(10, 205, 72, 14);
		panel_3.add(lblFurrowBrow);
		
		JLabel lblRaiseBrow = new JLabel("Raise Brow");
		lblRaiseBrow.setBounds(10, 242, 72, 14);
		panel_3.add(lblRaiseBrow);
		
		JLabel lblSmile = new JLabel("Smile");
		lblSmile.setBounds(10, 293, 72, 14);
		panel_3.add(lblSmile);
		
		JLabel lblClench = new JLabel("Clench");
		lblClench.setBounds(10, 330, 72, 14);
		panel_3.add(lblClench);
		
		JLabel lblLeftSmirk = new JLabel("Left Smirk");
		lblLeftSmirk.setBounds(10, 367, 72, 14);
		panel_3.add(lblLeftSmirk);
		
		JLabel lblRightSmirk = new JLabel("Right Smirk");
		lblRightSmirk.setBounds(10, 404, 72, 14);
		panel_3.add(lblRightSmirk);
		
		JLabel lblLaugh = new JLabel("Laugh");
		lblLaugh.setBounds(10, 441, 72, 14);
		panel_3.add(lblLaugh);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Performance Metrics", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(6, 6, 641, 483);
		panel_1.add(panel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(657, 34, 115, 27);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(834, 34, 108, 27);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(657, 100, 108, 27);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(834, 100, 108, 27);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(657, 163, 108, 27);
		panel_1.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(834, 163, 108, 27);
		panel_1.add(comboBox_5);
		
		JLabel lblInterest = new JLabel("Interest");
		lblInterest.setBounds(657, 18, 61, 16);
		panel_1.add(lblInterest);
		
		JLabel lblEngagement = new JLabel("Engagement");
		lblEngagement.setBounds(837, 18, 77, 16);
		panel_1.add(lblEngagement);
		
		JLabel lblStress = new JLabel(" Stress");
		lblStress.setBounds(666, 84, 61, 16);
		panel_1.add(lblStress);
		
		JLabel lblRelaxation = new JLabel("Relaxation");
		lblRelaxation.setBounds(837, 84, 77, 16);
		panel_1.add(lblRelaxation);
		
		JLabel lblExcitement = new JLabel("Excitement");
		lblExcitement.setBounds(665, 148, 74, 16);
		panel_1.add(lblExcitement);
		
		JLabel lblFocus = new JLabel("Focus");
		lblFocus.setBounds(834, 148, 61, 16);
		panel_1.add(lblFocus);
		
		JLabel lblDisplayLength = new JLabel("Display Length");
		lblDisplayLength.setBounds(700, 341, 94, 16);
		panel_1.add(lblDisplayLength);
		
		textField = new JTextField();
		textField.setBounds(804, 336, 91, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setBounds(908, 341, 61, 16);
		panel_1.add(lblSeconds);
		
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setBounds(731, 11, 39, 16);
		contentPane.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label = new JLabel("");
		label.setBounds(764, 11, 61, 16);
		contentPane.add(label);
	}
}
