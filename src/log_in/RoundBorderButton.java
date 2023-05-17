package log_in;

import javax.swing.*;
import java.awt.*;

public class RoundBorderButton extends JButton {

    private int radius = 30;

    public RoundBorderButton(String text) {
        super(text);
        setPreferredSize(new Dimension(100, 40));
        setBackground(new Color(0x6d1e00));
        setForeground(Color.WHITE);
        setFont(new Font("Arial",Font.BOLD,20));
        setContentAreaFilled(false);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
