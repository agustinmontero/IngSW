/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.headfirst.combined.djview;

import Observers.BeatObserver;
import Observers.BPMObserver;
import models.FreeFallModel;
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

    /**
     * Test of initialize method, of class FreeFallModel.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        FreeFallModel instance = new FreeFallModel();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of on method, of class FreeFallModel.
     */
    @Test
    public void testOn() {
        System.out.println("on");
        FreeFallModel instance = new FreeFallModel();
        instance.on();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of off method, of class FreeFallModel.
     */
    @Test
    public void testOff() {
        System.out.println("off");
        FreeFallModel instance = new FreeFallModel();
        instance.off();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class FreeFallModel.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FreeFallModel instance = new FreeFallModel();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAltitude method, of class FreeFallModel.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        FreeFallModel instance = new FreeFallModel();
        int expResult = 0;
        int result = instance.getAltitude();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAltitude method, of class FreeFallModel.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        int altitude = 0;
        FreeFallModel instance = new FreeFallModel();
        instance.setAltitude(altitude);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class FreeFallModel.
     */
    @Test
    public void testRegisterObserver_BeatObserver() {
        System.out.println("registerObserver");
        BeatObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.registerObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class FreeFallModel.
     */
    @Test
    public void testRemoveObserver_BeatObserver() {
        System.out.println("removeObserver");
        BeatObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.removeObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyBeatObserver method, of class FreeFallModel.
     */
    @Test
    public void testNotifyBeatObserver() {
        System.out.println("notifyBeatObserver");
        FreeFallModel instance = new FreeFallModel();
        instance.notifyBeatObserver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class FreeFallModel.
     */
    @Test
    public void testRegisterObserver_BPMObserver() {
        System.out.println("registerObserver");
        BPMObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.registerObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class FreeFallModel.
     */
    @Test
    public void testRemoveObserver_BPMObserver() {
        System.out.println("removeObserver");
        BPMObserver o = null;
        FreeFallModel instance = new FreeFallModel();
        instance.removeObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyBPMObserver method, of class FreeFallModel.
     */
    @Test
    public void testNotifyBPMObserver() {
        System.out.println("notifyBPMObserver");
        FreeFallModel instance = new FreeFallModel();
        instance.notifyBPMObserver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class FreeFallModel.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        FreeFallModel instance = new FreeFallModel();
        String expResult = "";
        String result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
