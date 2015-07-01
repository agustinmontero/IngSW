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
    private boolean flag;

    public FreeFallController(FreeFallModelInterface model) {
        flag = false;
        this.model = model;        
        view = new DJView(this, new FreeFallAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public FreeFallController(FreeFallModelInterface model, String viewName) {
        this.model = model;
        if("DJViewAppSelector".equals(viewName)){
            this.initalizeDJVAppSelector();
        }
    }

    public FreeFallController(FreeFallModelInterface model, ViewInterface view) {
        this.model = model;
        this.view = view;
        this.initalizeControls();
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
    
    private void initalizeDJVAppSelector(){        
        this.view = new DJViewAppSelector(this, new FreeFallAdapter(model));
        this.view.createView();
        this.view.createControls();
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
        
    }
    
    private void initalizeControls(){
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
        this.model.initialize();
    }
    
}