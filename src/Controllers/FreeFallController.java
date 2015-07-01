package Controllers;

import javax.swing.text.View;
import Interfaces.ControllerInterface;
import Views.DJView;
import Views.DJViewAppSelector;
import Adapter.FreeFallAdapter;
import Interfaces.FreeFallModelInterface;
import Interfaces.ViewInterface;


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
        this.model = model;
        if ("FreeFallView".equals(viewName)) {
            //this.initalizeFFView();
        }
        else if("DJViewAppSelector".equals(viewName)){
            this.initalizeDJVAppSelector();
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
    
    /*private void initalizeFFView(){
        this.view = new FreeFallView(this, new FreeFallAdapter(model));
        this.view.createView();
        this.view.createControls();
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
    }*/
    
    private void initalizeDJVAppSelector(){
        this.view = new DJViewAppSelector(this, new FreeFallAdapter(model));
        this.view.createView();
        this.view.createControls();
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
    }
    
}
