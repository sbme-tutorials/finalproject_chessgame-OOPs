package log_in;

import chessGame.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class History extends chessGame.Frame {

	History(String name,String opponent,double status, 	String time){


		//JButton but = new JButton();
		chessGame.Frame frame = new Frame();

		ArrayList <String> names = new ArrayList <String>();
		ArrayList <Double> score = new ArrayList <Double>();
		ArrayList <String> tim = new ArrayList <String>();

		String[] columnsNames = { "OpponentName", "Score", "Time"};

		names.add(opponent);
		score.add(status);
		tim.add(time);

		Object[][] data = {{opponent, status, time}};

		JTable table = new JTable(data, columnsNames);

		table.setBounds(0, 0, 690, 690);
		//table.setLocation(100,20);
		//table.setRowHeight(30);
		//table.setRowMargin(300);

		frame.add(table.getTableHeader());
		frame.add(table, BorderLayout.CENTER);

		/*if (tim.size() != 1) {

		for (int i = 0; i <tim.size(); i++) {
			for (int j = 0; j < 3; j++) {

			    //data [i][j] = opponent;
				//Object[][] dat

			    }
		   }*/
//      }


		/*but.setBounds(100, 100, 80, 20);
		but.setText("Back");*/
		//frame.add(but);

	}


}