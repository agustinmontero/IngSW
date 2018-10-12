package Views;

import javax.swing.*;

public class BeatBar extends JProgressBar implements Runnable {

	BeatBar() {
		Thread thread = new Thread(this);
		setMaximum(100);
		thread.start();
	}

	public void run() {
		for(;;) {
			int value = getValue();
			value = (int)(value * 0.90);
			setValue(value);
			repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e) {};
		}
	}	
}
