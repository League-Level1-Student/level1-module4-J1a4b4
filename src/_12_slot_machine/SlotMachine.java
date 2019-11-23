package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton button;
	JLabel reelOne;
	JLabel reelTwo;
	JLabel reelThree;
	JLabel money;
	JButton exitB;
	int winnings = 100;
	int wins = 0;

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		exitB = new JButton();
		money = new JLabel();
		frame.add(panel);
		button.setText("Spin to Win!");
		exitB.setText("Quit");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exitB.addActionListener(this);
		button.addActionListener(this);
		try {
			reelOne = createLabelImage("cherries.png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			reelTwo = createLabelImage("bar.png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			reelThree = createLabelImage("sevens.png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		panel.add(button);
		panel.add(money);
		panel.add(exitB);
		panel.add(reelOne);
		panel.add(reelTwo);
		panel.add(reelThree);
		money.setText("$" + winnings);
		frame.pack();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exitB)) {
			frame.remove(panel);
			panel.remove(reelOne);
			panel.remove(reelTwo);
			panel.remove(reelThree);
			panel.remove(button);
			panel.remove(money);
			panel.remove(exitB);
			if (winnings - 100 > 0) {
				int extra = winnings - 100;
				money.setText("Congratulations!  You walked away with $" + winnings + ", $" + extra + " more than you started with!");
			}else {
				money.setText("Congratulations!  You walked away with $" + winnings + "!");
			}
			panel.add(money);
			frame.add(panel);
			frame.pack();
		}else if (e.getSource().equals(button)) {
			winnings = winnings - 10;
		Random random = new Random();
		frame.remove(panel);
		panel.remove(reelOne);
		panel.remove(reelTwo);
		panel.remove(reelThree);
		panel.remove(button);
		panel.remove(money);
		panel.remove(exitB);
		reelOne = new JLabel();
		reelTwo = new JLabel();
		reelThree = new JLabel();
		int reelI = random.nextInt(3);
		int reelII = random.nextInt(3);
		int reelIII = random.nextInt(3);
		if (reelI == 0) {
			try {
				reelOne = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 1) {
			try {
				reelOne = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 2) {
			try {
				reelOne = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (reelII == 0) {
			try {
				reelTwo = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelII == 1) {
			try {
				reelTwo = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelII == 2) {
			try {
				reelTwo = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (reelIII == 0) {
			try {
				reelThree = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelIII == 1) {
			try {
				reelThree = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelIII == 2) {
			try {
				reelThree = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		panel.add(button);
		money.setText("$" + winnings);
		panel.add(money);
		panel.add(exitB);
		panel.add(reelOne);
		panel.add(reelTwo);
		panel.add(reelThree);
		frame.add(panel);
		frame.pack();
		if (reelI == 0 && reelII == 0 && reelIII == 0) {
			winnings = winnings + 30;
			JOptionPane.showMessageDialog(null, "Congratulations!  You won $30!");
			wins = wins + 1;
		}else if (reelI == 1 && reelII == 1 && reelIII == 1) {
			winnings = winnings + 100;
			JOptionPane.showMessageDialog(null, "Congratulations!  You won $100!");
			wins = wins + 1;
		}else if (reelI == 2 && reelII == 2 && reelIII == 2) {
			winnings = winnings + 70;
			JOptionPane.showMessageDialog(null, "Congratulations!  You won $70!");
			wins = wins + 1;
		}else {
			wins = 0;
		}
		if (wins == 2) {
			winnings = winnings + 100;
			JOptionPane.showMessageDialog(null, "Two wins in a row!  You win an extra $100!");
		}else if (wins == 3) {
			winnings = winnings + 1000;
			JOptionPane.showMessageDialog(null, "Three wins in a row!  You win an extra $1000!");
		}else if (wins == 4) {
			winnings = winnings + 10000;
			JOptionPane.showMessageDialog(null, "Four wins in a row!  You win an extra $10000!");
		}else if (wins == 5) {
			winnings = winnings + 100000;
			JOptionPane.showMessageDialog(null, "Five wins in a row!  You win an extra $100000!");
		}else if (wins == 6) {
			winnings = winnings + 1000000;
			JOptionPane.showMessageDialog(null, "Six wins in a row!  You win an extra $1000000!");
		}
		frame.pack();
		}
	}
}
