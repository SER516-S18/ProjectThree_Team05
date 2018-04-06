package project3.client.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project3.client.controller.Client;
import project3.server.controller.Server;
import project3.server.view.ServerUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
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

		/**
		 * Creates Menu with Application and conn
		 * */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 698, 22);
		mainPanel.add(menuBar);
		
		JMenu mainMenu = new JMenu("Menu");
		menuBar.add(mainMenu);
		
		JMenu menuApplication = new JMenu("Application");
		mainMenu.add(menuApplication);
		
		JMenu menuConnect = new JMenu("Connect");
		mainMenu.add(menuConnect);
		
		JMenuItem connectServer = new JMenuItem("Server");
		connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		menuApplication.add(connectServer);
		
		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		serverConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField host = new JTextField();
				JTextField port = new JTextField();
				
				Object[] fields= {
						"Host Name", host,
						"Port", port
				};
				int optionValues = JOptionPane.showConfirmDialog(null, fields, "Connect To Server", JOptionPane.OK_CANCEL_OPTION);
				switch (optionValues) {
				case 0:
					System.out.println("Connect to Server");
					Server server = Server.getServerInstance();
					Client client = Client.getClientInstance();
					Thread thread1 = new Thread(server);
					Thread thread2 = new Thread(client);
					thread1.start();
					thread2.start();
					break;
				case 1:
					System.out.println("Cancel");
					break;
				}
			}
		});
		menuConnect.add(serverConnect);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainMenu.add(menuExit);
		
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
