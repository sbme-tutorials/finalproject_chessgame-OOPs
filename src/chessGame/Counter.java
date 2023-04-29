package chessGame;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;
 
public class Counter{ 
	
	Label label1 = new Label();
	Label label2 = new Label();
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	
	Frame frame = new Frame();
	Timer timer; // timer object
    
	// setting initial values, will be set by user later on
	int second =0; 
	int minute =3;
	
	
	String ddSecond, ddMinute;
	//to change counter format from 0:0 to 00:00
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public Counter() {
		
		label1.setText("03:00");
		label2.setText("03:00");
		
		panel1.setBounds(600, 50, 100, 50);
		panel2.setBounds(600, 350, 100, 50);
		
		frame.add(panel1);
		frame.add(panel2);
		
		panel1.add(label1); 
		panel2.add(label2);
		
		// calling timer function
		countdownTimer();
		timer.start();
		
	}
	
	public void countdownTimer()	{
	
		// 1000 for the delayed value in milliseconds
		timer = new Timer(1000, new ActionListener() {
			
			// will be called each 1 second i.e the delayed value
			public void actionPerformed(ActionEvent e) {
				
				second--;
				// setting the format
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				label1.setText(ddMinute + ":" + ddSecond);
				label2.setText(ddMinute + ":" + ddSecond);
				
				// condition for continuous calling
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					label1.setText(ddMinute + ":" + ddSecond);
					label2.setText(ddMinute + ":" + ddSecond);
				}
				
				// exit condition
				if(minute==0 && second==0) {
					timer.stop();
				}
			}
		});		
	    
		
	}
}
