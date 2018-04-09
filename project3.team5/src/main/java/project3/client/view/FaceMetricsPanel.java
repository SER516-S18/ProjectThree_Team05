package project3.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import project3.client.controller.ClientExpression;
import project3.client.controller.FacialExpressionGraphController;

	

public class FaceMetricsPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JPanel facePanel;
		private JLabel gifLabel;
		private ClientExpression clientExpression;
		private String expressionName;
		private JPanel graphPanel;
		private JPanel blinkGraphPanel;
		private JPanel rightWinkPanel;
		private JPanel leftWinkPanel;
		private JPanel lookRightPanel;
		private JPanel furrowBrowPanel;
		private JPanel raiseBrowPanel;
		private JPanel smilePanel;
		private JPanel clenchPanel;
		private JPanel leftSmirkPanel;
		private JPanel rightSmirkPanel;
		private JPanel laughPanel;
		private FacialExpressionGraphController facialExpressionGraphController;
		
			
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

		graphPanel = new JPanel();
		graphPanel.setPreferredSize(new Dimension(529, 478));
		graphPanel.setBackground(Color.WHITE);
		graphPanel.setLayout(new BorderLayout());
		graphPanel.setOpaque(false);
		graphPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panelBuffer = new JPanel(new GridLayout(11, 1, 0, 0));
		panelBuffer.setBackground(Color.GRAY);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		blinkGraphPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		Border blink = new TitledBorder(null, "Blink", TitledBorder.LEADING, TitledBorder.TOP);
		Border blinkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border blinkBorder = BorderFactory.createCompoundBorder(blinkMargin, blink);
		blinkGraphPanel.setBorder(blinkBorder);
		panelBuffer.add(blinkGraphPanel, BorderLayout.PAGE_START);
		
		/*blinkGraphPanel = new JPanel();
		Border blink = new TitledBorder(null, "Blink", TitledBorder.LEADING, TitledBorder.TOP);
		Border blinkMargin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border blinkBorder = BorderFactory.createCompoundBorder(blinkMargin, blink);
		blinkGraphPanel.setBorder(blinkBorder);
		panelBuffer.add(blinkGraphPanel, BorderLayout.PAGE_START);*/
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		rightWinkPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//rightWinkPanel = new JPanel();
		Border rightWink = new TitledBorder(null, "Right Wink", TitledBorder.LEADING, TitledBorder.TOP);
		Border rightWinkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border rightWinkBorder = BorderFactory.createCompoundBorder(rightWinkMargin, rightWink);
		rightWinkPanel.setBorder(rightWinkBorder);
		panelBuffer.add(rightWinkPanel, BorderLayout.CENTER);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		leftWinkPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//leftWinkPanel = new JPanel();
		Border leftWink = new TitledBorder(null, "Left Wink", TitledBorder.LEADING, TitledBorder.TOP);
		Border leftWinkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border leftWinkBorder = BorderFactory.createCompoundBorder(leftWinkMargin, leftWink);
		leftWinkPanel.setBorder(leftWinkBorder);
		panelBuffer.add(leftWinkPanel, BorderLayout.PAGE_START);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		lookRightPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//lookRightPanel = new JPanel();
		Border lookRight = new TitledBorder(null, "Look Right/Left", TitledBorder.LEADING, TitledBorder.TOP);
		Border lookRightMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border lookRightBorder = BorderFactory.createCompoundBorder(lookRightMargin, lookRight);
		lookRightPanel.setBorder(lookRightBorder);
		panelBuffer.add(lookRightPanel, BorderLayout.CENTER);
		
		/*lookLeftPanel = new JPanel();
		Border lookLeft = new TitledBorder(null, "Look Left", TitledBorder.LEADING, TitledBorder.TOP);
		Border lookLeftMargin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border lookLeftBorder = BorderFactory.createCompoundBorder(lookLeftMargin, lookLeft);
		lookLeftPanel.setBorder(lookLeftBorder);
		panelBuffer.add(lookLeftPanel, BorderLayout.PAGE_START);*/
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		furrowBrowPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//furrowBrowPanel = new JPanel();
		Border furrowBrow = new TitledBorder(null, "Furrow Brow", TitledBorder.LEADING, TitledBorder.TOP);
		Border furrowBrowMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border furrowBrowBorder = BorderFactory.createCompoundBorder(furrowBrowMargin, furrowBrow);
		furrowBrowPanel.setBorder(furrowBrowBorder);
		panelBuffer.add(furrowBrowPanel, BorderLayout.CENTER);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		raiseBrowPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//raiseBrowPanel = new JPanel();
		Border raiseBrow = new TitledBorder(null, "Raise Brow", TitledBorder.LEADING, TitledBorder.TOP);
		Border raiseBrowMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border raiseBrowBorder = BorderFactory.createCompoundBorder(raiseBrowMargin, raiseBrow);
		raiseBrowPanel.setBorder(raiseBrowBorder);
		panelBuffer.add(raiseBrowPanel, BorderLayout.PAGE_START);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		smilePanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//smilePanel = new JPanel();
		Border smile = new TitledBorder(null, "Smile", TitledBorder.LEADING, TitledBorder.TOP);
		Border smileMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border smileBorder = BorderFactory.createCompoundBorder(smileMargin, smile);
		smilePanel.setBorder(smileBorder);
		panelBuffer.add(smilePanel, BorderLayout.CENTER);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		clenchPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//clenchPanel = new JPanel();
		Border clench = new TitledBorder(null, "Clench", TitledBorder.LEADING, TitledBorder.TOP);
		Border clenchMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border clenchBorder = BorderFactory.createCompoundBorder(clenchMargin, clench);
		clenchPanel.setBorder(clenchBorder);
		panelBuffer.add(clenchPanel, BorderLayout.PAGE_START);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		leftSmirkPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//leftSmirkPanel = new JPanel();
		Border leftSmirk = new TitledBorder(null, "Left Smirk", TitledBorder.LEADING, TitledBorder.TOP);
		Border leftSmirkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border leftSmirkBorder = BorderFactory.createCompoundBorder(leftSmirkMargin, leftSmirk);
		leftSmirkPanel.setBorder(leftSmirkBorder);
		panelBuffer.add(leftSmirkPanel, BorderLayout.CENTER);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		rightSmirkPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//rightSmirkPanel = new JPanel();
		Border rightSmirk = new TitledBorder(null, "Right Smirk", TitledBorder.LEADING, TitledBorder.TOP);
		Border rightSmirkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border rightSmirkBorder = BorderFactory.createCompoundBorder(rightSmirkMargin, rightSmirk);
		rightSmirkPanel.setBorder(rightSmirkBorder);
		panelBuffer.add(rightSmirkPanel, BorderLayout.PAGE_START);
		
		facialExpressionGraphController = new FacialExpressionGraphController("");
		laughPanel = facialExpressionGraphController.PlotFacialExpressionGraph();
		facialExpressionGraphController.pack();
		//laughPanel = new JPanel();
		Border laugh = new TitledBorder(null, "Smile", TitledBorder.LEADING, TitledBorder.TOP);
		Border laughMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border laughBorder = BorderFactory.createCompoundBorder(laughMargin, laugh);
		laughPanel.setBorder(laughBorder);
		panelBuffer.add(laughPanel, BorderLayout.CENTER);
		
		
		graphPanel.add(panelBuffer, BorderLayout.CENTER);
		this.add(graphPanel);

	}

}
