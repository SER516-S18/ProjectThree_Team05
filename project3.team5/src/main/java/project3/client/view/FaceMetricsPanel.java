/**
 * @SER516 Project3_Team05
 */

package project3.client.view;

import project3.client.controller.ClientExpression;
import project3.client.controller.ExpressiveModelObservable;
import project3.client.controller.FacialExpressionGraphController;
import project3.model.ExpressiveModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

/*
 * This class implements various attributes required for facial expressions in the ClientUI
 */
public class FaceMetricsPanel extends JPanel implements Observer {

	private JPanel facePanel;
	private JLabel gifLabel;
	private ClientExpression clientExpression = new ClientExpression();
	private String expressionName;
	private JPanel graphPanel;
	private ChartPanel blinkPanel;
	private ChartPanel rightWinkPanel;
	private ChartPanel leftWinkPanel;
	private ChartPanel lookRightPanel;
	private ChartPanel furrowBrowPanel;
	private ChartPanel raiseBrowPanel;
	private ChartPanel smilePanel;
	private ChartPanel clenchPanel;
	private ChartPanel leftSmirkPanel;
	private ChartPanel rightSmirkPanel;
	private ChartPanel laughPanel;

	ArrayList<Double> smileData = new ArrayList<Double>();
	ArrayList<Double> leftSmirkData = new ArrayList<Double>();
	ArrayList<Double> rightSmirkData = new ArrayList<Double>();
	ArrayList<Double> clenchData = new ArrayList<Double>();
	ArrayList<Double> laughData = new ArrayList<Double>();
	ArrayList<Integer> blinkData = new ArrayList<Integer>();
	ArrayList<Integer> leftWinkData = new ArrayList<Integer>();
	ArrayList<Integer> rightWinkData = new ArrayList<Integer>();
	ArrayList<Integer> lookRightData = new ArrayList<Integer>();;
	ArrayList<Double> furrowBrowData = new ArrayList<Double>();
	ArrayList<Double> raiseBrowData = new ArrayList<Double>();

	private JPanel panelBuffer;
	private FacialExpressionGraphController blinkGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController rightWinkGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController leftWinkGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController lookRightGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController furrowBrowGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController raiseBrowGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController smileGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController clenchGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController leftSmirkGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController rightSmirkGraphController = new FacialExpressionGraphController("");
	private FacialExpressionGraphController laughGraphController = new FacialExpressionGraphController("");
	private ExpressiveModel expressiveModel;

