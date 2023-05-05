package log_in;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chessGame.Counter;
import chessGame.Frame;
import chessGame.GameView;

public class Choose implements ActionListener{
	JButton start = new JButton("Start Game");
	JButton white = new JButton(new ImageIcon("1_deliverabless/Piece/chess (1).png"));
	JButton black = new JButton(new ImageIcon("1_deliverabless/Piece/chess.png"));
	
	MyButton min1 = new MyButton("01:00 min");
	MyButton min3 = new MyButton("03:00 min");
	MyButton min5 = new MyButton("05:00 min");
	MyButton min10 = new MyButton("10:00 min");
	MyButton min30 = new MyButton("30:00 min");

	Frame frame = new Frame();
	
    JLabel whiteText = new JLabel("white");
    JLabel blackText = new JLabel("black");
    JLabel label1 = new JLabel("Please pick a side");
	JLabel label2 = new JLabel("Please set a timer");
    
	Counter counter = new Counter();
	
	static boolean time1 = false;
	static boolean time3 = false;
	static boolean time5 = false;
	static boolean time10 = false;
	static boolean time30 = false;
	
	public void Lastframe(){
		//label 1 pick a side !	
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Pacifico", Font.BOLD, 28));
		label1.setBounds(50, 0, 550, 100);
		
		//button1 pick white
		
		white.setBounds(50, 100, 100, 100);
		white.setBackground(Color.WHITE);
		whiteText.setBounds(80,210,100,25);
		whiteText.setFont(new Font("Pacifico", Font.BOLD, 18));
		whiteText.setForeground(Color.WHITE);
            
		//button 2 pick black
		black.setBounds(175, 100, 100, 100);
		black.setBackground(Color.WHITE);
		
		blackText.setBounds(200,210,100,25);
		blackText.setFont(new Font("Pacifico", Font.BOLD, 18));
		blackText.setForeground(Color.WHITE);
		
		//setting a timer
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("acifico", Font.BOLD, 28));
		label2.setBounds(50, 300, 550, 100);
		
		min1.setBounds(50, 400, 90, 90);
		min3.setBounds(175, 400, 90, 90);
		min5.setBounds(300, 400, 90, 90);
		min10.setBounds(425, 400, 90, 90);		
		min30.setBounds(550, 400, 90, 90);
		
		//startgame button
		start.setBounds(250, 550, 200, 50);
		start.setBackground(new Color(0x57354b));
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Arial", Font.BOLD, 22));
		start.setFocusable(false);
        start.addActionListener(this);
		
		frame.add(label1);
		frame.add(whiteText);
		frame.add(blackText);
		frame.add(label2);
		frame.add(white);
		frame.add(black);
		frame.add(start);
		frame.add(min1);
		frame.add(min5);
		frame.add(min3);
		frame.add(min10);
		frame.add(min30);
		//frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==min1) {
    		time1 = true;
    		time3 = false;
    		time5 = false;
    		time10 = false;
    		time30 = false;
    		min1.setBackground(new Color(0xedc3bb));
    	}
    	else if(e.getSource()==min3) {
    		time1 = false;
    		time3 = true;
    		time5 = false;
    		time10 = false;
    		time30 = false;
    	}
    	else if(e.getSource()==min5) {
    		time1 = false;
    		time3 = false;
    		time5 = true;
    		time10 = false;
    		time30 = false;
    	}
    	else if(e.getSource()==min10) {
    		time1 = false;
    		time3 = false;
    		time5 = false;
    		time10 = true;
    		time30 = false;
    	}
    	else if(e.getSource()==min30) {
    		time1 = false;
    		time3 = false;
    		time5 = false;
    		time10 = false;
    		time30 = true;
    	}
		
		if(e.getSource()==start) {
    		frame.dispose();
    		new GameView();
    	}
    
	}
	public static int getTimer(){
		if(time1) {
			return 1;
		}
		else if(time3) {
			return 3;
		}
		else if(time5) {
			return 5;
		}
		else if(time10) {
			return 10;
		}
		else if(time30) {
			return 30;
		}
		return 0;
	}
}