package project3.clientTest;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;
import org.junit.jupiter.api.Test;

import project3.model.ExpressiveModel;

class ClientTest {

	@Test
	void testgetBlink() {
		JUnitTest testClientExp=new JUnitTest();
		
		ExpressiveModel expmodel=new ExpressiveModel();
		expmodel.setBlink(1);
		
		assertEquals(1,expmodel.getBlink());
	}
	@Test
	void testgetRightBlink() {
		JUnitTest testClientExp=new JUnitTest();
		
		ExpressiveModel expmodel=new ExpressiveModel();
		expmodel.setRightWlink(1);
		
		assertEquals(1,expmodel.getRightWlink());
	}	
}
