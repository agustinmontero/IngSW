package Models;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import Observers.BPMObserver;
import Observers.BeatObserver;
import Interfaces.FreeFallModelInterface;

public class FreeFallModel implements FreeFallModelInterface, Runnable{
    
    ArrayList beatObserver;
    ArrayList bpmObserver;
    private final int CRITICAL_HEIGHT = 1000;
    private final int GROUND = 0;
    private final long time_interval = 99;    
    private final double GRAVITY = 9.8;
    private double mass;
    private int kineticEn;
    private int potentialEn;
    private int totalEnergy;
    private double velocity;
    double seconds;
    long startTimeMillis;
    long endTimeMillis;
    private int altitude;
    private int initialHigh;
    Thread thread;

    public FreeFallModel() {
        this.altitude = 4000;
        this.seconds = 0;
        this.startTimeMillis = 0;
        this.endTimeMillis = 0;
        this.bpmObserver = new ArrayList();
        this.beatObserver = new ArrayList();
    }
    
    @Override
    public void initialize() {        
    }

    @Override
    public void on() {
        setAltitude(getAltitude());
        initialHigh = getAltitude();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void off() {
        if(thread !=null){
            thread.interrupt();
        }        
        setAltitude(GROUND);
        notifyBPMObserver();
        notifyBeatObserver();
    }
    
    public void run() {
        
        seconds = 0;
        boolean parachute_close = true;
        int current_altitude = getAltitude();
        double vel = 0;
        startTimeMillis = System.currentTimeMillis();
        totalEnergy = (int) (this.mass*this.GRAVITY*this.initialHigh);
        while (parachute_close && getAltitude()>GROUND) {
            try {
                Thread.sleep(time_interval);
            } catch (Exception e) {}
            seconds+= 0.1;
            current_altitude= (int) (initialHigh - 0.5*GRAVITY*Math.pow(seconds, 2));
            vel = GRAVITY*seconds;
            this.setVelocity(vel);
            this.caclulateEnergy();
            endTimeMillis = System.currentTimeMillis();            
            if (current_altitude>=0) {
                this.setAltitude(current_altitude);
                this.notifyBPMObserver();
                this.notifyBeatObserver();
            } else{
                kineticEn = totalEnergy;
                potentialEn = 0;
                this.off();
            }
        }
    }
    
    @Override
    public int getAltitude() {
        return altitude;
    }
    
    @Override
    public void setAltitude(int altitude){
        if(altitude>=0) this.altitude= altitude;
    }
    
    @Override
    public void registerObserver(BeatObserver o) {
        beatObserver.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int i = beatObserver.indexOf(o);
        if (i >= 0) {
            beatObserver.remove(o);
        }
    }
    
    
    public void notifyBeatObserver(){
        for (int i = 0; i < beatObserver.size(); i++) {
            BeatObserver observer = (BeatObserver)beatObserver.get(i);
            observer.updateBeat();
        }
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObserver.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObserver.indexOf(o);
        if(i>=0)
            bpmObserver.remove(o);
    }
    
    public void notifyBPMObserver(){
        for (int i = 0; i < bpmObserver.size(); i++) {
            BPMObserver observer = (BPMObserver)bpmObserver.get(i);
            observer.updateBPM();            
        }
    }

    public String getTime() {
        long elapsed = endTimeMillis - startTimeMillis;
        long elapsdToSeconds = TimeUnit.MILLISECONDS.toSeconds(elapsed);
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);        
        return df.format(elapsdToSeconds);
    }

    @Override
    public double getGravity() {
        return GRAVITY;
    }

    public int getKineticEn() {
        return kineticEn;
    }

    public int getPotencialEn() {
        return (int) potentialEn;
    }

    public double getVelocity() {
        return velocity;
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }
    
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
    
    private void caclulateEnergy(){
        if (mass != 0) {
            double m = mass;
            double g = this.getGravity();
            double h = this.getAltitude();
            double v = this.getVelocity();
            try {
                potentialEn = (int) (m*g*h);
                kineticEn = (int) (0.5*m*Math.pow(v, 2));
            } catch (ArithmeticException e) {
                System.out.println("ARITHMETIC E!!!");
            }
        }
    }
}
