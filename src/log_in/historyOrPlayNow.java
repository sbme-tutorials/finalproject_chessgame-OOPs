package log_in;

import chessGame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class historyOrPlayNow implements ActionListener{
	
	static Choose game;
	//frame
	chessGame.Frame f= new Frame();

	// label to display text
	static JLabel l= new JLabel();
	static RoundBorderButton button1= new RoundBorderButton("History");
	static RoundBorderButton button2 = new RoundBorderButton("Play now");
	
	// default constructor
	public historyOrPlayNow(){
		l.setText("Welcome "+ LoginPage.getName());
		l.setBounds(220, 200, 300, 30); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.PLAIN, 36));
		l.setForeground(new Color(0x6d1e00));
		
		button1.addActionListener(this);
		button1.setBounds(170, 340, 150, 40);

		
		button2.addActionListener(this);
		button2.setBounds(360, 340, 150, 40);

		ImageIcon icon = new ImageIcon("1_deliverabless/handInverted.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0,1060, 668);

		// add panel to frame
		f.add(button1);
		f.add(l);
		f.add(button2);
		f.add(imageLabel);
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