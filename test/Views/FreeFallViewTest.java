package Views;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FreeFallViewTest {
    
    private FreeFallView instance;
    private final int HIGH;
    private final double MASS;
    private final double GRAV;

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
        Thread thread = new Thread();
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
        String time;
        time = this.instance.model.getTime();
        assertEquals(time, "14");
    }
    
    @Test(expected = NumberFormatException.class)
    public void badHighTest(){
        System.out.println("badHigh");
        int badHigh = -10;
        this.instance.freeFallAdapter.setBPM(badHigh);
        this.instance.model.setAltitude(badHigh);        
    }
    
    @Test(expected = NumberFormatException.class)
    public void badMassTest(){
        System.out.println("badMassTest");
        double badMass = -2.5;
        this.instance.freeFallAdapter.setMass(badMass);
        this.instance.model.setMass(badMass);
    }
}
