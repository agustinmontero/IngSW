package main.java.headfirst.combined.djview;

public class FreeFallTestDrive {

    
    public static void main(String[] args) {
        FreeFallModel freeFmodel = new FreeFallModel();
        ControllerInterface controller = new FreeFallController(freeFmodel);
    }
    
}
