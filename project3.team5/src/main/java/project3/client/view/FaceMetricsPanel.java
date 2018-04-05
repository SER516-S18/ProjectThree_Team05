package project3.client.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		facePanel = new JPanel();
		facePanel.setBounds(16, 11, 416, 478);
		facePanel.setLayout(null);
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		facePanel.setBackground(Color.WHITE);
		facePanel.setLayout(null);
		add(facePanel);
		
		gifLabel = new JLabel(new ImageIcon("res/laugh.png"));
		gifLabel.setBounds(80, 110, 260, 260);
		facePanel.add(gifLabel);	
		
		clientExpression = new ClientExpression();
		expressionName = clientExpression.getExpression();
		if(expressionName!= null) {
			facePanel.remove(gifLabel);
			gifLabel = new JLabel(new ImageIcon("res/"+expressionName));
			gifLabel.setBounds(80, 110, 260, 260);
			facePanel.add(gifLabel);	
		}

		faceGraphPanel = new JPanel();
		faceGraphPanel.setBounds(459, 11, 529, 478);
		faceGraphPanel.setBackground(Color.WHITE);
		faceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(faceGraphPanel);

	}

}
