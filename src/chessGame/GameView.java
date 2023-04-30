package chessGame;

import java.awt.*;

import javax.swing.*;
public class GameView {
    public static void main(String[] args) {

            JTextField player1, player2, score1, score2;
            JLabel label1, label2, label3, label4, label5, label6, label7, label8, labela, labelb, labelc, labeld, labele, labelf, labelg, labelh;

            Frame frame = new Frame();
            new Counter();

            //Nouran's part
            Panel timer1 = new Panel();
            Panel timer2 = new Panel();
            Label label_1 = new Label();
            Label label_2 = new Label();
            label_1.setText("00:00");
            label_2.setText("00:00");
            frame.add(timer1);
            timer1.setBounds(470, 15, 80, 40);
            timer1.add(label_1);
            frame.add(timer2);
            timer2.setBounds(470, 590, 80, 40);
            timer2.add(label_2);

            //Aly's part
            player1 = new JTextField("   Player1", 10);
            player2 = new JTextField("   Player2", 10);
            score1 = new JTextField("             0", 2);
            score2 = new JTextField("             0", 2);
            label1 = new JLabel("1");
            label2 = new JLabel("2");
            label3 = new JLabel("3");
            label4 = new JLabel("4");
            label5 = new JLabel("5");
            label6 = new JLabel("6");
            label7 = new JLabel("7");
            label8 = new JLabel("8");
            labela = new JLabel("a");
            labelb = new JLabel("b");
            labelc = new JLabel("c");
            labeld = new JLabel("d");
            labele = new JLabel("e");
            labelf = new JLabel("f");
            labelg = new JLabel("g");
            labelh = new JLabel("h");
            frame.add(player1);
            player1.setBounds(50, 15, 100, 40);
            frame.add(player2);
            player2.setBounds(50, 590, 100, 40);
            frame.add(score1);
            score1.setBounds(200, 15, 100, 40);
            frame.add(score2);
            score2.setBounds(200, 590, 100, 40);
            frame.add(label1);
            frame.add(label2);
            frame.add(label3);
            frame.add(label4);
            frame.add(label5);
            frame.add(label6);
            frame.add(label7);
            frame.add(label8);
            frame.add(labela);
            frame.add(labelb);
            frame.add(labelc);
            frame.add(labeld);
            frame.add(labele);
            frame.add(labelf);
            frame.add(labelg);
            frame.add(labelh);
            label1.setBounds(35, 495, 80, 80);
            label2.setBounds(35, 430, 80, 80);
            label3.setBounds(35, 365, 80, 80);
            label4.setBounds(35, 300, 80, 80);
            label5.setBounds(35, 240, 80, 80);
            label6.setBounds(35, 175, 80, 80);
            label7.setBounds(35, 115, 80, 80);
            label8.setBounds(35, 55, 80, 80);
            labela.setBounds(80, 560, 30, 30);
            labelb.setBounds(140, 560, 30, 30);
            labelc.setBounds(205, 560, 30, 30);
            labeld.setBounds(270, 560, 30, 30);
            labele.setBounds(335, 560, 30, 30);
            labelf.setBounds(395, 560, 30, 30);
            labelg.setBounds(450, 560, 30, 30);
            labelh.setBounds(515, 560, 30, 30);


            //Mina's part
            ChessBoard chessBoard1 = new ChessBoard();
            JPanel chessPanel = chessBoard1.getChessBoard();
            chessPanel.setPreferredSize(new Dimension(500, 500));
            chessPanel.setBounds(50, 65, 500, 500);
            frame.getContentPane().add(chessPanel);


            frame.pack();
            frame.setVisible(true);
        }
    }




