package Controllers;
  
import Interfaces.ControllerInterface;
import Views.DJView;
import Adapter.HeartAdapter;
import Interfaces.HeartModelInterface;
import Interfaces.ViewInterface;
import Models.HeartModel;

public class HeartController implements ControllerInterface {
	private HeartModelInterface model;
	private ViewInterface view;
        
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
                view.createView();
                view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();                
	}

        public HeartController(HeartModelInterface model, ViewInterface view) {
            this.model = model;
            this.view = view;
            this.initalizeControls();
        }
        
        
  
	public void start() {}
 
	public void stop() {}
    
	//Intenta crear una nueva instancia de HartModel()
        public void increaseBPM() {
            HeartModel heartModel = HeartModel.getInstance();            
        }
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
        
        private void initalizeControls(){
            view.disableStopMenuItem();
            view.disableStartMenuItem();
        }
}



