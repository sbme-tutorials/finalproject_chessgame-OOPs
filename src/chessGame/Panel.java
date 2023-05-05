package chessGame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Panel extends JPanel{
	{
 
	this.setBackground(new Color(0x57354b));
	
	

	}
}

class Label extends JLabel{
	Label(String text){		
		this.setFont(new Font("Arial", Font.BOLD, 10));
		this.setForeground(Color.white);
		this.setText(text);
		//this.setBackground(Color.WHITE);
		
	}

}