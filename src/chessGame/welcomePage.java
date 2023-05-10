package chessGame;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class welcomePage implements ActionListener {
	
	static boolean user = false;
	// frame
	Frame f = new Frame();
	// label to display text
	JLabel l = new JLabel();
	JButton button1 = new JButton("Log In");
	JButton button2 = new JButton("Quick Game");

	// create a panel
	JPanel p = new JPanel();

	// add label to panel


	// default constructor
	welcomePage() {
		l.setText("Welcome to the game!");
		l.setBounds(220, 200, 350, 35); //Setting the bounds of the label.
		l.setFont(new Font("Arial", Font.BOLD, 24));
		l.setForeground(new Color(0x57354b));

		button1.addActionListener(this);
		button1.setBounds(170, 340, 150, 40);
		button1.setBackground(new Color(0x57354b));
		button1.setFont(new Font("Arial", Font.BOLD, 20));
		button1.setForeground(Color.WHITE);

		button2.addActionListener(this);
		button2.setBounds(360, 340, 150, 40);
		button2.setBackground(new Color(0x57354b));
		button2.setFont(new Font("Arial", Font.BOLD, 20));
		button2.setForeground(Color.WHITE);

		f.add(l);
		f.add(button1);
		f.add(button2);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1) {
			f.dispose();
			user = true;
			new LoginPage(new IDandPassword().getLoginInfo());
		} else if (e.getSource() == button2) {
			f.dispose();
			new GameView();
		}
	}
	public static boolean getUser() {
		return user;
	}
}

