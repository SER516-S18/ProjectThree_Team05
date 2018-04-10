package project3.client.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project3.client.controller.Client;
import project3.model.ConnectionIpAndPortValues;
import project3.server.controller.Server;
import project3.server.view.ServerUI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class ClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainTab mainTab;
	private ClientMenuBar menuBar = new ClientMenuBar();
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
		this.setTitle("Client");
		this.setSize(new Dimension(1200,800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
        //this.setOpaque(false);
        //this.setBorder(new EmptyBorder(0, 8, 8, 8));
        this.add(menuBar , BorderLayout.BEFORE_FIRST_LINE);
        
        
        /**
		 * Creates Menu with Application and conn
		 * */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 698, 22);
		add(menuBar);
		
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
		this.add(menuBar , BorderLayout.BEFORE_FIRST_LINE);
		
		JPanel panelBuffer = new JPanel(new GridLayout(1, 2, 8, 8));
        panelBuffer.setBorder(BorderFactory.createLineBorder(Color.black));
        
        mainTab = new MainTab();
        panelBuffer.add(mainTab, BorderLayout.LINE_START);
        
        this.add(panelBuffer, BorderLayout.CENTER);
		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		serverConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField host = new JTextField();
				JTextField port = new JTextField();
				host.setText(ConnectionIpAndPortValues.getIpAddress());
				port.setText(String.valueOf(ConnectionIpAndPortValues.getPortAddress()));
				
				Object[] fields= {
						"Host Name", host,
						"Port", port
				};
				int optionValues = JOptionPane.showConfirmDialog(null, fields, "Connect To Server", JOptionPane.OK_CANCEL_OPTION);
				switch (optionValues) {
				case 0:
					System.out.println("Connect to Server");
					Server server = Server.getServerInstance();
					ConnectionIpAndPortValues.setIpAddress(host.getText());
					ConnectionIpAndPortValues.setPortAddress(Integer.parseInt(port.getText()));
					
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
	}
	public static MainTab setObserver() {
		return mainTab;
	}
}
