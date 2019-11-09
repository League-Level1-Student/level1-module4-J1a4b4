package _12_slot_machine;

import java.awt.Dimension;
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
	int winnings = 100;

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		money = new JLabel();
		frame.add(panel);
		button.setText("Spin to Win!");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.add(reelOne);
		panel.add(reelTwo);
		panel.add(reelThree);
		panel.add(button);
		panel.add(money);
		money.setText("$" + winnings);
		frame.setPreferredSize(new Dimension(1000, 1500));
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
		winnings = winnings - 10;
		Random random = new Random();
		
		frame.remove(panel);
		panel.remove(reelOne);
		panel.remove(reelTwo);
		panel.remove(reelThree);
		panel.remove(button);
		panel.remove(money);
		JPanel panelI = new JPanel();
		JLabel reelOneX = new JLabel();
		JLabel reelTwoX = new JLabel();
		JLabel reelThreeX = new JLabel();
		JButton buttonX = new JButton();
		buttonX.setText("Spin to Win!");
		buttonX.addActionListener(this);
		int reelI = random.nextInt(3);
		int reelII = random.nextInt(3);
		int reelIII = random.nextInt(3);
		if (reelI == 0) {
			try {
				reelOneX = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 1) {
			try {
				reelOneX = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 2) {
			try {
				reelOneX = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (reelII == 0) {
			try {
				reelTwoX = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 1) {
			try {
				reelTwoX = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 2) {
			try {
				reelTwoX = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (reelIII == 0) {
			try {
				reelThreeX = createLabelImage("cherries.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 1) {
			try {
				reelThreeX = createLabelImage("bar.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}else if (reelI == 2) {
			try {
				reelThreeX = createLabelImage("sevens.png");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		panelI.add(reelOneX);
		panelI.add(reelTwoX);
		panelI.add(reelThreeX);
		panelI.add(buttonX);
		money.setText("$" + winnings);
		panelI.add(money);
		frame.add(panelI);
		frame.pack();
		
	}
}
