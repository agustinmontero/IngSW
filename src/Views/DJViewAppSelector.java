package Views;

import Interfaces.BeatModelInterface;
import Interfaces.ControllerInterface;
import Controllers.FreeFallController;
import Controllers.BeatController;
import Controllers.HeartController;
import Models.HeartModel;
import Models.FreeFallModel;
import Models.BeatModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Observers.BPMObserver;
import Observers.BeatObserver;
import Adapter.FreeFallAdapter;
import Adapter.HeartAdapter;


public class DJViewAppSelector extends DJView{

    private JComboBox modelOption;
    private final DJViewAppSelector viewAppSelector = this;

    public DJViewAppSelector(ControllerInterface controller, BeatModelInterface model) {
        super(controller, model);
        
    }


    @Override
    public void createView() {
        //Dropdown Box
        String[] modelList = new String[]{"HeartModel", "DJModel", "FreeFallModel"};
        this.modelOption = new JComboBox(modelList);
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(3, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        bpmPanel.add(modelOption);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        modelOption.addActionListener(this);
        listenApp();
	}
    
    private void listenApp(){
        modelOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String modelName = (String)cb.getSelectedItem();
                ControllerInterface controllerInterface;
                if ("HeartModel".equals(modelName)) {
                    controller.stop();
                    HeartAdapter heart = new HeartAdapter(HeartModel.getInstance());
                    controllerInterface = new HeartController(heart.getModel(), viewAppSelector);
                    updateModel(heart);
                    updateController(controllerInterface);
                    
                }
                else if("DJModel".equals(modelName)){
                    controller.stop();
                    BeatModelInterface model = new BeatModel();
                    controllerInterface = new BeatController(model, viewAppSelector);
                    updateModel(model);
                    updateController(controllerInterface);
                }
                else{
                    controller.stop();
                    FreeFallAdapter model = new FreeFallAdapter(new FreeFallModel());
                    controllerInterface = new FreeFallController(model.getModel(), viewAppSelector);
                    updateModel(model);
                    updateController(controllerInterface);
                }
            }
        });
    }
    
    private void updateModel(BeatModelInterface model){
        this.model.removeObserver((BeatObserver)this);
        this.model.removeObserver((BPMObserver)this);
        this.model = model;
        this.model.registerObserver((BeatObserver)this);
        this.model.registerObserver((BPMObserver)this);
    }
    
    private void updateController(ControllerInterface controller){
        this.controller = controller;
    }
    
}
