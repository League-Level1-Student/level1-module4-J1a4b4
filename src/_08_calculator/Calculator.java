package _08_calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
	
	public void add(int varI, int varII, int output) {
		output = varI + varII;
	}
	public void subtract(int varI, int varII, int output) {
		output = varI - varII;
	}
	public void multiply(int varI, int varII, int output) {
		output = varI * varII;
	}
	public void divide(int varI, int varII, int output) {
		output = varI / varII;
	}
	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton buttonI = new JButton();
		JButton buttonII = new JButton();
		JButton buttonIII = new JButton();
		JButton buttonIV = new JButton();
	}
}
