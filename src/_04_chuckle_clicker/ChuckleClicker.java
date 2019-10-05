package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {

	JButton buttonI;
	JButton buttonII;
	
	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		buttonI = new JButton();
		buttonII = new JButton();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(buttonI);
		panel.add(buttonII);
		buttonI.setText("Joke");
		buttonII.setText("Punchline");
		buttonI.addActionListener(this);
		buttonII.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonI) {
			System.out.println("Have you looked in a mirror lately?");
		}
		if (e.getSource() == buttonII) {
			System.out.println("<laughter>");
		}
	}
}
