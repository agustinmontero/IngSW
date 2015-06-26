package main.java.headfirst.combined.djview;

import javax.swing.text.View;


public class FreeFallController implements ControllerInterface{
    
    FreeFallModelInterface model;
    ViewInterface view;

    public FreeFallController(FreeFallModelInterface model) {
        this.model = model;        
        view = new DJView(this, new FreeFallAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public FreeFallController(FreeFallModelInterface model, String viewName) {
        if (viewName == "FreeFallView") {
            this.model = model;
            this.view = new FreeFallView(this, new FreeFallAdapter(model));
            this.view.createView();
            this.view.createControls();
            this.view.disableStopMenuItem();
            this.view.enableStartMenuItem();
        }
        else if(viewName == "DJViewAppSelector"){
            this.model = model;
            this.view = new DJViewAppSelector(this, new FreeFallAdapter(model));
            this.view.createView();
            this.view.createControls();
            this.view.disableStopMenuItem();
            this.view.enableStartMenuItem();
        }
    }
    
    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.enableStartMenuItem();
        view.disableStopMenuItem();
    }

    @Override
    public void increaseBPM() {
        
    }

    @Override
    public void decreaseBPM() {
        
    }

    @Override
    public void setBPM(int bpm) {
        model.setAltitude(bpm);
    }
    
}
