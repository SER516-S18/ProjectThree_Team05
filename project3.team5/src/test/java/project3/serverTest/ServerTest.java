package project3.serverTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import org.junit.jupiter.api.Test;

import project3.model.ExpressiveModel;
import project3.model.serverConfiguations;
import project3.server.controller.Server;
import project3.server.controller.ServerEndPoint;
import project3.server.view.ServerUI;

public class ServerTest {
	private JSpinner spinner_upperface, spinner_lowerface, spinnertimevalue, spinner_metrics;
    private JCheckBox chckbxEyeAutoReset, autoRepeatCheckBox;
    private Choice choiceupperface, choicelowerface, choicemetrics, choiceeye;
    private JButton eyerdbtnActive;
    private JButton btnClearLogs;
    public ExpressiveModel emodel = new ExpressiveModel();
    private boolean eyeActive= false;
	


	@Test
	public void testServerUI_Server() {
		ServerUI serverui = new ServerUI();
		assertEquals("class project3.server.view.ServerUI",serverui.getClass().toString());
	}
	@Test
	public void testDetectionController_UpdatefaceData() {
		
		String upperFace = "Raise Brow";//(String) choiceupperface.getSelectedItem();
        Double upperFaceValue = 0.0;//(double) spinner_upperface.getValue();
        switch (upperFace.toString()) {
            case "Raise Brow":
            	emodel.setRaiseBrow(upperFaceValue);
                break;
            case "Furrow Brow":
                emodel.setFurrowBrow(upperFaceValue);
                break;
        }

        String lowerFace = "Smile";//(String) choicelowerface.getSelectedItem();
        Double lowerFaceValue =0.0;// (double) spinner_lowerface.getValue();
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
       
   
		assertEquals(0.0,emodel.getRaiseBrow());
		//assertEquals("class project3.server.view.ServerUI",serverui.getClass().toString());

	}
	
	@Test
	public void testServer_setAutoReset1() {
		/*serverConfiguations serverConfig = serverConfiguations.getServerDataInstance();
		serverConfig.setAutoRepeat(false);
		
		if(autoResetValue)
			serverConfig.setSendOneTime(false);
		else
			serverConfig.setSendOneTime(true);*/
		Server server = new Server(); 
		server.setAutoReset(false);
	}
	
	@Test
	public void testServer_setAutoReset2() {
		/*serverConfiguations serverConfig = serverConfiguations.getServerDataInstance();
		serverConfig.setAutoRepeat(false);
		
		if(autoResetValue)
			serverConfig.setSendOneTime(false);
		else
			serverConfig.setSendOneTime(true);*/
		Server server = new Server(); 
		server.setAutoReset(true);
	}
	
	@Test
	public void TestServerConfiguationssetAutoRepeat1() {
		serverConfiguations sconf = new serverConfiguations();
		sconf.setAutoRepeat(false);
		
		assertEquals(false,sconf.isAutoRepeat());
	}
	
	@Test
	public void TestServerConfiguationssetAutoRepeat() {
		serverConfiguations sconf = new serverConfiguations();
		sconf.setAutoRepeat(true);
		
		assertEquals(true,sconf.isAutoRepeat());
	}
	
	@Test
	public void setServerStatus1() {
		ServerEndPoint sstatus = new ServerEndPoint();
		sstatus.setServerStatus(false);
	}
	
	@Test
	public void setServerStatus2() {
		ServerEndPoint sstatus = new ServerEndPoint();
		sstatus.setServerStatus(true);
	}
	

}



