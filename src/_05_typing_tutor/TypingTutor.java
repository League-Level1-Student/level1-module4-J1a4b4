package _05_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JLabel label;
	JFrame frame;
	JPanel panel;
	
	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.setTitle("Type or Die");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentLetter = generateRandomLetter();
		label = new JLabel();
		frame.add(panel);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText(currentLetter + "");
		label.setFont(label.getFont().deriveFont(28.0f));
		frame.addKeyListener(this);
		panel.add(label);
		panel.setPreferredSize(new Dimension(200, 50));
		frame.pack();
		}
	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("YOU TYPED: " + e.getKeyChar());
		if (e.getKeyChar() == currentLetter) {
			System.out.println("CORRECT");
			panel.setBackground(Color.GREEN);
		}else {
			System.out.println("INCORRECT");
			panel.setBackground(Color.RED);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
		frame.pack();
	}
}
