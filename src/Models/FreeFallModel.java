package Models;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import Observers.BPMObserver;
import Observers.BeatObserver;
import Interfaces.FreeFallModelInterface;

public class FreeFallModel implements FreeFallModelInterface, Runnable{
    
    private ArrayList beatObserver;
    private ArrayList bpmObserver;
    private final int GROUND;
    private final long TIME_INTERVAL;    
    private final double GRAVITY;
    private double mass;
    private int kineticEn;
    private int potentialEn;
    private int totalEnergy;
    private double velocity;
    private double seconds;
    private long startTimeMillis;
    private long endTimeMillis;
    private int altitude;
    private int initialHigh;
    private Thread thread;

    public FreeFallModel() {
        this.GROUND = 0;
        this.GRAVITY = 9.8;
        this.TIME_INTERVAL = 99;
        this.altitude = 1000;
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
        this.kineticEn = totalEnergy;
        this.potentialEn = 0;
        notifyBPMObserver();
        notifyBeatObserver();
    }
    
    @Override
    public void run() {        
        seconds = 0;
        int current_altitude;
        double vel;
        startTimeMillis = System.currentTimeMillis();
        totalEnergy = (int) (this.mass*this.GRAVITY*this.initialHigh);
        while (getAltitude()>GROUND) {
            try {
                Thread.sleep(TIME_INTERVAL);
            } catch (Exception e) {}
            seconds+= 0.1;
            current_altitude= (int) (initialHigh - 0.5*GRAVITY*Math.pow(seconds, 2));
            vel = GRAVITY*seconds;
            this.setVelocity(vel);
            this.caclulateEnergy();
            endTimeMillis = System.currentTimeMillis();            
            if (current_altitude>0) {
                this.setAltitude(current_altitude);
                this.notifyBPMObserver();
                this.notifyBeatObserver();
            } else{
                this.off();
            }
        }
    }
    
    @Override
    public int getAltitude() {
        return altitude;
    }
    
    @Override
    public void setAltitude(int altitude)throws NumberFormatException{
        try {
            if (altitude >= 0) {
                this.altitude = altitude;
            } else {
                throw new NumberFormatException();
            }

        } catch (Exception e) {
            throw e;
        }
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
    
    
    private void notifyBeatObserver(){
        for (Object aBeatObserver : beatObserver) {
            BeatObserver observer = (BeatObserver) aBeatObserver;
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
    
    private void notifyBPMObserver(){
        for (Object aBpmObserver : bpmObserver) {
            BPMObserver observer = (BPMObserver) aBpmObserver;
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
        return potentialEn;
    }

    private double getVelocity() {
        return velocity;
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }
    
    private void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public void setMass(double mass)throws NumberFormatException{
        try {
            if (mass > 0) {
                this.mass = mass;
            } else {
                throw new NumberFormatException();
            }            
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void caclulateEnergy() throws ArithmeticException{
        if (mass != 0) {
            double m = mass;
            double g = this.getGravity();
            double h = this.getAltitude();
            double v = this.getVelocity();
            try {
                potentialEn = (int) (m*g*h);
                kineticEn = (int) (0.5*m*Math.pow(v, 2));
            } catch (ArithmeticException e) {
                throw e;
            }
        }
    }
}
