package main.java.headfirst.combined.djview;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FreeFallView extends DJView{

    JFrame viewFrame;
    JPanel viewPanel;
    JLabel altitudeOutPutLabel;
    JButton setAltitude;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem StarMenuItem;
    JMenuItem StopMenuItem;

    public FreeFallView(ControllerInterface controller, BeatModelInterface model) {
        super(controller, model);
    }

    @Override
    public void createView() {

        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("FreeFall Simulator");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        altitudeOutPutLabel = new JLabel("OFFLINE");
        //viewPanel.add(altitudeOutPutLabel);
        
        
    }

    @Override
    public void createControls() {
        menubar = new JMenuBar();
        menu = new JMenu("Simulation");
        StarMenuItem = new JMenuItem("start");
        StopMenuItem = new JMenuItem("stop");
        setAltitude = new JButton("Altura de Caida");
        setAltitude.setSize(new Dimension(10, 40));
        
        menubar.add(menu);
        menu.add(StarMenuItem);
        menu.add(StopMenuItem);

        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        viewFrame.setJMenuBar(menubar);
        menu.add(exit);

        JPanel InsidePanel= new JPanel(new GridLayout(3,1)); 
        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        JLabel setAltitudeInPut = new JLabel("Ingrese la altura:");
        JTextField AltitudeInPut = new JTextField();
        enterPanel.add(setAltitudeInPut);
        enterPanel.add(AltitudeInPut);
        JPanel ButtonPanel = new JPanel(new GridLayout(1,1));
        JButton setAltitudeButton = new JButton("Set Altura");
        setAltitudeButton.setSize(new Dimension(10,40));
        ButtonPanel.add(setAltitudeButton);
        JPanel OutPutLabelPanel = new JPanel();
        OutPutLabelPanel.add(altitudeOutPutLabel, SwingConstants.CENTER); 
        InsidePanel.add(OutPutLabelPanel);
        InsidePanel.add(enterPanel);
        InsidePanel.add(ButtonPanel);
      
        viewPanel.add(InsidePanel);
        viewPanel.add(new JPanel ());
        
    }

    @Override
    public void updateBPM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBeat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableStopMenuItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableStopMenuItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableStartMenuItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableStartMenuItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
