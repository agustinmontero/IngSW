package main.java.headfirst.combined.djview;

import java.util.ArrayList;

public class FreeFallModel implements FreeFallModelInterface, Runnable{
    
    ArrayList beatObserver;
    ArrayList bpmObserver;
    private final int CRITICAL_HEIGHT = 1000;
    private final int GROUND = 0;
    private final long time_interval = 400;    
    private final double GRAVITY = 9.8;
    private int altitude;
    Thread thread;

    public FreeFallModel() {
        this.altitude = 4000;
        this.bpmObserver = new ArrayList();
        this.beatObserver = new ArrayList();
        thread = new Thread(this);
    }
    
    @Override
    public void initialize() {        
    }

    @Override
    public void on() {
        setAltitude(getAltitude());
        thread.start();
    }

    @Override
    public void off() {
        thread.interrupt();
        setAltitude(GROUND);
    }
    
    public void run() {
        
        double seconds = 0;
        boolean parachute_close = true;
        int current_altitude = getAltitude();
        
        while (parachute_close && getAltitude()>GROUND) {
            try {
                thread.sleep(time_interval);
            } catch (Exception e) {}
            seconds+= 0.1;
            current_altitude= (int) (getAltitude()- 0.5*GRAVITY*Math.pow(seconds, 2));
            setAltitude(current_altitude);
            if (getAltitude()<0) {
                off();
            }
        }
    }
    
    @Override
    public int getAltitude() {
        return altitude;
    }
    
    public void setAltitude(int altitude){
        this.altitude= altitude;
        notifyBPMObserver();
        notifyBeatObserver();
    }
    
    public void registerObserver(BeatObserver o) {
        beatObserver.add(o);
    }

        public void removeObserver(BeatObserver o) {
        int i = beatObserver.indexOf(o);
        if(i>=0)
            beatObserver.remove(o);
    }
    
    public void notifyBeatObserver(){
        for (int i = 0; i < beatObserver.size(); i++) {
            BeatObserver observer = (BeatObserver)beatObserver.get(i);
            observer.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o) {
        bpmObserver.add(o);
    }

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
}
