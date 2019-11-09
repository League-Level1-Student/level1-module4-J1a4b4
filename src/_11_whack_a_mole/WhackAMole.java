package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel;
	int whacked = 0;
	Date startTime;

	public void run() {
		startTime = new Date();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		randomize();
	}

	void randomize() {
		Random random = new Random();
		for (int j = 0; j < 100; j++) {
			frame.remove(panel);
			panel = new JPanel();
			frame.add(panel);
			int mole = random.nextInt(23) + 1;
			for (int i = 1; i < 25; i++) {
				JButton button = new JButton();
				panel.add(button);
				button.addActionListener(this);
				if (i == mole) {
					button.setText("mole!");
				}
				if (whacked == 10) {
					endGame(startTime, whacked);
				}
				frame.setSize(new Dimension(600, 200));
			}
			}
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton identifier = (JButton) e.getSource();
		if (identifier.getText().equals("mole!")) {
			whacked = whacked + 1;
			speak("Ouch!");
			randomize();
		} else if (!identifier.getText().equals("mole!")) {
			JOptionPane.showMessageDialog(null, "Haha!  You missed me! -Mole");
		}

	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
