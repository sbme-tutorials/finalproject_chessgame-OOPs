package chessGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frame extends JFrame {
	int width = 690;
	int height = 690;
	Frame(){
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ChessGame");
		this.setSize(new Dimension(width, height));
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0x908e94));
		this.setLocation(width/2-this.getSize().width/2,0);
		
		ImageIcon image = new ImageIcon("logo.jpg");
		this.setIconImage(image.getImage());
		
		/*
		 * BufferedImage myImage = ImageIO.read(new File("back.jpg"));
		 * this.setContentPane(new ImagePanel(myImage));
		 */
	}

}

/*
 * class ImagePanel extends JComponent { private Image image; public
 * ImagePanel(Image image) { this.image = image; }
 * 
 * @Override protected void paintComponent(Graphics g) {
 * super.paintComponent(g); g.drawImage(image, 0, 0, this); } }
 */