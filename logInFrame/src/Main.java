
import javax.swing.JFrame;

import javax.swing.JLabel;
import java.util.HashMap;

import java.awt.*;

public class Main {
            public static void main(String[] args) {

                IDandPassword idandpassword = new IDandPassword();

                LoginPage loginpage  = new LoginPage(idandpassword.getLoginInfo());

                /*JFrame frame = new JFrame();
                JLabel label = new JLabel();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Chess Game");
                frame.setVisible(true);
                frame.setSize(500,500);
                frame.setResizable(false);
        // ImageIcon image = new ImageIcon("logo.png")      0x0149AF
        // frame.setIconImage(image.getImage()) (new Color(77,99,255))
        frame.getContentPane().setBackground(new Color(0x1EABAF));

                label.setText("Log In");
                frame.add(label);
                label.setHorizontalTextPosition(JLabel.LEFT);
                label.setVerticalTextPosition(JLabel.BOTTOM);
                label.setForeground(new Color(0x123456));
                label.setFont(new Font("MV Boli",Font.PLAIN,26)); */

            }
}