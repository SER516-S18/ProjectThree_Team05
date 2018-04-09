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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class ClientMenuBar extends JMenuBar{
	
	private JButton connectToServer;
	private JLabel clockLabel;
	private JLabel timeLabel;
	
	public ClientMenuBar(){
		JMenu clientMenu = new JMenu("Menu");
		this.add(clientMenu);
		
		clockLabel = new JLabel(new ImageIcon("res/clck.png"));
		clockLabel.setPreferredSize(new Dimension(45,45));
		this.add(clockLabel);
		
		timeLabel = new JLabel("");
		timeLabel.setPreferredSize(new Dimension(61,16));
		this.add(timeLabel);
		
		connectToServer = new JButton("Connect");
		connectToServer.setPreferredSize(new Dimension(100,25));
		this.add(connectToServer);		
		
	}

}
