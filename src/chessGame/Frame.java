package chessGame;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	int width = 690;
	int height = 690;
	public Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ChessGame");
		this.setSize(new Dimension(width, height));
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0x908e94));
		this.setLocation(width/2-this.getSize().width/2,0);
		
		ImageIcon image = new ImageIcon("logo.jpg");
		this.setIconImage(image.getImage());
	}

}
