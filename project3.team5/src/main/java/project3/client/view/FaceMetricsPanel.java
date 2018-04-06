package project3.client.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project3.client.controller.ClientExpression;
import project3.model.ExpressiveModel;
	

public class FaceMetricsPanel extends JPanel implements Observer {
		private ExpressiveModel expressiveModel = new ExpressiveModel();
		private JPanel facePanel;
		private JLabel gifLabel;
		private ClientExpression clientExpression =  new ClientExpression();
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
		
		/*gifLabel = new JLabel(new ImageIcon("res/laugh.png"));
		gifLabel.setBounds(80, 110, 260, 260);
		facePanel.add(gifLabel);	
		*/
		
		expressionName = clientExpression.getExpressiveModel().getGifLabel();
		gifLabel = new JLabel(new ImageIcon(expressionName));
		gifLabel.setBounds(80, 110, 260, 260);
		facePanel.add(gifLabel);	
		

		faceGraphPanel = new JPanel();
		faceGraphPanel.setBounds(459, 11, 529, 478);
		faceGraphPanel.setBackground(Color.WHITE);
		faceGraphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(faceGraphPanel);

	}


		@Override
		public void update(Observable o, Object arg) {
			
			expressiveModel = (ExpressiveModel) arg;
			System.out.println("In update"+ expressiveModel.getBlink());
			expressionName = clientExpression.getExpression(expressiveModel);
			System.out.println("expression name"+ expressionName);
			if(expressionName!= null) {
				System.out.println("blah!");
				ImageIcon icon = new ImageIcon("res/"+expressionName);
				icon.getImage().flush();
				gifLabel.setIcon( icon );
				facePanel.add(gifLabel);	
				
			}
			
		}

}
