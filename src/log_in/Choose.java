package log_in;

import chessGame.Frame;
import chessGame.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Choose extends JFrame implements ActionListener
{
	static GameView game;
	public static boolean isWhite=false;
	static RoundedTextField opponent = new RoundedTextField(30);

	
	RoundBorderButton start = new RoundBorderButton("Start Game");
	JButton white = new JButton(new ImageIcon("1_deliverabless/whiteKing.png"));
	JButton black = new JButton(new ImageIcon("1_deliverabless/blackKing.png"));
	
	MyButton min1 = new MyButton("01:00 min");
	MyButton min3 = new MyButton("03:00 min");
	MyButton min5 = new MyButton("05:00 min");
	MyButton min10 = new MyButton("10:00 min");
	MyButton min30 = new MyButton("30:00 min");

	chessGame.Frame frame = new Frame();
	
	JLabel opponentl = new JLabel("Enter opponent's name:");
    JLabel whiteText = new JLabel("White");
    JLabel blackText = new JLabel("Black");
    JLabel label1 = new JLabel("Please pick a side");
	JLabel label2 = new JLabel("Please set a timer");
    
		
	static boolean time1 = false;
	static boolean time3 = false;
	static boolean time5 = false;
	static boolean time10 = false;
	static boolean time30 = false;
	
	public Choose(){
		
		
		//opponent section
		opponentl.setForeground(new Color(0x6d1e00));
		opponentl.setFont(new Font("Pacifico", Font.BOLD, 22));
		opponentl.setBounds(50, 0, 550, 100);
		opponent.setBounds(50, 70, 350, 30);
		
		
		//label 1 pick a side !	
		label1.setForeground(new Color(0x6d1e00));
		label1.setFont(new Font("Pacifico", Font.BOLD, 22));
		label1.setBounds(50, 90, 550, 100);
		
		//button1 pick white
		
		white.setBounds(50, 165, 100, 100);
		white.setBackground(Color.WHITE);
		whiteText.setBounds(80,270,100,25);
		whiteText.setFont(new Font("Pacifico", Font.BOLD, 16));
		whiteText.setForeground(new Color(0x6d1e00));
            
		//button 2 pick black
		black.setBounds(150, 165, 100, 100);
		black.setBackground(Color.WHITE);
		blackText.setBounds(175,270,100,25);
		blackText.setFont(new Font("Pacifico", Font.BOLD, 16));
		blackText.setForeground(new Color(0x6d1e00));
		
		//setting a timer
		label2.setForeground(new Color(0x6d1e00));
		label2.setFont(new Font("acifico", Font.BOLD, 22));
		label2.setBounds(50, 280, 550, 100);
		
		min1.setBounds(50, 370, 90, 90);
		min3.setBounds(175, 370, 90, 90);
		min5.setBounds(300, 370, 90, 90);
		min10.setBounds(425, 370, 90, 90);		
		min30.setBounds(550, 370, 90, 90);
		
		min1.addActionListener(this);
		min3.addActionListener(this);
		min5.addActionListener(this);
		min10.addActionListener(this);
		min30.addActionListener(this);
		white.addActionListener(this);
		black.addActionListener(this);
		
		//startgame button
		start.setBounds(450, 550, 400, 50);
		start.setBackground(new Color(0x227423));
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Arial", Font.BOLD, 22));
		start.setFocusable(false);
        start.addActionListener(this);

		ImageIcon icon = new ImageIcon("1_deliverabless/handInverted.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0,1060, 668);
		
		frame.add(label1);
		frame.add(whiteText);
		frame.add(blackText);
		frame.add(label2);
		frame.add(white);
		frame.add(black);
		frame.add(opponentl);
		frame.add(opponent);
		frame.add(start);
		frame.add(min1);
		frame.add(min5);
		frame.add(min3);
		frame.add(min10);
		frame.add(min30);
		frame.add(imageLabel);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==white) {
			isWhite = true;
		}
		if(e.getSource()==black) {
			isWhite = false;
		}
    	if(e.getSource()==min1) {
    		time1 = true;
    		time3 = false;
    		time5 = false;
    		time10 = false;
    		time30 = false;	
    		min1.setBackground(new Color(0xb098eb));
    		min3.setBackground(Color.white);
    		min5.setBackground(Color.white);
    		min10.setBackground(Color.white);
    		min30.setBackground(Color.white);
    	}
    	else if(e.getSource()==min3) {
    		time1 = false;
    		time3 = true;
    		time5 = false;
    		time10 = false;
    		time30 = false;
    		min1.setBackground(Color.white);
    		min3.setBackground(new Color(0xb098eb));
    		min5.setBackground(Color.white);
    		min10.setBackground(Color.white);
    		min30.setBackground(Color.white);
    	}
    	else if(e.getSource()==min5) {
    		time1 = false;
    		time3 = false;
    		time5 = true;
    		time10 = false;
    		time30 = false;
    		min1.setBackground(Color.white);
    		min3.setBackground(Color.white);
    		min5.setBackground(new Color(0xb098eb));
    		min10.setBackground(Color.white);
    		min30.setBackground(Color.white);
    	}
    	else if(e.getSource()==min10) {
    		time1 = false;
    		time3 = false;
    		time5 = false;
    		time10 = true;
    		time30 = false;
    		min1.setBackground(Color.white);
    		min3.setBackground(Color.white);
    		min5.setBackground(Color.white);
    		min10.setBackground(new Color(0xb098eb));
    		min30.setBackground(Color.white);
    	
    	}
    	else if(e.getSource()==min30) {
    		time1 = false;
    		time3 = false;
    		time5 = false;
    		time10 = false;
    		time30 = true;
    		min1.setBackground(Color.white);
    		min3.setBackground(Color.white);
    		min5.setBackground(Color.white);
    		min10.setBackground(Color.white);
    		min30.setBackground(new Color(0xb098eb));
    	}
		
		if(e.getSource()==start) {
    		frame.dispose();
    	    game = new GameView();
    	}
    
	}
	public static int getTimer(){
		if(time1) return 1;
		else if(time3) return 3;
		else if(time5) return 5;
		else if(time10) return 10;
		else if(time30) return 30;
		return 0;
	}
	public static String getOppo() {
		return opponent.getText();
	}
	public static boolean getArmy() {
		return isWhite;
	}
	public static String getColor() {
		if(isWhite)
			return "White";
		return "Black";
	}
	public static JFrame getFrame() {
		return game;
	}
}
