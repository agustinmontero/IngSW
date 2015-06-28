package main.java.headfirst.combined.djview;
  

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = BeatModel.getInstance();
	ControllerInterface controller = new BeatController(model);
    }
}
