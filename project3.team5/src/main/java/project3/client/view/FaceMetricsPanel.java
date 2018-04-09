package project3.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import project3.client.controller.ClientExpression;

	

public class FaceMetricsPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JPanel facePanel;
		private JLabel gifLabel;
		private ClientExpression clientExpression;
		private String expressionName;
		private JPanel faceGraphPanel;
		
		
		public FaceMetricsPanel() {
		//setBorder(new LineBorder(new Color(0, 0, 0)));
		//setBackground(Color.WHITE);
		this.setLayout(new GridLayout(1,2,8,8));
		this.setBorder(new EmptyBorder(8, 8, 8, 8));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
        
		//JPanel panelBuffer = new JPanel(new GridLayout(1, 2, 8, 8));
        //panelBuffer.setBorder(BorderFactory.createLineBorder(Color.black));

		
		facePanel = new JPanel();
		//facePanel.setBounds(16, 11, 416, 478);
		//facePanel.setLayout(null);
		facePanel.setPreferredSize(new Dimension(416, 478));
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		facePanel.setBackground(Color.WHITE);
		facePanel.setLayout(new GridLayout(1,1,0,0));
		this.add(facePanel);
		//add(facePanel);
		
		gifLabel = new JLabel(new ImageIcon("res/laugh.png"));
		gifLabel.setPreferredSize(new Dimension(260, 260));
		facePanel.add(gifLabel);	
		
		clientExpression = new ClientExpression();
		expressionName = clientExpression.getExpression();
		if(expressionName!= null) {
			facePanel.remove(gifLabel);
			gifLabel = new JLabel(new ImageIcon("res/"+expressionName));
			gifLabel.setPreferredSize(new Dimension(260, 260));
			facePanel.add(gifLabel);	
		}

		faceGraphPanel = new JPanel();
		faceGraphPanel.setPreferredSize(new Dimension(529, 478));
		faceGraphPanel.setBackground(Color.WHITE);
		faceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(faceGraphPanel);

	}

}
