package chessGame;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JButton;

public class History extends Frame{
	
	History(String name,String opponent,double status, 	String time){
		
		
		JButton but = new JButton();
		JFrame frame = new JFrame();
		JLabel lab = new JLabel();
		
		ArrayList <String> names = new ArrayList <String>();
		ArrayList <Double> score = new ArrayList <Double>();
		ArrayList <String> tim = new ArrayList <String>();

		String[] columnsNames = { "OpponentName", "Score", "Time"};
		
		names.add(opponent);
		score.add(status);
		tim.add(time);
		
		Object[][] data = {
                {opponent, status, time }
                
                            };
		
		/*if (tim.size() != 1) {
		
		for (int i = 0; i <tim.size(); i++) {	
			for (int j = 0; j < 3; j++) {
                				
			//data [i][j] = opponent;
				//Object[][] dat
			
			}
		}*/
//		                       }
	
		
		/*but.setBounds(100, 100, 80, 20);
		but.setText("Back");*/
		
		
		
        JTable table = new JTable(data, columnsNames);
        //frame.add(but);
        frame.add(table.getTableHeader(), BorderLayout.PAGE_START);
        frame.add(table, BorderLayout.CENTER);	
        frame.setSize(500,599);
		frame.setVisible( true);
		
	}
	

}
