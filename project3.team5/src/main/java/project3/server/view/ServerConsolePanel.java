package project3.server.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class ServerConsolePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static ServerConsolePanel serverConsolePanel ;
	JButton clearConsolePanelButton;
    JTextArea consolePanelTextArea;
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 14);


   private ServerConsolePanel() {
        this.setBorder(new TitledBorder(null, "ConsolePanel", TitledBorder.LEADING, TitledBorder.TOP, FONT, null));        
        this.setBounds(11, 408, 474, 152);
        this.setLayout(null);
        
        clearConsolePanelButton = new JButton("Clear Log");
        clearConsolePanelButton.setBounds(140, 119, 171, 25);
        clearConsolePanelButton.setContentAreaFilled(false);
        clearConsolePanelButton.setOpaque(true);
        this.add(clearConsolePanelButton);
        
        consolePanelTextArea = new JTextArea(10,10);
        JScrollPane scrollPane = new JScrollPane (consolePanelTextArea, 
        		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        consolePanelTextArea.setEditable(false);
        consolePanelTextArea.setBounds(10, 26, 454, 86);
        consolePanelTextArea.setLineWrap(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        this.add(consolePanelTextArea);
        this.add(scrollPane);
        
        
        clearConsolePanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	consolePanelTextArea.setText("");
            }
        });
        
        
    }
   
    public static ServerConsolePanel getServerConsoleInstance()
    {
    	if(serverConsolePanel == null)
    	{
    		serverConsolePanel = new ServerConsolePanel();
    	}
    	
    	return serverConsolePanel;
    }
    
    public void SetConsoleLogMessage()
    {
    	consolePanelTextArea.setText("Show Errors Here!");
    }
    
    
    public void appendLogMessage(String message) {
        message = message + "\n";
        consolePanelTextArea.append(message);
     }
    
    public void displayLogMessages(Logger logger)
    {

    	
    }
}