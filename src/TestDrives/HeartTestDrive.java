package TestDrives;
  
import Interfaces.ControllerInterface;
import Controllers.HeartController;
import Models.HeartModel;

public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.getInstance();                
        ControllerInterface model = new HeartController(heartModel);
    }
}
