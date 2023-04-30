package chessGame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
public class GameView {
    public void main(String[] args) {

            JTextField player1, player2, score1, score2;
            JLabel label_1, label_2, label3, label4, label5, label6, label7, label8, labela, labelb, labelc, labeld, labele, labelf, labelg, labelh;

            Frame frame = new Frame();
            new Counter();

            //Nouran's part
            Panel timer1 = new Panel();
            Panel timer2 = new Panel();
            JLabel label1 = new JLabel();
            JLabel label2 = new JLabel();
            label1.setText("00:00");
            label2.setText("00:00");
            label1.setFont(new Font("Monospaced", Font.PLAIN, 22));
            label1.setForeground(Color.WHITE);
            label2.setFont(new Font("Monospaced", Font.PLAIN, 22));
            label2.setForeground(Color.WHITE);
            frame.add(timer1);
            timer1.setBounds(450, 20, 100, 50);

            timer1.add(label1);
            frame.add(timer2);
            timer2.setBounds(450, 635, 100, 50);
            timer2.add(label2);


            //Aly's part
            player1 = new JTextField("   Player1", 10);
            player1.setBorder(new RoundBorder(15));
            player2 = new JTextField("   Player2", 10);
            player2.setBorder(new RoundBorder(15));
            score1 = new JTextField("             0", 2);
            score1.setBorder(new RoundBorder(15));
            score2 = new JTextField("             0", 2);
            score2.setBorder(new RoundBorder(15));
            label_1 = new JLabel("1");
            label_2 = new JLabel("2");
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
            player1.setBounds(50, 20, 100, 50);
            frame.add(player2);
            player2.setBounds(50, 635, 100, 50);
            frame.add(score1);
            score1.setBounds(200, 20, 100, 50);
            frame.add(score2);
            score2.setBounds(200, 635, 100, 50);
            frame.add(label_1);
            frame.add(label_2);
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
            label_1.setBounds(30, 530, 80, 80);
            label_2.setBounds(30, 465, 80, 80);
            label3.setBounds(30, 400, 80, 80);
            label4.setBounds(30, 335, 80, 80);
            label5.setBounds(30, 275, 80, 80);
            label6.setBounds(30, 210, 80, 80);
            label7.setBounds(30, 150, 80, 80);
            label8.setBounds(30, 85, 80, 80);
            labela.setBounds(80, 600, 30, 30);
            labelb.setBounds(140, 600, 30, 30);
            labelc.setBounds(205, 600, 30, 30);
            labeld.setBounds(260, 600, 30, 30);
            labele.setBounds(325, 600, 30, 30);
            labelf.setBounds(385, 600, 30, 30);
            labelg.setBounds(450, 600, 30, 30);
            labelh.setBounds(515, 600, 30, 30);


            //Mina's part
            ChessBoard chessBoard1 = new ChessBoard();
            JPanel chessPanel = chessBoard1.getChessBoard();
            chessPanel.setPreferredSize(new Dimension(500, 500));
            chessPanel.setBounds(50, 100, 500, 500);
            frame.getContentPane().add(chessPanel);


            frame.pack();
            frame.setVisible(true);
        }






        //this is a function for just the graphical interface
        class RoundBorder implements Border {

                private int radius;

                public RoundBorder(int radius) {
                        this.radius = radius;
                }

                @Override
                public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                        g.setColor(Color.BLACK);
                        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
                }

                @Override
                public Insets getBorderInsets(Component c) {
                        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
                }

                @Override
                public boolean isBorderOpaque() {
                        return true;
                }
    }}




