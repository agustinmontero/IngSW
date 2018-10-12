package Controllers;

import Models.FreeFallModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Agustin
 */
public class FreeFallControllerTest {
    
    private FreeFallModel model;
    private FreeFallController instance;
    
    public FreeFallControllerTest() {
        model = new FreeFallModel();
        instance = new FreeFallController(model);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testStart() {
        System.out.println("start");
        instance.start();
    }

    @Test
    public void testStop() {
        System.out.println("stop");
        instance.stop();
    }

    @Test
    public void testSetBPM(){
        System.out.println("setBPM");
        int bpm = 20;
        instance.setBPM(bpm);
        assertEquals(bpm, model.getAltitude());
    }
    
    @Test
    public void testSetBPM2(){
        int bpm = -20;
        instance.setBPM(bpm);
        assertNotSame(bpm, model.getAltitude());
    }
}
