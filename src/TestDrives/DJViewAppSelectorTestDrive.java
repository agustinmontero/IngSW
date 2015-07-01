package TestDrives;

import Interfaces.ControllerInterface;
import Controllers.FreeFallController;
import Models.FreeFallModel;

public class DJViewAppSelectorTestDrive {
    
     
 public static void main(String[] args) {
    FreeFallModel freeFmodel = new FreeFallModel();
    ControllerInterface controller = new FreeFallController(freeFmodel,"DJViewAppSelector");
}
    
}
