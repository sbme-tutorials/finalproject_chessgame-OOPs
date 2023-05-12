package chessGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

public class PlayerHistory implements ActionListener {

	JButton back = new JButton("Back");
	Frame frame = new Frame();

	PlayerHistory() {
		String[] columnNames = {"Opponent", "Army", "Winner", "Time left"};
		Player.ReadDataFromFile();
		Object[][] data = Player.gameData;
		JTable table = new JTable(data, columnNames);
		
		table.getTableHeader().setBounds(10,10,660,20);
		table.setBounds(10, 30, 660, 490);
		
		back.addActionListener(this);
		back.setBounds(270, 540, 150, 40);
		back.setBackground(new Color(0x57354b));
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setForeground(Color.WHITE);
		
		frame.add(table.getTableHeader(), BorderLayout.NORTH);
		frame.add(table,BorderLayout.CENTER);
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
