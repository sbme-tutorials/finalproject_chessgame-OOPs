package log_in;

import javax.swing.*;
import java.awt.*;

public class Choose extends Frame{
    public static void Lastframe(){

            JFrame frame = new JFrame();

            //label 1 pick a side !
            JLabel label1 = new JLabel("Please pick a side");
            label1.setFont(new Font("Arial", Font.PLAIN, 28));
            label1.setBounds(50, 0, 550, 100);

//button1 pick white
            JButton white = new JButton(new ImageIcon("1_deliverabless/Piece/chess (1).png"));
            white.setBounds(50, 100, 100, 100);
            white.setBackground(Color.WHITE);
           JLabel whiteText = new JLabel("white");
           whiteText.setBounds(80,210,100,25);

           //button 2 pick black

            JButton black = new JButton(new ImageIcon("1_deliverabless/Piece/chess.png"));
            black.setBounds(175, 100, 100, 100);
            black.setBackground(Color.WHITE);

            JLabel blackText = new JLabel("black");
            blackText.setBounds(200,210,100,25);


//setting a timer
            JLabel label2 = new JLabel("Please set a timer");
            label2.setFont(new Font("Arial", Font.PLAIN, 28));
            label2.setBounds(50, 300, 550, 100);

            MyButton min1 = new MyButton("01:00 min");
            min1.setBounds(50, 400, 100, 100);


            MyButton min3 = new MyButton("03:00 min");
            min3.setBounds(200, 400, 100, 100);


            MyButton min5 = new MyButton("05:00 min");
            min5.setBounds(350, 400, 100, 100);


            MyButton min10 = new MyButton("10:00 min");
            min10.setBounds(500, 400, 100, 100);


            MyButton min30 = new MyButton("30:00 min");
            min30.setBounds(650, 400, 100, 100);





//start game button
            JButton start = new JButton("Start Game");

            start.setBounds(250, 550, 200, 70);
            start.setBackground(new Color(0x544894));
            start.setForeground(Color.WHITE);
            start.setFont(new Font("Arial", Font.BOLD, 28));



            frame.add(label1);
            frame.add(whiteText);
            frame.add(blackText);
            frame.add(label2);
            frame.add(white);
            frame.add(black);
            frame.add(start);
            frame.add(min1);
            frame.add(min5);
            frame.add(min3);
            frame.add(min10);
            frame.add(min30);
            frame.setVisible(true);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setTitle("chessGame");
    		frame.setSize(690, 690);
    		frame.setLayout(null);
    		frame.getContentPane().setBackground(new Color(0xadadad));

    		ImageIcon image = new ImageIcon("logo.jpg");
    		frame.setIconImage(image.getImage());
    }
        public static void main(String[] args) {
            Lastframe();
        }
// flaging main for test purposes

    }



