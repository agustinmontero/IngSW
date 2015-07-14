/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FreeFallViewTest {
    
    FreeFallView instance;
    final int HIGH;
    final double MASS;
    final double GRAV;
    Thread thread;
    
    public FreeFallViewTest() {
        this.HIGH = 950;
        this.MASS = 2.3;
        instance = new FreeFallView();
        this.instance.freeFallAdapter.setBPM(HIGH);
        this.instance.setInitialHigh(HIGH);        
        this.instance.freeFallAdapter.setMass(MASS);
        this.instance.setMass(MASS);
        GRAV = this.instance.model.getGravity();
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
        this.instance.freeFallAdapter.off();
    }

    @Test
    public void testMain() {
        thread = new Thread();
        System.out.println("main");
        String[] args = null;
        this.instance.main(args);
        this.instance.freeFallAdapter.on();
        try {
            Thread.sleep(16000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FreeFallViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int totalEnergy = this.instance.model.getTotalEnergy();
        int kinetic = this.instance.model.getKineticEn();
        int t = (int) (MASS*GRAV*HIGH);        
        assertEquals(t, totalEnergy);
        assertEquals(t , kinetic);
    }
}
