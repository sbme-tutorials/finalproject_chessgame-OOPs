package chessGame;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import chessGame.LoginPage;
import chessGame.GameView;

public class welcomePage extends JFrame implements ActionListener {
	// frame
		
	JFrame f = new JFrame("Chess Game");
		// label to display text
		 JLabel l= new JLabel();
		 JButton button1= new JButton("Log In");
		 JButton button2= new JButton("Quick Game");
			
			// create a panel
			JPanel p = new JPanel();

			// add label to panel
			

		// default constructor
		welcomePage()
		{
			l.setText("Welcome To The Game!");

			l.setBounds(100, 100, 300, 30); //Setting the bounds of the label.
	       l.setFont(new Font("Arial", Font.PLAIN, 30));
	       

			p.add(l);
			button1.addActionListener(this);
			p.add(button1);
			button2.addActionListener(this);
			p.add(button2);
			f.add(p);

			// set the size of frame
			f.setSize(300, 300);
			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.show();
		}

		
		// main class
		//public static void main(String[] args){}

		@Override
		 public void actionPerformed(ActionEvent e) {
		  
		  if(e.getSource()==button1) {
		   f.dispose();
		   LoginPage login = new LoginPage();
		  }
		  else if(e.getSource()==button2) {
			   f.dispose();
			   GameView quickgame = new GameView();
			  }
		 }
	}


