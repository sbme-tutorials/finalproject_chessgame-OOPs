package chessGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	
	Frame(){
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("chessGame");
		this.setResizable(false);
		this.setSize(800, 550);

		
		ImageIcon image = new ImageIcon("logo.jpg");
		this.setIconImage(image.getImage());
		
	}

}
