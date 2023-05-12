package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
	
	static historyOrPlayNow profile;
	
	 static JTextField userIDField = new JTextField();

    Frame frame = new Frame();
    JButton loginButton = new JButton("Login");
   
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> logininfoOriginal) {
        logininfo = logininfoOriginal;

        userIDLabel.setBounds(150, 150, 150, 30);
        userIDLabel.setFont(new Font("Arial", Font.BOLD, 22));
        userIDLabel.setForeground(Color.WHITE);
        userPasswordLabel.setBounds(150, 260, 200, 30);
        userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));
        userPasswordLabel.setForeground(Color.WHITE);

        userIDField.setBounds(150, 190, 350, 30);
        userPasswordField.setBounds(150, 300, 350, 30);

        loginButton.setBounds(350, 370, 150, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBackground(new Color(0x57354b));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);


        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordField);
        frame.add(userIDField);
        frame.add(loginButton);
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
