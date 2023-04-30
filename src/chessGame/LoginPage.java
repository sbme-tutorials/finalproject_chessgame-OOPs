package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JButton;

public class LoginPage implements ActionListener {
    Frame frame = new Frame();
    JButton loginButton = new JButton("login");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("THIS IS A TEXT");
    HashMap<String,String> logininfo = new HashMap<String,String>();
    
    LoginPage(HashMap<String,String> logininfoOriginal ){
        logininfo = logininfoOriginal ;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,24));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordField);
        frame.add(userIDField);
        frame.add(loginButton);
        
        frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }
        }
    }

}
