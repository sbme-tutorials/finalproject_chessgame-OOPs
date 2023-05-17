package chessGame;

import log_in.Choose;
import log_in.RoundBorderButton;
import log_in.historyOrPlayNow;
import log_in.welcomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endgame implements ActionListener {
	// frame
	Frame f = new Frame();
	// label to display text
	JLabel l= new JLabel();
	RoundBorderButton back= new RoundBorderButton("Back");
	RoundBorderButton newGame= new RoundBorderButton("New Game");
	
	// default constructor
	endgame(){
		back.addActionListener(this);		
		newGame.addActionListener(this);
		
		back.setBounds(110, 210, 125, 30);
		newGame.setBounds(284, 210, 145, 30);
		
		if(ChessBoard.getWinner() == "black")
			l.setText("GAME OVER BLACK WINS");
		else if(ChessBoard.getWinner() == "white") 
			l.setText("GAME OVER WHITE WINS");
		else if(ChessBoard.getWinner() == "draw")
			l.setText("GAME OVER STALEMATE");

		l.setForeground(new Color(0xf7e8d5));

		ChessBoard.setWinner(null);
		GameView.setScore_1("0");
		GameView.setScore_2("0");

		l.setBounds(80, 80, 300, 30); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.PLAIN, 22));
		ImageIcon icon = new ImageIcon("1_deliverabless/endGame.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0,450, 300);
		
		f.add(l);
		f.add(back);
		f.add(newGame);
		f.add(imageLabel);
		
		// set the size of frame
		f.setSize(450, 300);
		f.setLocationRelativeTo(null);
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
			java.awt.Frame[] frames =  GameView.getFrames();

			// Dispose of frames using a for loop
			for (java.awt.Frame frame : frames) {
				frame.dispose();
			}
			f.dispose();
			if(welcomePage.getUser()) {
				historyOrPlayNow.disp();
				new Choose();
			}
			else {
				new GameView();
			}
		}
	}

	public static void main(String[] args) {
		new endgame();
	}
}