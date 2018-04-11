package project3.clientTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import project3.model.ExpressiveModel;
/*
* Testing the Client side facial expressions values
* */
public class ClientTest {
    @Test
    void testGetBlink() {
        ExpressiveModel expModel = new ExpressiveModel();
        expModel.setBlink(1);
        assertEquals(1, expModel.getBlink());
    }
    @Test
    void testGetRightBlink() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setRightWlink(1);

        assertEquals(1,expmodel.getRightWlink());
    }
    @Test
    void testGetLeftWink() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setLeftWink(1);

        assertEquals(1,expmodel.getLeftWink());
    }
    @Test
    void testGetLookLeft() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setLookLeft(1);

        assertEquals(1,expmodel.getLookLeft());
    }@Test
    void testGetLookRight() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setLookRight(1);

        assertEquals(1,expmodel.getLookRight());
    }
    @Test
    void testGetFurrowBrow() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setFurrowBrow(1);

        assertEquals(1,expmodel.getFurrowBrow());
    }
    @Test
    void testGetRaiseBrow() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setRaiseBrow(1);

        assertEquals(1,expmodel.getRaiseBrow());
    }
    @Test
    void testGetSmile() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setSmile(1);

        assertEquals(1,expmodel.getSmile());
    }
    @Test
    void testGetClench() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setClench(1);

        assertEquals(1,expmodel.getClench());
    }
    @Test
    void testGetLeftSmirk() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setSmirkLeft(1);

        assertEquals(1,expmodel.getSmirkLeft());
    }
    @Test
    void testRightSmirk() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setSmirkRight(1);

        assertEquals(1,expmodel.getSmirkRight());
    }
    @Test
    void testLaugh() {

        ExpressiveModel expmodel=new ExpressiveModel();
        expmodel.setLaugh(1);

        assertEquals(1,expmodel.getLaugh());
    }
}
