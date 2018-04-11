package project3.serverTest;
  
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
import project3.model.ExpressiveModel;
import project3.model.ServerConfigurations;
import project3.server.controller.Server;

import project3.server.view.ServerUI;

public class ServerTest {

    public ExpressiveModel emodel = new ExpressiveModel();
   

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
		
		Server server = new Server(); 
		server.setAutoReset(false);
	}
	
	@Test
	public void testServer_setAutoReset2() {
		
		Server server = new Server(); 
		server.setAutoReset(true);
	}
	
	@Test
	public void TestServerConfiguationssetAutoRepeat1() {
		ServerConfigurations sconf =new ServerConfigurations();
		sconf.setAutoRepeat(false);
		
		assertEquals(false,sconf.isAutoRepeat());
	}
	
	@Test
	public void TestServerConfiguationssetAutoRepeat() {
		ServerConfigurations sconf = new ServerConfigurations();
		sconf.setAutoRepeat(true);
		
		assertEquals(true,sconf.isAutoRepeat());
	}
	
	
	

}



