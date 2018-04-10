package project3.server.controller;


import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import project3.model.ExpressiveModel;


/**
 * Controller for the detection section of the server
 *
 *
 * @Version 1.0
 */

public class DetectionController {

    public JSpinner spinner_upperface, spinner_lowerface, spinnertimevalue,spinner_metrics;
    public JCheckBox chckbxEyeAutoReset, autoRepeatCheckBox;
    public Choice choiceupperface, choicelowerface, choicemetrics, choiceeye;
    public JButton eyerdbtnActive;
    public JButton btnClearLogs;
    public ExpressiveModel emodel;

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
        
        choiceupperface.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                updatefaceData();

            }});

        choicelowerface.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                updatefaceData();

            }});

        choiceeye.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                updatefaceData();

            }});
        choicemetrics.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
            	updatefaceData();

            }});

        chckbxEyeAutoReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 updatefaceData();
				
			}});

        eyerdbtnActive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatefaceData();
            }});

        spinner_upperface.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				 updatefaceData();
				
			}});

        spinner_lowerface.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				updatefaceData();
				
			}});
      
        spinner_metrics.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				updateMetricsData();
				
			}});
        autoRepeatCheckBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
        
        spinnertimevalue.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ////////////////////////
            }
        });
        


    }

    /**
     * Updating face expression data values using spinner values
     */
    public void updatefaceData() {


        String upperFace = (String) choiceupperface.getSelectedItem();
        float upperFaceValue = Float.parseFloat((String) spinner_upperface.getValue());

        switch (upperFace.toString()) {
            case "Raise Brow":
                emodel.setRaiseBrow(upperFaceValue);
                break;
            case "Furrow Brow":
                emodel.setFurrowBrow(upperFaceValue);
                break;
        }

        String lowerFace = (String) choicelowerface.getSelectedItem();
        float lowerFaceValue = Float.parseFloat((String) spinner_lowerface.getValue());

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

        boolean eyeActive = eyerdbtnActive.isSelected();

        if (eyeActive) {
            String eye = (String) choicemetrics.getSelectedItem();

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

        boolean eyeAutoReset = chckbxEyeAutoReset.isSelected();

        if (eyeAutoReset) {
            emodel.setEyeReset(true);
        }
    }
    
    public void updateMetricsData() {

	

		String MetricsData = (String) choicemetrics.getSelectedItem();
		float MetricsDataval = Float.parseFloat((String) spinner_metrics.getValue());

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
    
}
