package main.java.headfirst.combined.djview;

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


public class DJViewAppSelector extends DJView{
    
    //Dropdown Box
    String[] modelList;
    JComboBox modelOption;

    public DJViewAppSelector(ControllerInterface controller, BeatModelInterface model) {
        super(controller, model);
        
    }

    
    @Override
    public void createView() {
        this.modelList = new String[]{"HeartModel", "DJModel", "FreeFallModel"};
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
        // DROP BOX DOWN?        
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
                if ("HeartModel".equals(modelName)) {
                    
                }
                else{}
            }
        });
    }
    
    public void updateModel(BeatModelInterface model){
        this.model.removeObserver((BeatObserver)this);
        this.model.removeObserver((BPMObserver)this);
        this.model = model;
        this.model.registerObserver((BeatObserver)this);
        this.model.registerObserver((BPMObserver)this);
    }
    
    public void updateController(ControllerInterface controller){
        this.controller = controller;
    }
    
}
