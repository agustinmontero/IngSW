package main.java.headfirst.combined.djview;


public interface FreeFallModelInterface {
    
    void initialize();
    void on();
    void off();
    
    void setAltitude(int altitude);
    int getAltitude();
    
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
    
}
