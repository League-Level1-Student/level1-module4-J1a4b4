package _01_nasty_surprise;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton buttonI;
	JButton buttonII;
	
	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		buttonI = new JButton();
		buttonII = new JButton();
		frame.add(panel);
		panel.add(buttonI);
		panel.add(buttonII);
		buttonI.setText("Trick!");
		buttonII.setText("Treat!");
		buttonI.addActionListener(this);
		buttonII.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (buttonI == e.getSource()) {
			playSound("moo.wav");
		}else if (buttonII == e.getSource()) {
			playSound("moo.wav");
		}
		
	}
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
