package chessGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayerHistory implements ActionListener {

	JButton back = new JButton("Back");
	Frame frame = new Frame();

	PlayerHistory() {
		back.addActionListener(this);
		back.setBounds(270, 540, 150, 40);
		back.setBackground(new Color(0x57354b));
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setForeground(Color.WHITE);

		frame.add(back);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			frame.dispose();
			new historyOrPlayNow();
		}
	}
}
