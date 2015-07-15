package Adapter;

import Interfaces.FreeFallModelInterface;
import Models.FreeFallModel;
import Observers.BPMObserver;
import Observers.BeatObserver;
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
public class FreeFallAdapterTest {
    
    FreeFallModelInterface model;
    FreeFallAdapter instance;
    
    public FreeFallAdapterTest() {
        model = new FreeFallModel();
        instance = new FreeFallAdapter(model);
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
    public void testOn() {
        System.out.println("on");
        instance.on();
    }

    @Test
    public void testOff() {
        System.out.println("off");
        instance.off();
    }

    @Test
    public void testSetBPM() {
        System.out.println("setBPM");
        int bpm = 10;
        instance.setBPM(bpm);
        assertEquals(bpm, instance.getBPM());
    }
    
    @Test(expected = NumberFormatException.class)
    public void testSetBPM2() {
        System.out.println("setBPM2");
        int bpm = -10;
        instance.setBPM(bpm);
    }

    @Test
    public void testGetBPM() {
        System.out.println("getBPM");
        int expResult = 1000;
        int result = instance.getBPM();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGravity() {
        System.out.println("getGravity");
        double expResult = 9.8;
        double result = instance.getGravity();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetModel() {
        System.out.println("getModel");        
        FreeFallModelInterface expResult = this.model;
        FreeFallModelInterface result = instance.getModel();
        assertSame (expResult, result);
    }
    
}
