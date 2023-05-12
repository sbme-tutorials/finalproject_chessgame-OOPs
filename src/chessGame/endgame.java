package chessGame;
import java.awt.event.*;
import Piece.*;

import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import log_in.*;

public class endgame implements ActionListener {
	// frame
		
	Frame f = new Frame();
	// label to display text
	JLabel l= new JLabel();
	JButton back= new JButton("Back");
	JButton newGame= new JButton("New Game");
	
	// default constructor
	endgame(){
		back.addActionListener(this);		
		newGame.addActionListener(this);
		
		back.setBounds(100, 140, 100, 30);
		newGame.setBounds(230, 140, 100, 30);
		
		if(ChessBoard.getWinner() == "black") 
			l.setText("GAME OVER BLACK WINS");
		else if(ChessBoard.getWinner() == "white") 
			l.setText("GAME OVER WHITE WINS");
		else
			l.setText("GAME OVER STALEMATE");

		l.setBounds(80, 80, 300, 30); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.PLAIN, 22));
		
		f.add(l);
		f.add(back);
		f.add(newGame);
		
		// set the size of frame
		f.setSize(450, 300);
		f.setVisible(true);
	}
	
       		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			f.dispose();
			if(welcomePage.getUser()) {
				historyOrPlayNow.disp();
				new historyOrPlayNow();
			}
			else {
				welcomePage.disp();
				new welcomePage();
			}
		}	
		else if(e.getSource()==newGame) {
			f.dispose();
			if(welcomePage.getUser()) {
				historyOrPlayNow.disp();
				new Choose();
			}
			else {
				welcomePage.disp();
				new GameView();
			}
		}
	}
}