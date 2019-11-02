package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton buttonI;
	JButton buttonII;
	JButton buttonIII;
	JButton buttonIV;
	JTextField fieldI;
	JTextField fieldII;
	JLabel label;
	
	public void add(String varI, String varII) {
		label.setText(Integer.parseInt(varI) + Integer.parseInt(varII) + "");
		
	}
	public void subtract(String varI, String varII) {
		label.setText(Integer.parseInt(varI) - Integer.parseInt(varII) + "");
	}
	public void multiply(String varI, String varII) {
		label.setText(Integer.parseInt(varI) * Integer.parseInt(varII) + "");
	}
	public void divide(String varI, String varII) {
		if (Integer.parseInt(fieldII.getText()) == 0) {
			JOptionPane.showMessageDialog(null, "That's not nice!");
		}else {
			label.setText(Integer.parseInt(varI) / Integer.parseInt(varII) + "");
		}
	}
	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		buttonI = new JButton();
		buttonII = new JButton();
		buttonIII = new JButton();
		buttonIV = new JButton();
		fieldI = new JTextField();
		fieldII = new JTextField();
		label = new JLabel();
		panel.add(fieldI);
		panel.add(fieldII);
		panel.add(buttonI);
		panel.add(buttonII);
		panel.add(buttonIII);
		panel.add(buttonIV);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonI.setText("add");
		buttonII.setText("subtract");
		buttonIII.setText("multiply");
		buttonIV.setText("divide");
		buttonI.addActionListener(this);
		buttonII.addActionListener(this);
		buttonIII.addActionListener(this);
		buttonIV.addActionListener(this);
		fieldI.setPreferredSize(new Dimension(150,50));
		fieldII.setPreferredSize(new Dimension(150,50));
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (buttonI == e.getSource()) {
			add(fieldI.getText(), fieldII.getText());
			panel.add(label);
			frame.pack();
		}else if (buttonII == e.getSource()) {
			subtract(fieldI.getText(), fieldII.getText());
			panel.add(label);
			frame.pack();
		}else if (buttonIII == e.getSource()) {
			multiply(fieldI.getText(), fieldII.getText());
			panel.add(label);
			frame.pack();
		}else if (buttonIV == e.getSource()) {
			divide(fieldI.getText(), fieldII.getText());
			panel.add(label);
			frame.pack();
		}
		
	}
}
