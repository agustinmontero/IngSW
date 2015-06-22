package main.java.headfirst.combined.djview;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FallBar extends JProgressBar{

    JProgressBar jProgressBar;
    FreeFallModel model;

    public FallBar(FreeFallModel model) {
        this.model = model;
        jProgressBar.setValue(TOP);
        jProgressBar.setOrientation(VERTICAL);
    }
    
    
}
