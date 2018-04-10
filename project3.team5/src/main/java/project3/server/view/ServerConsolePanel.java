package project3.server.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class ServerConsolePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton clearConsolePanelButton;
    JTextPane consolePanelTextPane;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 14);


    public ServerConsolePanel() {
        this.setBorder(new TitledBorder(null, "ConsolePanel", TitledBorder.LEADING, TitledBorder.TOP, FONT, null));        
        this.setBounds(11, 408, 474, 152);
        this.setLayout(null);
        
        clearConsolePanelButton = new JButton("Clear Console Panel");
        clearConsolePanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            }
        });
        
        clearConsolePanelButton.setBounds(140, 119, 171, 25);
        clearConsolePanelButton.setContentAreaFilled(false);
        clearConsolePanelButton.setOpaque(true);
        this.add(clearConsolePanelButton);
        
        consolePanelTextPane = new JTextPane();
        consolePanelTextPane.setEditable(false);
        consolePanelTextPane.setText("Show Errors Here!");
        consolePanelTextPane.setBounds(10, 26, 454, 86);
        this.add(consolePanelTextPane);
    }
}