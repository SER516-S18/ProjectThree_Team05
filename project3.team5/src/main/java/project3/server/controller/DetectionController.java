package project3.server.controller;


import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import project3.model.ExpressiveModel;


/**
 * Controller for the detection section of the server
 *
 *
 * @Version 1.0
 */

public class DetectionController {

    private JSpinner spinner_upperface, spinner_lowerface, spinnertimevalue, spinner_metrics;
    private JCheckBox chckbxEyeAutoReset, autoRepeatCheckBox;
    private Choice choiceupperface, choicelowerface, choicemetrics, choiceeye;
    private JButton eyerdbtnActive;
    private JButton btnClearLogs;
    public ExpressiveModel emodel = new ExpressiveModel();
    private boolean eyeActive= false;
	
    /* no implementation for time interval*/

    public DetectionController(JSpinner spinner_upperface, JSpinner spinner_lowerface,
                               JSpinner spinnertimevalue,JSpinner spinner_metrics,
                               Choice choiceupperface, Choice choicelowerface,
                               Choice choiceeye, Choice choicemetrics, JCheckBox chckbxNewCheckBox,
                               JButton eyerdbtnActive, JCheckBox autoRepeatCheckBox) {


        this.spinnertimevalue = spinnertimevalue;
        this.spinner_lowerface = spinner_lowerface;
        this.spinner_upperface = spinner_upperface;
        this.spinner_metrics = spinner_metrics;
        this.choiceupperface = choiceupperface;
        this.choicelowerface = choicelowerface;
        this.choiceeye = choiceeye;
        this.choicemetrics = choicemetrics;
        this.eyerdbtnActive = eyerdbtnActive;
        this.chckbxEyeAutoReset = chckbxNewCheckBox;
        this.autoRepeatCheckBox= autoRepeatCheckBox;
      
        updatefaceData();
        updateMetricsData();
        updateSpinnerTimeValue();
    }

    /**
     * Updating face expression data values using spinner values
     */
    private void updatefaceData() {
    		String upperFace = (String) choiceupperface.getSelectedItem();
        Double upperFaceValue = (double) spinner_upperface.getValue();
        switch (upperFace.toString()) {
            case "Raise Brow":
            	emodel.setRaiseBrow(upperFaceValue);
                break;
            case "Furrow Brow":
                emodel.setFurrowBrow(upperFaceValue);
                break;
        }

        String lowerFace = (String) choicelowerface.getSelectedItem();
        Double lowerFaceValue = (double) spinner_lowerface.getValue();
        switch (lowerFace.toString()) {
            case "Smile":
                emodel.setSmile(lowerFaceValue);
                break;
            case "Clench":
                emodel.setClench(lowerFaceValue);
                break;
            case "Smirk Left":
                emodel.setSmirkLeft(lowerFaceValue);
                break;
            case "Smirk Right":
                emodel.setSmirkRight(lowerFaceValue);
                break;
            case "Laugh":
                emodel.setLaugh(lowerFaceValue);
                break;
        }
       /*eye activate button send intitialized to 0 when click sturn to one and set the value of eye to 1
        *on second click sets value to 0 
        * */
        eyerdbtnActive.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(eyeActive==false)
				{
					eyeActive=true;
					if (eyeActive) {
			            String eye = (String) choiceeye.getSelectedItem();
			            switch (eye) {
			                case "Blink":
			                    emodel.setBlink(1);
			                    break;
			                case "Wink Left":
			                    emodel.setLeftWink(1);
			                    break;
			                case "Wink Right":
			                    emodel.setRightWlink(1);
			                    break;
			                case "Look Left":
			                    emodel.setLookLeft(1);
			                    break;
			                case "Look Right":
			                    emodel.setLookRight(1);
			                    break;
			            }
			        }
				}
				else
				{
					eyeActive=false;
					if (!eyeActive) {
			            String eye = (String) choiceeye.getSelectedItem();
			            switch (eye) {
			                case "Blink":
			                    emodel.setBlink(0);
			                    break;
			                case "Wink Left":
			                    emodel.setLeftWink(0);
			                    break;
			                case "Wink Right":
			                    emodel.setRightWlink(0);
			                    break;
			                case "Look Left":
			                    emodel.setLookLeft(0);
			                    break;
			                case "Look Right":
			                    emodel.setLookRight(0);
			                    break;
			            }
			        }
					
				}
				
			}
        	
        });
        boolean eyeAutoReset = chckbxEyeAutoReset.isSelected();
        if (eyeAutoReset) {
            emodel.setEyeReset(true);
        }
    }
    
    private void updateMetricsData() {
		String MetricsData = (String) choicemetrics.getSelectedItem();
		Double MetricsDataval = (double) spinner_metrics.getValue();
		switch (MetricsData) {
		case "Interest":
			emodel.setInterest(MetricsDataval);
			break;
		case "Engagement":
			emodel.setEngagement(MetricsDataval);
			break;
		case "Stress":
			emodel.setStress(MetricsDataval);
			break;
		case "Relaxation":
			emodel.setRelaxation(MetricsDataval);
			break;
		case "Excitement":
			emodel.setExcitement(MetricsDataval);
			break;
		case "Focus":
			emodel.setFocus(MetricsDataval);
			break;
		}
	}
    
    private void updateSpinnerTimeValue() {
		Double timevalue = (double) spinnertimevalue.getValue();
		emodel.setTimeStamp(timevalue);
    }
    
}
