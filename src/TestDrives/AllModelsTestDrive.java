package TestDrives;

import Controllers.BeatController;
import Interfaces.BeatModelInterface;
import Interfaces.ControllerInterface;
import Controllers.FreeFallController;
import Interfaces.FreeFallModelInterface;
import Controllers.HeartController;
import Interfaces.HeartModelInterface;
import Models.HeartModel;
import Models.FreeFallModel;
import Models.BeatModel;

public class AllModelsTestDrive {

    
    public static void main(String[] args) {
        BeatModelInterface model1 = new BeatModel();
       ControllerInterface controller1 = new BeatController(model1);
       
       HeartModelInterface model2 = HeartModel.getInstance();
       ControllerInterface controller2 = new HeartController(model2);
       
       FreeFallModelInterface model3 = new FreeFallModel();
       ControllerInterface controller3 = new FreeFallController(model3);
    }
    
}
