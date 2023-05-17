package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Counter{
	public static boolean end = false;
	public static String winner;
	public static String time;
	
	Label label = new Label("");
    
    Timer timer; // timer object
    
    // setting initial values, will be set by user later on
    int second = 0;

    String ddSecond;
	String ddMinute;
    //to change counter format from 0:0 to 00:00
    DecimalFormat dFormat = new DecimalFormat("00");

	public static void setTime(String time) {
		Counter.time = time;
	}

	public Counter(int minute) {
        label.setFont(new Font("Arial",Font.BOLD,24));
        ddMinute = dFormat.format(minute);
        label.setText(minute+":00");

        // 1000 for the delayed value in milliseconds
        timer = new Timer(1000, new ActionListener() {
       	int min = minute;
       	// will be called each 1 second i.e the delayed value
       	public void actionPerformed(ActionEvent e) {
       		
       		second--;
       		// setting the format
       		ddSecond = dFormat.format(second);
       		ddMinute = dFormat.format(min);
       		label.setText(ddMinute + ":" + ddSecond);
       		
       		// condition for continuous calling
       		if(second==-1) {
       			second = 59;
       			min--;
       			ddSecond = dFormat.format(second);
       			ddMinute = dFormat.format(min);
       			label.setText(ddMinute + ":" + ddSecond);
       		}
       		// exit condition
       		if(min==0 && second==0) {
       			end = true;
       			timer.stop();
            }	
       		if(min<0) {
               	label.setText("00:00");
       		}
       		time = label.getText();  	
           }
       });
        
    }
	public void stop() {
		timer.stop();
	}
	public void start() {
		timer.start();
	}
	public boolean getEnd() {
		return end;
	}
	public static String getTime() {
		return time;
	}
}