package Controllers;
  
import Interfaces.BeatModelInterface;
import Interfaces.ControllerInterface;
import Views.DJView;
import Interfaces.ViewInterface;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	ViewInterface view;
   
	public BeatController(BeatModelInterface model) {
            this.model = model;
            view = new DJView(this, model);
            this.initalizeView();
            
	}

    public BeatController(BeatModelInterface model, ViewInterface view) {
        this.model = model;
        this.view = view;
        this.initalizeView();
    }
        
        
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
        private void initalizeView(){
            view.createView();
            view.createControls();
            view.disableStopMenuItem();
            view.enableStartMenuItem();
            this.model.initialize();
        }
}
