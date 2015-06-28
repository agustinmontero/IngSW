package main.java.headfirst.combined.djview;

public class AllModelsTestDrive {

    
    public static void main(String[] args) {
        BeatModelInterface model1 = BeatModel.getInstance();
       ControllerInterface controller1 = new BeatController(model1);
       
       HeartModelInterface model2 = HeartModel.getInstance();
       ControllerInterface controller2 = new HeartController(model2);
       
       FreeFallModelInterface model3 = new FreeFallModel();
       ControllerInterface controller3 = new FreeFallController(model3);
    }
    
}
