package log_in;

import chessGame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerHistory implements ActionListener {

	RoundBorderButton back = new RoundBorderButton("Back");
	chessGame.Frame frame = new Frame();

	PlayerHistory() {
		String[] columnNames = {"Opponent", "Army", "Winner", "Time left"};
		Player.ReadDataFromFile();
		Object[][] data = Player.gameData;
		JTable table = new JTable(data, columnNames);

		table.getTableHeader().setBounds(10,10,660,20);
		table.setBounds(10, 30, 660, 490);
		table.setOpaque(false);
		table.setForeground(new Color(0x6d1e00));

		back.addActionListener(this);
		back.setBounds(270, 540, 150, 40);


		ImageIcon icon = new ImageIcon("1_deliverabless/handInverted.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0,1060, 668);

		frame.add(table.getTableHeader(), BorderLayout.NORTH);
		frame.add(table,BorderLayout.CENTER);
		frame.add(back);
		frame.add(imageLabel);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			frame.dispose();
			new historyOrPlayNow();
		}
	}
}