	public FaceMetricsPanel() {

		this.setLayout(new GridLayout(1, 2, 8, 8));
		this.setBorder(new EmptyBorder(8, 8, 8, 8));
		this.setOpaque(false);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));

		facePanel = new JPanel();
		facePanel.setPreferredSize(new Dimension(416, 478));
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		facePanel.setBackground(Color.WHITE);
		facePanel.setLayout(new GridLayout(1, 1, 0, 0));
		this.add(facePanel);
		gifLabel = new JLabel(new ImageIcon("res/laugh.png"));
		gifLabel.setPreferredSize(new Dimension(260, 260));
		facePanel.add(gifLabel);

		graphPanel = new JPanel();
		graphPanel.setPreferredSize(new Dimension(529, 478));
		graphPanel.setBackground(Color.WHITE);
		graphPanel.setLayout(new BorderLayout());
		graphPanel.setOpaque(false);
		graphPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelBuffer = new JPanel(new GridLayout(11, 1, 0, 0));
		panelBuffer.setBackground(Color.GRAY);

		blinkPanel = new ChartPanel(null);
		blinkData.add(0);
		blinkPanel.setChart(blinkGraphController.PlotFacialExpressionIntegerGraph(blinkData));
		blinkGraphController.pack();
		blinkPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border blink = new TitledBorder(null, "Blink", TitledBorder.LEADING, TitledBorder.TOP);
		Border blinkMargin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border blinkBorder = BorderFactory.createCompoundBorder(blinkMargin, blink);
		blinkPanel.setBorder(blinkBorder);
		panelBuffer.add(blinkPanel, BorderLayout.PAGE_START);

		rightWinkPanel = new ChartPanel(null);
		rightWinkData.add(0);
		rightWinkPanel.setChart(rightWinkGraphController.PlotFacialExpressionIntegerGraph(rightWinkData));
		rightWinkGraphController.pack();
		rightWinkPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border rightWink = new TitledBorder(null, "Right Wink", TitledBorder.LEADING, TitledBorder.TOP);
		Border rightWinkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border rightWinkBorder = BorderFactory.createCompoundBorder(rightWinkMargin, rightWink);
		rightWinkPanel.setBorder(rightWinkBorder);
		panelBuffer.add(rightWinkPanel, BorderLayout.CENTER);

		leftWinkPanel = new ChartPanel(null);
		leftWinkData.add(0);
		leftWinkPanel.setChart(leftWinkGraphController.PlotFacialExpressionIntegerGraph(leftWinkData));
		leftWinkGraphController.pack();
		leftWinkPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border leftWink = new TitledBorder(null, "Left Wink", TitledBorder.LEADING, TitledBorder.TOP);
		Border leftWinkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border leftWinkBorder = BorderFactory.createCompoundBorder(leftWinkMargin, leftWink);
		leftWinkPanel.setBorder(leftWinkBorder);
		panelBuffer.add(leftWinkPanel, BorderLayout.PAGE_START);

		lookRightPanel = new ChartPanel(null);
		lookRightData.add(0);
		lookRightPanel.setChart(lookRightGraphController.PlotFacialExpressionIntegerGraph(lookRightData));
		lookRightGraphController.pack();
		lookRightPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border lookRight = new TitledBorder(null, "Look Right/Left", TitledBorder.LEADING, TitledBorder.TOP);
		Border lookRightMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border lookRightBorder = BorderFactory.createCompoundBorder(lookRightMargin, lookRight);
		lookRightPanel.setBorder(lookRightBorder);
		panelBuffer.add(lookRightPanel, BorderLayout.CENTER);

		furrowBrowPanel = new ChartPanel(null);
		furrowBrowData.add(0.0);
		furrowBrowPanel.setChart(furrowBrowGraphController.PlotFacialExpressionDoubleGraph(furrowBrowData));
		furrowBrowGraphController.pack();
		furrowBrowPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border furrowBrow = new TitledBorder(null, "Furrow Brow", TitledBorder.LEADING, TitledBorder.TOP);
		Border furrowBrowMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border furrowBrowBorder = BorderFactory.createCompoundBorder(furrowBrowMargin, furrowBrow);
		furrowBrowPanel.setBorder(furrowBrowBorder);
		panelBuffer.add(furrowBrowPanel, BorderLayout.CENTER);

		raiseBrowPanel = new ChartPanel(null);
		raiseBrowData.add(0.0);
		raiseBrowPanel.setChart(raiseBrowGraphController.PlotFacialExpressionDoubleGraph(raiseBrowData));
		raiseBrowGraphController.pack();
		raiseBrowPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border raiseBrow = new TitledBorder(null, "Raise Brow", TitledBorder.LEADING, TitledBorder.TOP);
		Border raiseBrowMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border raiseBrowBorder = BorderFactory.createCompoundBorder(raiseBrowMargin, raiseBrow);
		raiseBrowPanel.setBorder(raiseBrowBorder);
		panelBuffer.add(raiseBrowPanel, BorderLayout.PAGE_START);

		smilePanel = new ChartPanel(null);
		smileData.add(0.0);
		smilePanel.setChart(smileGraphController.PlotFacialExpressionDoubleGraph(smileData));
		smileGraphController.pack();
		smilePanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border smile = new TitledBorder(null, "Smile", TitledBorder.LEADING, TitledBorder.TOP);
		Border smileMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border smileBorder = BorderFactory.createCompoundBorder(smileMargin, smile);
		smilePanel.setBorder(smileBorder);
		panelBuffer.add(smilePanel, BorderLayout.CENTER);

		clenchPanel = new ChartPanel(null);
		clenchData.add(0.0);
		clenchPanel.setChart(clenchGraphController.PlotFacialExpressionDoubleGraph(clenchData));
		clenchGraphController.pack();
		clenchPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border clench = new TitledBorder(null, "Clench", TitledBorder.LEADING, TitledBorder.TOP);
		Border clenchMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border clenchBorder = BorderFactory.createCompoundBorder(clenchMargin, clench);
		clenchPanel.setBorder(clenchBorder);
		panelBuffer.add(clenchPanel, BorderLayout.PAGE_START);

		leftSmirkPanel = new ChartPanel(null);
		leftSmirkData.add(0.0);
		leftSmirkPanel.setChart(leftSmirkGraphController.PlotFacialExpressionDoubleGraph(leftSmirkData));
		leftSmirkGraphController.pack();
		leftSmirkPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border leftSmirk = new TitledBorder(null, "Left Smirk", TitledBorder.LEADING, TitledBorder.TOP);
		Border leftSmirkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border leftSmirkBorder = BorderFactory.createCompoundBorder(leftSmirkMargin, leftSmirk);
		leftSmirkPanel.setBorder(leftSmirkBorder);
		panelBuffer.add(leftSmirkPanel, BorderLayout.CENTER);

		rightSmirkPanel = new ChartPanel(null);
		rightSmirkData.add(0.0);
		rightSmirkPanel.setChart(rightSmirkGraphController.PlotFacialExpressionDoubleGraph(rightSmirkData));
		rightSmirkGraphController.pack();
		rightSmirkPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border rightSmirk = new TitledBorder(null, "Right Smirk", TitledBorder.LEADING, TitledBorder.TOP);
		Border rightSmirkMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border rightSmirkBorder = BorderFactory.createCompoundBorder(rightSmirkMargin, rightSmirk);
		rightSmirkPanel.setBorder(rightSmirkBorder);
		panelBuffer.add(rightSmirkPanel, BorderLayout.PAGE_START);

		laughPanel = new ChartPanel(null);
		laughData.add(0.0);
		laughPanel.setChart(laughGraphController.PlotFacialExpressionDoubleGraph(laughData));
		laughGraphController.pack();
		laughPanel.setPreferredSize(new java.awt.Dimension(641, 483));
		Border laugh = new TitledBorder(null, "Smile", TitledBorder.LEADING, TitledBorder.TOP);
		Border laughMargin = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border laughBorder = BorderFactory.createCompoundBorder(laughMargin, laugh);
		laughPanel.setBorder(laughBorder);
		panelBuffer.add(laughPanel, BorderLayout.CENTER);

		graphPanel.add(panelBuffer, BorderLayout.CENTER);
		this.add(graphPanel);

	}

	@Override
	public void update(Observable o, Object arg) {

		expressiveModel = (ExpressiveModel) arg;
		clientExpression = new ClientExpression();
		expressionName = clientExpression.getExpression(expressiveModel);

		if (expressionName != null) {
			facePanel.removeAll();
			facePanel.revalidate();
			facePanel.repaint();
			gifLabel = new JLabel(new ImageIcon("res/" + expressionName));
			gifLabel.setPreferredSize(new Dimension(260, 260));
			facePanel.add(gifLabel);

			ArrayList<ExpressiveModel> expressiveData = ExpressiveModelObservable.getExpressiveModelObservableInstance()
					.GetExpressiveData();

			panelBuffer.removeAll();

			for (int i = 0; i < expressiveData.size(); i++) {
				blinkData.add(new Integer(expressiveData.get(i).getBlink()));
				leftWinkData.add(new Integer(expressiveData.get(i).getLeftWink()));
				rightWinkData.add(new Integer(expressiveData.get(i).getRightWlink()));
				lookRightData.add(new Integer(expressiveData.get(i).getLookRight()));
				furrowBrowData.add(new Double(expressiveData.get(i).getFurrowBrow()));
				raiseBrowData.add(new Double(expressiveData.get(i).getRaiseBrow()));
				smileData.add(new Double(expressiveData.get(i).getSmile()));
				clenchData.add(new Double(expressiveData.get(i).getClench()));
				leftSmirkData.add(new Double(expressiveData.get(i).getSmirkLeft()));
				rightSmirkData.add(new Double(expressiveData.get(i).getSmirkRight()));
				laughData.add(new Double(expressiveData.get(i).getLaugh()));
			}

			if (expressiveModel.isAutoRepeat()) {
				blinkPanel.setChart(blinkGraphController.PlotFacialExpressionIntegerGraph(blinkData));
				blinkGraphController.pack();
				panelBuffer.add(blinkPanel, BorderLayout.PAGE_START);

				leftWinkPanel.setChart(leftWinkGraphController.PlotFacialExpressionIntegerGraph(leftWinkData));
				leftWinkGraphController.pack();
				panelBuffer.add(leftWinkPanel, BorderLayout.PAGE_START);

				rightWinkPanel.setChart(rightWinkGraphController.PlotFacialExpressionIntegerGraph(rightWinkData));
				rightWinkGraphController.pack();
				panelBuffer.add(rightWinkPanel, BorderLayout.PAGE_START);

				lookRightPanel.setChart(lookRightGraphController.PlotFacialExpressionIntegerGraph(lookRightData));
				lookRightGraphController.pack();
				panelBuffer.add(lookRightPanel, BorderLayout.PAGE_START);

				furrowBrowPanel.setChart(furrowBrowGraphController.PlotFacialExpressionDoubleGraph(furrowBrowData));
				furrowBrowGraphController.pack();
				panelBuffer.add(furrowBrowPanel, BorderLayout.PAGE_START);

				raiseBrowPanel.setChart(raiseBrowGraphController.PlotFacialExpressionDoubleGraph(raiseBrowData));
				raiseBrowGraphController.pack();
				panelBuffer.add(raiseBrowPanel, BorderLayout.PAGE_START);

				smilePanel.setChart(smileGraphController.PlotFacialExpressionDoubleGraph(smileData));
				smileGraphController.pack();
				panelBuffer.add(smilePanel, BorderLayout.PAGE_START);

				clenchPanel.setChart(clenchGraphController.PlotFacialExpressionDoubleGraph(clenchData));
				clenchGraphController.pack();
				panelBuffer.add(clenchPanel, BorderLayout.PAGE_START);

				leftSmirkPanel.setChart(leftSmirkGraphController.PlotFacialExpressionDoubleGraph(leftSmirkData));
				leftSmirkGraphController.pack();
				panelBuffer.add(leftSmirkPanel, BorderLayout.PAGE_START);

				rightSmirkPanel.setChart(rightSmirkGraphController.PlotFacialExpressionDoubleGraph(rightSmirkData));
				rightSmirkGraphController.pack();
				panelBuffer.add(rightSmirkPanel, BorderLayout.PAGE_START);

				laughPanel.setChart(laughGraphController.PlotFacialExpressionDoubleGraph(laughData));
				laughGraphController.pack();
				panelBuffer.add(laughPanel, BorderLayout.PAGE_START);

				panelBuffer.revalidate();
				panelBuffer.repaint();
			} else {
				blinkPanel.setChart(blinkGraphController.PlotFacialExpressionIntegerGraph(blinkData));
				blinkGraphController.pack();
				panelBuffer.add(blinkPanel, BorderLayout.PAGE_START);

				rightWinkPanel.setChart(rightWinkGraphController.PlotFacialExpressionIntegerGraph(rightWinkData));
				rightWinkGraphController.pack();
				panelBuffer.add(rightWinkPanel, BorderLayout.PAGE_START);

				leftWinkPanel.setChart(leftWinkGraphController.PlotFacialExpressionIntegerGraph(leftWinkData));
				leftWinkGraphController.pack();
				panelBuffer.add(leftWinkPanel, BorderLayout.PAGE_START);

				lookRightPanel.setChart(lookRightGraphController.PlotFacialExpressionIntegerGraph(lookRightData));
				lookRightGraphController.pack();
				panelBuffer.add(lookRightPanel, BorderLayout.PAGE_START);

				furrowBrowPanel.setChart(furrowBrowGraphController.PlotFacialExpressionDoubleGraph(furrowBrowData));
				furrowBrowGraphController.pack();
				panelBuffer.add(furrowBrowPanel, BorderLayout.PAGE_START);

				raiseBrowPanel.setChart(raiseBrowGraphController.PlotFacialExpressionDoubleGraph(raiseBrowData));
				raiseBrowGraphController.pack();
				panelBuffer.add(raiseBrowPanel, BorderLayout.PAGE_START);

				smilePanel.setChart(smileGraphController.PlotFacialExpressionDoubleGraph(smileData));
				smileGraphController.pack();
				panelBuffer.add(smilePanel, BorderLayout.PAGE_START);

				clenchPanel.setChart(clenchGraphController.PlotFacialExpressionDoubleGraph(clenchData));
				clenchGraphController.pack();
				panelBuffer.add(clenchPanel, BorderLayout.PAGE_START);

				leftSmirkPanel.setChart(leftSmirkGraphController.PlotFacialExpressionDoubleGraph(leftSmirkData));
				leftSmirkGraphController.pack();
				panelBuffer.add(leftSmirkPanel, BorderLayout.PAGE_START);

				rightSmirkPanel.setChart(rightSmirkGraphController.PlotFacialExpressionDoubleGraph(rightSmirkData));
				rightSmirkGraphController.pack();
				panelBuffer.add(rightSmirkPanel, BorderLayout.PAGE_START);

				laughPanel.setChart(laughGraphController.PlotFacialExpressionDoubleGraph(laughData));
				laughGraphController.pack();
				panelBuffer.add(laughPanel, BorderLayout.PAGE_START);

				panelBuffer.revalidate();
				panelBuffer.repaint();
			}
		}
	}
}
