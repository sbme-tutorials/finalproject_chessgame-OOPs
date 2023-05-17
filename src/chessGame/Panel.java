package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Panel extends JPanel {
	private int radius = 30; // the radius of the corners

	public Panel() {
		this.setBackground(new Color(0x43041a));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Create a RoundRectangle2D object with the desired radius
		Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);

		// Get the current graphics context
		Graphics2D g2 = (Graphics2D) g;

		// Save the current clip
		Shape clip = g2.getClip();

		// Set the clip to the rounded rectangle
		g2.setClip(shape);

		// Paint the panel background
		super.paintComponent(g);

		// Restore the clip
		g2.setClip(clip);

		// Paint the rounded border
		g2.setColor(Color.WHITE);
		g2.draw(shape);
	}
}

class Label extends JLabel {
	Label(String text) {
		this.setFont(new Font("Arial", Font.BOLD, 10));
		this.setForeground(Color.white);
		this.setBackground(new Color(0x1b790c));
		this.setText(text);
	}
}
