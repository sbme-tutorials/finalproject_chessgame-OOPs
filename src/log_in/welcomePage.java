package log_in;

import chessGame.Frame;
import chessGame.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class welcomePage implements ActionListener {
	static GameView game;
	static boolean user = false;
	// frame
	Frame f = new Frame();
	// label to display text
	JLabel l = new JLabel();
	RoundBorderButton button1 = new RoundBorderButton("Log In");
	RoundBorderButton button2 = new RoundBorderButton("Quick Game");
	// create a panel
	JPanel p = new JPanel();
	// add label to panel
	// default constructor
	public welcomePage() {
		l.setText("Welcome           chessmaster");
		l.setBounds(320, 200, 850, 38); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.BOLD, 34));
		l.setForeground(new Color(0x6d1e00));

		button1.addActionListener(this);
		button1.setBounds(190, 510, 150, 40);

		button2.addActionListener(this);
		button2.setBounds(700, 510, 150, 40);

		ImageIcon icon = new ImageIcon("1_deliverabless/KingInverted.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0,1060, 668);

		f.add(l);
		f.add(button1);
		f.add(button2);
		f.add(imageLabel);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1) {
			//f.dispose();
			user = true;
			new LoginPage(new IDandPassword().getLoginInfo());
			f.dispose();
		}
		else if (e.getSource() == button2) {
			f.dispose();
			user = false;
			game = new GameView();
		}
	}
	public static boolean getUser() {
		return user;
	}
	public static void disp() {
		game.dispose();
	}

}


