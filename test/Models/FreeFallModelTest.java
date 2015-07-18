/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Agustin
 */
public class FreeFallModelTest {

    public FreeFallModelTest() {
        FreeFallModel model = new FreeFallModel();
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
        FreeFallModel instance = new FreeFallModel();
        instance.on();
    }

    @Test
    public void testOff() {
        System.out.println("off");
        FreeFallModel instance = new FreeFallModel();
        instance.off();
        int ground = instance.getAltitude();
        assertEquals(ground, 0);
    }

    /*@Test
     public void testRun() {
     System.out.println("run");
     FreeFallModel instance = new FreeFallModel();
     instance.run();
     }*/
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        FreeFallModel instance = new FreeFallModel();
        int expResult = 1000;
        int result = instance.getAltitude();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test(expected = NumberFormatException.class)
    public void testSetAltitude() {
        System.out.println("setAltitude");
        int altitude = 6000;
        FreeFallModel instance = new FreeFallModel();
        instance.setAltitude(altitude);
        assertEquals(instance.getAltitude(), altitude);
        int altitude2 = -20;
        instance.setAltitude(altitude2);
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        FreeFallModel instance = new FreeFallModel();
        String expResult = "0";
        String result = instance.getTime();
        assertEquals(expResult, result);
    }
    
    

}
