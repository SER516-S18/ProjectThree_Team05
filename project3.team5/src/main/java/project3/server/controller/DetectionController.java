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

    public JSpinner spinner_upperface, spinner_lowerface, spinnertimevalue;
    public JCheckBox chckbxEyeAutoReset;
    public Choice choiceupperface, choicelowerface, choicemetrics, choiceeye;
    public JButton eyerdbtnActive;
    public JButton btnClearLogs;
    public ExpressiveModel emodel;

    public DetectionController(JSpinner spinner_upperface, JSpinner spinner_lowerface,
                               JSpinner spinnertimevalue, Choice choiceupperface, Choice choicelowerface,
                               Choice choiceeye, Choice choicemetrics, JCheckBox chckbxNewCheckBox,
                               JButton eyerdbtnActive) {


        this.spinnertimevalue = spinnertimevalue;
        this.spinner_lowerface = spinner_lowerface;
        this.spinner_upperface = spinner_upperface;
        this.choiceupperface = choiceupperface;
        this.choicelowerface = choicelowerface;
        this.choiceeye = choiceeye;
        this.choicemetrics = choicemetrics;
        this.eyerdbtnActive = eyerdbtnActive;
        this.chckbxEyeAutoReset = chckbxNewCheckBox;
        choiceupperface.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                updatefaceData();

            }});

        choicelowerface.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                updatefaceData();

            }});

        choiceeye.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                updatefaceData();

            }});
        choicemetrics.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                /////////////////////////////

            }});


        chckbxEyeAutoReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatefaceData();
            }
        });

        eyerdbtnActive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatefaceData();
            }
        });

        spinner_upperface.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updatefaceData();
            }
        });

        spinner_lowerface.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updatefaceData();
            }
        });

        spinnertimevalue.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ////////////////////////
            }
        });


    }



    /**
     * Updates the expression data based on the selected spinner values.
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
