package Views;

import models.FreeFallModel;
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
