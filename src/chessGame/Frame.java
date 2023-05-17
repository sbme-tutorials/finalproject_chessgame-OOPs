package chessGame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	int width = 1060;
	int height = 668;
	public Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ChessGame");
		this.setSize(new Dimension(width, height));
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0x908e94));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		ImageIcon image = new ImageIcon("1_deliverabless/chess (3).png");
		this.setIconImage(image.getImage());
	}

}
