package TestDrives;
  
import Controllers.BeatController;
import Interfaces.BeatModelInterface;
import Interfaces.ControllerInterface;
import Models.BeatModel;


public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
	ControllerInterface controller = new BeatController(model);
    }
}
