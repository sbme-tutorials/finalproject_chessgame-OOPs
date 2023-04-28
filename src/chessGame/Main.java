package chessGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Main {

	public static void main(String[] args){
		Frame frame = new Frame();
		Panel panel1 = new Panel();
		Panel panel2 = new Panel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		label1.setText("00:00");
		label2.setText("00:00");
		label1.setFont(new Font("Monospaced", Font.PLAIN, 22));
		label1.setForeground(Color.WHITE);
		label2.setFont(new Font("Monospaced", Font.PLAIN, 22));
		label2.setForeground(Color.WHITE);
		
		
		panel1.setBounds(600, 50, 100, 50);
		panel2.setBounds(600, 350, 100, 50);
		
		frame.add(panel1);
		frame.add(panel2);
		panel1.add(label1);
		panel2.add(label2);

	}

}
