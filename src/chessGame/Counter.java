package chessGame;

import log_in.Choose;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;


public class Counter{

    Label label1 = new Label("");
    Label label2 = new Label("");

    static Panel panel1 = new Panel();
    static Panel panel2 = new Panel();

    Frame frame = new Frame();
    Timer timer; // timer object
    
    
    // setting initial values, will be set by user later on
    int second =0;

    String ddSecond;
	String ddMinute;
    //to change counter format from 0:0 to 00:00
    DecimalFormat dFormat = new DecimalFormat("00");
    
    public Counter() {}
    
    public void countdownTimer(int minute) {
    	
    	 panel1.setBounds(470, 15, 80, 40);
         panel2.setBounds(470, 580, 80, 40);
         label1.setFont(new Font("Arial",Font.BOLD,24));
         label2.setFont(new Font("Arial",Font.BOLD,24));
         ddMinute = dFormat.format(minute);
         label1.setText(minute+":00");
         label2.setText(minute+":00");
         panel1.add(label1);
         panel2.add(label2);
    	
        // 1000 for the delayed value in milliseconds
        timer = new Timer(1000, new ActionListener() {
        	int min = minute;
        	// will be called each 1 second i.e the delayed value
        	public void actionPerformed(ActionEvent e) {
        		//int minute=min;
            	if(min ==0) {
            		timer.stop(); 
            	}
                second--;
                // setting the format
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(min);
                label1.setText(ddMinute + ":" + ddSecond);
                label2.setText(ddMinute + ":" + ddSecond);

                // condition for continuous calling
                if(second==-1) {
                    second = 59;
                    min--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(min);
                    label1.setText(ddMinute + ":" + ddSecond);
                    label2.setText(ddMinute + ":" + ddSecond);
                }

                // exit condition
                if(min==0 && second==0) {
                    timer.stop();
                }
                if(min<0) {
                	label1.setText("00:00");
                    label2.setText("00:00");
                }
                	
            }
        });
        timer.start();

    }
    public static Panel p1() {
    	return panel1;
    }
    public static Panel p2() {
    	return panel2;
    }

}
