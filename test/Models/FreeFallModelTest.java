/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
public class FreeFallModelTest {
    
    public FreeFallModelTest() {
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
    public void testInitialize() {
        System.out.println("initialize");
        FreeFallModel instance = new FreeFallModel();
        instance.initialize();
        fail("The test case is a prototype.");
    }

    @Test
    public void testOn() {
        System.out.println("on");
        FreeFallModel instance = new FreeFallModel();
        instance.on();
        fail("The test case is a prototype.");
    }

    @Test
    public void testOff() {
        System.out.println("off");
        FreeFallModel instance = new FreeFallModel();
        instance.off();
        fail("The test case is a prototype.");
    }

    @Test
    public void testRun() {
        System.out.println("run");
        FreeFallModel instance = new FreeFallModel();
        instance.run();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        FreeFallModel instance = new FreeFallModel();
        int expResult = 0;
        int result = instance.getAltitude();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        int altitude = 0;
        FreeFallModel instance = new FreeFallModel();
        instance.setAltitude(altitude);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterObserver_BeatObserver() {
        System.out.println("registerObserver");
        BeatObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.registerObserver(o);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveObserver_BeatObserver() {
        System.out.println("removeObserver");
        BeatObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.removeObserver(o);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNotifyBeatObserver() {
        System.out.println("notifyBeatObserver");
        FreeFallModel instance = new FreeFallModel();
        instance.notifyBeatObserver();
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterObserver_BPMObserver() {
        System.out.println("registerObserver");
        BPMObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.registerObserver(o);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveObserver_BPMObserver() {
        System.out.println("removeObserver");
        BPMObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.removeObserver(o);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNotifyBPMObserver() {
        System.out.println("notifyBPMObserver");
        FreeFallModel instance = new FreeFallModel();
        instance.notifyBPMObserver();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        FreeFallModel instance = new FreeFallModel();
        String expResult = "";
        String result = instance.getTime();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
