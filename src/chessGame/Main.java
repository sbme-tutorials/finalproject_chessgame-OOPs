package chessGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Main {

	public static void main(String[] args){
		
		//Timer timer = new Timer(1000, ActionListener());
		
		Frame frame = new Frame();
		Panel panel1 = new Panel();
		Panel panel2 = new Panel();
		Label label1 = new Label();
		Label label2 = new Label();
		
		label1.setText("00:00");
		label2.setText("00:00");
		
		
		panel1.setBounds(600, 50, 100, 50);
		panel2.setBounds(600, 350, 100, 50);
		
		frame.add(panel1);
		frame.add(panel2);
		panel1.add(label1);
		panel2.add(label2);
		
		/*
		 * timer.start(); }
		 * 
		 * private static ActionListener ActionListener() { labela.setText(timePassed())
		 * return null; }
		 * 
		 * private static Object timePassed() { int counterm = 10; int counters = 10;
		 * 
		 * @Override public void run() { if (counterm>=0&&counters>=0) {
		 * System.out.printf("%02d:%02d\n",counterm, counters); counters--;
		 * if(counters==0&&counterm!=0) { counterm--; counters = 60; } } else {
		 * System.out.println("Time is up"); timer.cancel(); }
		 * 
		 * }
		 * 
		 * timer.scheduleAtFixedRate(task, 0, 1000); return null;
		 */	}

}

