package chessGame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class historyOrPlayNow extends JFrame implements ActionListener 
{
//frame
	static JFrame f= new JFrame("Chess Game");

	// label to display text
	static JLabel l= new JLabel();
	static JButton button1= new JButton("History");
	 static JButton button2 = new JButton("play now");
	 JPanel p = new JPanel();
	

	// default constructor
	historyOrPlayNow()
	{
l.setText("User name");
		
		l.setBounds(100, 100, 300, 30); //Setting the bounds of the label.
 l.setFont(new Font("Arial", Font.PLAIN, 30));
 
 p.add(l);

 
 p.add(button1);
 button1.addActionListener(this);
  
 p.add(button2);
 button2.addActionListener(this);

// add panel to frame
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
	  
	/*  if(e.getSource()==button1) {
	   f.dispose();
	   History history = new History();
	  }
	  else */
		  if(e.getSource()==button2) {
		   f.dispose();
		   GameView quick_game = new GameView();
		  }
	 }
}

