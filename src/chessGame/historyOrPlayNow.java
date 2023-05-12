package chessGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import log_in.Choose;

public class historyOrPlayNow implements ActionListener{
	
	static Choose game;
	//frame
	Frame f= new Frame();

	// label to display text
	static JLabel l= new JLabel();
	static JButton button1= new JButton("History");
	static JButton button2 = new JButton("Play now");
	
	// default constructor
	historyOrPlayNow(){
		l.setText("Welcome "+LoginPage.getName());
		l.setBounds(220, 200, 300, 30); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.PLAIN, 30));
		l.setForeground(Color.WHITE);
		
		button1.addActionListener(this);
		button1.setBounds(170, 340, 150, 40);
		button1.setBackground(new Color(0x57354b));
		button1.setFont(new Font("Arial",Font.BOLD,20));
        button1.setForeground(Color.WHITE);
		
		button2.addActionListener(this);
		button2.setBounds(360, 340, 150, 40);
		button2.setBackground(new Color(0x57354b));
		button2.setFont(new Font("Arial",Font.BOLD,20));
        button2.setForeground(Color.WHITE);

		// add panel to frame
		f.add(button1);
		f.add(l);
		f.add(button2);
		f.setVisible(true);
	}

	@Override
	 public void actionPerformed(ActionEvent e) {
	  
	   if(e.getSource()==button1) {
		   f.dispose();
		   new PlayerHistory();
	  }
	  else if(e.getSource()==button2) {
		  f.dispose();
		  game = new Choose();
		  }
	 }
	public static void disp() {
		game.dispose();
	}
}