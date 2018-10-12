package Adapter;

import Interfaces.BeatModelInterface;
import Observers.BPMObserver;
import Observers.BeatObserver;
import Interfaces.FreeFallModelInterface;


public class FreeFallAdapter implements BeatModelInterface{
    
    private FreeFallModelInterface freeFall;

    public FreeFallAdapter(FreeFallModelInterface freeFall) {
        this.freeFall = freeFall;
    }    

    @Override
    public void initialize() {        
    }

    @Override
    public void on() {
        freeFall.on();
    }

    @Override
    public void off() {
        freeFall.off();
    }

    @Override
    public void setBPM(int bpm) {
        freeFall.setAltitude(bpm);
    }

    @Override
    public int getBPM() {
        return freeFall.getAltitude();
    }
    
    public double getGravity(){
        return freeFall.getGravity();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        freeFall.registerObserver(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        freeFall.removeObserver(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        freeFall.registerObserver(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        freeFall.removeObserver(o);
    }
    
    public FreeFallModelInterface getModel(){
        return freeFall;
    }
    
    public void setMass(double m){
        this.freeFall.setMass(m);
    }
    
    public double getMass(){
        return freeFall.getMass();
    }
}
