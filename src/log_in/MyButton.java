package log_in;

import javax.swing.*;
import java.awt.*;


public class MyButton extends JButton {
    public MyButton(String label) {
        super(label);

        // Set the preferred size of the button to be a square with a width and height of 50 pixels
        setPreferredSize(new Dimension(100, 100));

        // Set the border of the button to be a rounded border with a gray color
        setBorder(BorderFactory.createLineBorder(getBackground(), 0));

        // Make the button transparent so that only the border is visible
        setOpaque(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw a white-filled oval that is slightly smaller than the size of the button
        g.setColor(getBackground());
        g.fillOval(1, 1, getWidth()-3, getHeight()-3);

        // Draw the label text on top of the oval
        super.paintComponent(g);

        // Draw the button border
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(4));
        g2.setColor(new Color(0x57354b));
        g2.drawOval(1, 1, getWidth()-3, getHeight()-3);
    }
}