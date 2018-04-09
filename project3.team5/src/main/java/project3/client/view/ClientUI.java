package project3.client.view;


import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class ClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	/*private JPanel mainPanel;
	private JButton connectToServer;
	private JLabel clockLabel;
	private JLabel timeLabel;*/
	private MainTab mainTab;
	private ClientMenuBar menuBar = new ClientMenuBar();
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
        this.add(menuBar , BorderLayout.NORTH);
        JPanel panelBuffer = new JPanel(new GridLayout(1, 2, 8, 8));
        panelBuffer.setBorder(BorderFactory.createLineBorder(Color.black));
        
        mainTab = new MainTab();
        panelBuffer.add(mainTab, BorderLayout.LINE_START);
        
        this.add(panelBuffer, BorderLayout.CENTER);
        
        
        
		/*setBounds(100, 100, 1015, 616);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setBackground(Color.WHITE);
		setContentPane(mainPanel);
		this.setLayout(new BorderLayout());
		mainPanel.setLayout(null);
		
		JPanel panelBuffer = new JPanel(new GridLayout(1, 2, 8, 8));
        panelBuffer.setBorder(BorderFactory.createLineBorder(Color.black));

		
		connectToServer = new JButton("Connect");
		connectToServer.setPreferredSize(new Dimension(100,25));
        panelBuffer.add(connectToServer, BorderLayout.PAGE_START);
        //panelBuffer.add(mainPanel, BorderLayout.PAGE_END);


		//mainPanel.add(connectToServer);
		
		mainPanel.add(new MainTab());
		clockLabel = new JLabel(new ImageIcon("res/clck.png"));
		clockLabel.setPreferredSize(new Dimension(45,45));
		mainPanel.add(clockLabel);
		clockLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		timeLabel = new JLabel("");
		timeLabel.setPreferredSize(new Dimension(61,16));
		mainPanel.add(timeLabel);
		this.add(panelBuffer, BorderLayout.CENTER);*/
	}
}
