package chessGame;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JButton;
import java.util.List;
import javax.swing.table.TableCellEditor;


public class History extends Frame{
	
	History(String name,String opponent,double status, 	String time){
		
		
		//JButton but = new JButton();
		Frame frame = new Frame();
		
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
