package project3.client.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JButton connectToServer;
	private JLabel clockLabel;
	private JLabel timeLabel;
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
		mainPanel.setBackground(Color.WHITE);
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		connectToServer = new JButton("Connect");
		connectToServer.setBounds(863, 15, 117, 29);
		mainPanel.add(connectToServer);
		
		mainPanel.add(new MainTab());
		clockLabel = new JLabel(new ImageIcon("res/clck.png"));
		clockLabel.setBounds(731, 5, 45, 45);
		mainPanel.add(clockLabel);
		clockLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		timeLabel = new JLabel("");
		timeLabel.setBounds(764, 11, 61, 16);
		mainPanel.add(timeLabel);
	}
}
