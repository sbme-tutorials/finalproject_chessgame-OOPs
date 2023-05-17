package log_in;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
	
	static historyOrPlayNow profile;
	
	 static RoundedTextField userIDField = new RoundedTextField(20);

    JFrame frame = new JFrame();
    RoundBorderButton loginButton = new RoundBorderButton("Login");
   
    RoundedPasswordField userPasswordField = new RoundedPasswordField(20);
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap<String, String>();

    public LoginPage(HashMap<String, String> logininfoOriginal) {
        frame.setSize(500,668);
        ImageIcon image = new ImageIcon("1_deliverabless/logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setLocationRelativeTo(null);
        logininfo = logininfoOriginal;

        userIDLabel.setBounds(65, 150, 150, 30);
        userIDLabel.setFont(new Font("Arial", Font.BOLD, 22));
        userIDLabel.setForeground((new Color(0x6d1e00)));
        userPasswordLabel.setBounds(65, 260, 200, 30);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));
        userPasswordLabel.setForeground(new Color(0x6d1e00));

        userIDField.setBounds(50, 190, 350, 30);
        userPasswordField.setBounds(50, 300, 350, 30);

        loginButton.setBounds(160, 370, 150, 40);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        ImageIcon icon = new ImageIcon("1_deliverabless/KingInverted.png");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0,1060, 668);



        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordField);
        frame.add(userIDField);
        frame.add(loginButton);
        frame.add(imageLabel) ;
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    frame.dispose();
                    profile = new historyOrPlayNow();
                } else {
                    messageLabel.setBounds(390, 280, 110, 15);
                    messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                    messageLabel.setForeground(new Color(0xd10404));
                    messageLabel.setText("*wrong password");
                }
            } else {
                messageLabel.setBounds(370, 170, 130, 15);
                messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                messageLabel.setForeground(new Color(0xd10404));
                messageLabel.setText("*username not found");
            }
        }
    }
    public static String getName() {
        return userIDField.getText();
    }

}
