/*SER 516 Lab 3
 *@author Raisa Khatun
 *@date April 7,2018
 * */
package project3.client.controller;

import project3.model.GraphsPropertiesModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * This class helps to attach various action with onclicking the buttons in PerformanceColorPanel 
 **/
public class PerformanceMetricsButtonController {
	private JButton IN;
	private JButton EX;
	private JButton FO;
	private JButton EN;
	private JButton ST;
	private JButton RE;
	private JColorChooser colorChooserIN = new JColorChooser(Color.RED);
	private JColorChooser colorChooserEX = new JColorChooser(Color.BLUE);
	private JColorChooser colorChooserFO = new JColorChooser(Color.GREEN);
	private JColorChooser colorChooserEN = new JColorChooser(Color.YELLOW);
	private JColorChooser colorChooserST = new JColorChooser(Color.BLACK);
	private JColorChooser colorChooserRE = new JColorChooser(Color.WHITE);

	/*
	 * This Constructor attaches action listener to the buttons to choose a color
	 * from a color chooser panel
	 */
	public PerformanceMetricsButtonController(JPanel performanceMetricsPanel, JButton IN, JButton EN, JButton FO,
			JButton ST, JButton RE, JButton EX) {

		this.IN = IN;
		this.EX = EX;
		this.ST = ST;
		this.FO = FO;
		this.EN = EN;
		this.RE = RE;
		performanceMetricsPanel.add(IN);
		performanceMetricsPanel.add(EX);
		performanceMetricsPanel.add(ST);
		performanceMetricsPanel.add(FO);
		performanceMetricsPanel.add(EN);
		performanceMetricsPanel.add(RE);
		colorChooserIN.setBorder(null);
		colorChooserIN.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel defaultPanelsIN[] = colorChooserIN.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsEX[] = colorChooserEX.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsST[] = colorChooserST.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsFO[] = colorChooserFO.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsEN[] = colorChooserEN.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsRE[] = colorChooserRE.getChooserPanels();
		colorChooserIN.removeChooserPanel(defaultPanelsIN[4]);
		colorChooserIN.removeChooserPanel(defaultPanelsIN[2]);
		colorChooserIN.removeChooserPanel(defaultPanelsIN[3]);
		colorChooserIN.removeChooserPanel(defaultPanelsIN[1]);
		colorChooserEX.setBorder(null);
		colorChooserEX.setPreviewPanel(new JPanel());
		colorChooserEX.removeChooserPanel(defaultPanelsEX[4]);
		colorChooserEX.removeChooserPanel(defaultPanelsEX[2]);
		colorChooserEX.removeChooserPanel(defaultPanelsEX[3]);
		colorChooserEX.removeChooserPanel(defaultPanelsEX[1]);
		colorChooserFO.setBorder(null);
		colorChooserFO.setPreviewPanel(new JPanel());
		colorChooserFO.removeChooserPanel(defaultPanelsFO[4]);
		colorChooserFO.removeChooserPanel(defaultPanelsFO[2]);
		colorChooserFO.removeChooserPanel(defaultPanelsFO[3]);
		colorChooserFO.removeChooserPanel(defaultPanelsFO[1]);
		colorChooserRE.setBorder(null);
		colorChooserRE.setPreviewPanel(new JPanel());
		colorChooserRE.removeChooserPanel(defaultPanelsRE[4]);
		colorChooserRE.removeChooserPanel(defaultPanelsRE[2]);
		colorChooserRE.removeChooserPanel(defaultPanelsRE[3]);
		colorChooserRE.removeChooserPanel(defaultPanelsRE[1]);
		colorChooserEN.setBorder(null);
		colorChooserEN.setPreviewPanel(new JPanel());
		colorChooserEN.removeChooserPanel(defaultPanelsEN[4]);
		colorChooserEN.removeChooserPanel(defaultPanelsEN[2]);
		colorChooserEN.removeChooserPanel(defaultPanelsEN[3]);
		colorChooserEN.removeChooserPanel(defaultPanelsEN[1]);
		colorChooserST.setBorder(null);
		colorChooserST.setPreviewPanel(new JPanel());
		colorChooserST.removeChooserPanel(defaultPanelsST[4]);
		colorChooserST.removeChooserPanel(defaultPanelsST[2]);
		colorChooserST.removeChooserPanel(defaultPanelsST[3]);
		colorChooserST.removeChooserPanel(defaultPanelsST[1]);

		IN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColorChooser(IN, performanceMetricsPanel, colorChooserIN);
				GraphsPropertiesModel.getGraphsPropertiesModelInstance().setInterestColor(IN.getBackground());
			}
		});

		EX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setColorChooser(EX, performanceMetricsPanel, colorChooserEX);

			}
		});
		EN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setColorChooser(EN, performanceMetricsPanel, colorChooserEN);

			}
		});
		ST.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setColorChooser(ST, performanceMetricsPanel, colorChooserST);
			}
		});
		FO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setColorChooser(FO, performanceMetricsPanel, colorChooserFO);
			}
		});
		RE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setColorChooser(RE, performanceMetricsPanel, colorChooserRE);
			}
		});
		colorChooserIN.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(IN, colorChooserIN);
				performanceMetricsPanel.remove(colorChooserIN);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
		colorChooserEX.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(EX, colorChooserEX);
				performanceMetricsPanel.remove(colorChooserEX);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
		colorChooserEN.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(EN, colorChooserEN);
				performanceMetricsPanel.remove(colorChooserEN);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
		colorChooserST.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(ST, colorChooserST);
				performanceMetricsPanel.remove(colorChooserST);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
		colorChooserFO.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(FO, colorChooserFO);
				performanceMetricsPanel.remove(colorChooserFO);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
		colorChooserRE.getSelectionModel().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				colorChanged(RE, colorChooserRE);
				performanceMetricsPanel.remove(colorChooserRE);
				performanceMetricsPanel.validate();
				performanceMetricsPanel.repaint();
			}
		});
	}

	/*
	 * To choose the color that is set for the graph and use it to display on the button
	 */
	protected void setColorChooser(JButton button, JPanel performanceMetricsPanel, JColorChooser colorChooser) {

		colorChooser.setBounds(100, 145, 450, 115);
		colorChooser.setVisible(true);
		performanceMetricsPanel.add(colorChooser);
		performanceMetricsPanel.validate();
		performanceMetricsPanel.repaint();
	}

	/*
	 * To set the color picked as a background to the button
	 */
	protected void colorChanged(JButton button, JColorChooser colorChooser) {
		button.setBackground(colorChooser.getSelectionModel().getSelectedColor());
	}

}
