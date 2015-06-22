package main.java.headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
        
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
                view.createView();
                view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();                
	}
  
	public void start() {}
 
	public void stop() {}
    
	//Intenta crear una nueva instancia de HartModel()
        public void increaseBPM() {
            HeartModel heartModel = HeartModel.getInstance();            
        }
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



