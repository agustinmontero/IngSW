package TestDrives;

import Interfaces.ControllerInterface;
import Controllers.FreeFallController;
import models.FreeFallModel;

public class FreeFallTestDrive {

    
    public static void main(String[] args) {
        FreeFallModel freeFmodel = new FreeFallModel();
        ControllerInterface controller = new FreeFallController(freeFmodel);
    }
    
}
