package chessGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;

public class Counter{

	Label label = new Label("");
    
    Timer timer; // timer object
    
    // setting initial values, will be set by user later on
    int second = 0;

    String ddSecond;
	String ddMinute;
    //to change counter format from 0:0 to 00:00
    DecimalFormat dFormat = new DecimalFormat("00");
    
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
       			timer.stop();
            }	
       		if(min<0) {
               	label.setText("00:00");
       		}
               	
           }
       });
    }
	public void stop() {
		timer.stop();
	}
	public void start() {
		timer.start();
	}
    
//    public void countdownTimer(int minute) {
//	 
//    	label.setFont(new Font("Arial",Font.BOLD,24));
//    	ddMinute = dFormat.format(minute);
//    	label.setText(minute+":00");
//	
//    	// 1000 for the delayed value in milliseconds
//    	timer = new Timer(1000, new ActionListener() {
//    		int min = minute; 
//    		// will be called each 1 second i.e the delayed value
//    		public void actionPerformed(ActionEvent e) {
//    			
//    			if(min ==0) {
//    				timer.stop();
//    			} 
//	    		second--; 
//	    		// setting the format 
//	    		ddSecond =dFormat.format(second);
//	    		ddMinute = dFormat.format(min);
//	    		label.setText(ddMinute + ":" + ddSecond);
//	    		
//	 // condition for continuous calling
//    		if(second==-1) {
//    			second = 59;
//    			min--;
//    			ddSecond = dFormat.format(second);
//    			ddMinute = dFormat.format(min);
//    			label.setText(ddMinute + ":" + ddSecond);
//    		}
//	 
//	 // exit condition
//    		if(min==0 && second==0) {
//    			timer.stop(); 
//    		}
//    		if(min<0){
//    			label.setText("00:00");
//    		} 
//    		}
//    
//    	}); timer.start();  
//    }
}