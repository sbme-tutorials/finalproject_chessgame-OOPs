package chessGame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Panel extends JPanel{
	{
 
	this.setBackground(new Color(0x072657));
	
	

	}
}

class Label extends JLabel{
	{
		this.setFont(new Font("Arial", Font.PLAIN, 38));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setForeground(Color.WHITE);
		
	}
}
