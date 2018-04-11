/*
 *@SER516 Project3_Team05
 * */
package project3.client.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*This class helps to attach various actions with onclicking the buttons in PerformanceColorPanel */
public class PerformanceMetricsButtonListener {
	private	JButton IN;
	private	JButton EX;
	private	JButton FO;
	private	JButton EN;
	private	JButton ST;
	private	JButton RE;
	private	JColorChooser colorChooserIN=new JColorChooser(Color.RED);
	private	JColorChooser colorChooserEX=new JColorChooser(Color.BLUE);
	private	JColorChooser colorChooserFO=new JColorChooser(Color.GREEN);
	private	JColorChooser colorChooserEN=new JColorChooser(Color.YELLOW);
	private	JColorChooser colorChooserST=new JColorChooser(Color.BLACK);
	private	JColorChooser colorChooserRE=new JColorChooser(Color.WHITE);
/* This Constructor attaches action listener to the buttons on clicking*/
	public PerformanceMetricsButtonListener(JPanel performanceColorPanel,JButton IN,JButton EN,JButton FO,JButton ST,JButton RE,JButton EX) {

		this.IN=IN;
		this.EX=EX;
		this.ST=ST;
		this.FO=FO;
		this.EN=EN;
		this.RE=RE;
		performanceColorPanel.add(IN);
		performanceColorPanel.add(EX);
		performanceColorPanel.add(ST);
		performanceColorPanel.add(FO);
		performanceColorPanel.add(EN);
		performanceColorPanel.add(RE);
		colorChooserIN.setBorder(null);
		colorChooserIN.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel defaultPanelsIN[]=colorChooserIN.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsEX[]=colorChooserEX.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsST[]=colorChooserST.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsFO[]=colorChooserFO.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsEN[]=colorChooserEN.getChooserPanels();
		AbstractColorChooserPanel defaultPanelsRE[]=colorChooserRE.getChooserPanels();
		colorChooserIN.removeChooserPanel( defaultPanelsIN[4] ); 
		colorChooserIN.removeChooserPanel( defaultPanelsIN[2] );
		colorChooserIN.removeChooserPanel( defaultPanelsIN[3] );
		colorChooserIN.removeChooserPanel( defaultPanelsIN[1] );
		colorChooserEX.setBorder(null);
		colorChooserEX.setPreviewPanel(new JPanel());
		colorChooserEX.removeChooserPanel( defaultPanelsEX[4] ); 
		colorChooserEX.removeChooserPanel( defaultPanelsEX[2] );
		colorChooserEX.removeChooserPanel( defaultPanelsEX[3] );
		colorChooserEX.removeChooserPanel( defaultPanelsEX[1] );
		colorChooserFO.setBorder(null);
		colorChooserFO.setPreviewPanel(new JPanel());
		colorChooserFO.removeChooserPanel( defaultPanelsFO[4] ); 
		colorChooserFO.removeChooserPanel( defaultPanelsFO[2] );
		colorChooserFO.removeChooserPanel( defaultPanelsFO[3] );
		colorChooserFO.removeChooserPanel( defaultPanelsFO[1] );
		colorChooserRE.setBorder(null);
		colorChooserRE.setPreviewPanel(new JPanel());
		colorChooserRE.removeChooserPanel( defaultPanelsRE[4] ); 
		colorChooserRE.removeChooserPanel( defaultPanelsRE[2] );
		colorChooserRE.removeChooserPanel( defaultPanelsRE[3] );
		colorChooserRE.removeChooserPanel( defaultPanelsRE[1] );
		colorChooserEN.setBorder(null);
		colorChooserEN.setPreviewPanel(new JPanel());
		colorChooserEN.removeChooserPanel( defaultPanelsEN[4] ); 
		colorChooserEN.removeChooserPanel( defaultPanelsEN[2] );
		colorChooserEN.removeChooserPanel( defaultPanelsEN[3] );
		colorChooserEN.removeChooserPanel( defaultPanelsEN[1] );
		colorChooserST.setBorder(null);	
		colorChooserST.setPreviewPanel(new JPanel());
		colorChooserST.removeChooserPanel( defaultPanelsST[4] ); 
		colorChooserST.removeChooserPanel( defaultPanelsST[2] );
		colorChooserST.removeChooserPanel( defaultPanelsST[3] );
		colorChooserST.removeChooserPanel( defaultPanelsST[1] );
		
		IN.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	setColorChooser(IN,performanceColorPanel,colorChooserIN);
	        }
	    });	
		EX.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {	        	
	            setColorChooser(EX,performanceColorPanel,colorChooserEX);	            	           
	        }
	    });
		EN.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {	        	
	            setColorChooser(EN,performanceColorPanel,colorChooserEN);            	           
	        }
	    });
		ST.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {	        	
	            setColorChooser(ST,performanceColorPanel,colorChooserST);	            	            	            	           
	        }
	    });
		FO.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {	        	
	            setColorChooser(FO,performanceColorPanel,colorChooserFO);	            	            	     	           
	        }
	    });
		RE.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {	        	
	            setColorChooser(RE,performanceColorPanel,colorChooserRE);	     	   	           
	        }
	    });
		colorChooserIN.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {	        	
	            colorChanged(IN,colorChooserIN); 
	            performanceColorPanel.remove(colorChooserIN);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    });
		colorChooserEX.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {	        	
	        	colorChanged(EX,colorChooserEX); 
	        	performanceColorPanel.remove(colorChooserEX);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    }); 
		colorChooserEN.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {	        	
	        	colorChanged(EN,colorChooserEN); 
	        	performanceColorPanel.remove(colorChooserEN);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    }); 
		colorChooserST.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	
	        	colorChanged(ST,colorChooserST); 
	        	performanceColorPanel.remove(colorChooserST);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    }); 
		colorChooserFO.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {	        	
	        	colorChanged(FO,colorChooserFO); 
	        	performanceColorPanel.remove(colorChooserFO);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    });
		colorChooserRE.getSelectionModel().addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {	        	
	        	colorChanged(RE,colorChooserRE); 
	        	performanceColorPanel.remove(colorChooserRE);
	            performanceColorPanel.validate();
	        	performanceColorPanel.repaint();
	        }
	    }); 
	}
/*This method sets properties of the color picker*/	
	protected void setColorChooser(JButton button,JPanel performanceColorPanel,JColorChooser colorChooser) {	  
	    colorChooser.setBounds(100,145,450, 115);
	    colorChooser.setVisible(true);
	    performanceColorPanel.add(colorChooser);
	    performanceColorPanel.validate();
	    performanceColorPanel.repaint();
	}
/*This method helps to change the color of button to the selected color in color picker*/	
	protected void colorChanged(JButton button,JColorChooser colorChooser) {
	    button.setBackground(colorChooser.getSelectionModel().getSelectedColor());
	}
}
