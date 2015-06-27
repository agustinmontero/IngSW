package main.java.headfirst.combined.djview;

public class FreeFallViewTestDrive {
    
     
 public static void main(String[] args) {
    FreeFallModel freeFmodel = new FreeFallModel();
    ControllerInterface controller = new FreeFallController(freeFmodel,"DJViewAppSelector");
}
    
}
