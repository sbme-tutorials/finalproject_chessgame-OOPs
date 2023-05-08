package chessGame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import log_in.Choose;
public class GameView {
	//================================Updated====================================
	static Counter timerw;
	static Counter timerb;
	{
    	JLabel player1, player2, score1, score2;
    	Label label1, label2, label3, label4, label5, label6, label7, label8, labela, labelb, labelc, labeld, labele, labelf, labelg, labelh;

    	Panel panelW = new Panel();
    	Panel panelB = new Panel();
    	
    	panelW.setBounds(470, 580, 80, 40);
        panelB.setBounds(470, 15, 80, 40);
    	
        Frame frame = new Frame();
        frame.add(panelB);
        frame.add(panelW);
        
        timerw = new Counter(Choose.getTimer());
        timerb = new Counter(Choose.getTimer());
        
        panelW.add(timerw.label);
        panelB.add(timerb.label);
        //=========================================================================

        //Aly's part
        player1 = new JLabel("Player1");
        player1.setFont(new Font("Arial",Font.BOLD,22));
        player1.setForeground(new Color(0x57354b));
        player2 = new JLabel("Player2");
        player2.setFont(new Font("Arial",Font.BOLD,22));
        player2.setForeground(new Color(0x57354b));
        score1 = new JLabel("0");
        score1.setFont(new Font("Arial",Font.BOLD,18));
        score1.setForeground(new Color(0x57354b));
        score2 = new JLabel("0");
        score2.setFont(new Font("Arial",Font.BOLD,18));
        score2.setForeground(new Color(0x57354b));
        label1 = new Label("1");
        label2 = new Label("2");
        label3 = new Label("3");
        label4 = new Label("4");
        label5 = new Label("5");
        label6 = new Label("6");
        label7 = new Label("7");
        label8 = new Label("8");
        labela = new Label("a");
        labelb = new Label("b");
        labelc = new Label("c");
        labeld = new Label("d");
        labele = new Label("e");
        labelf = new Label("f");
        labelg = new Label("g");
        labelh = new Label("h");
        frame.add(player1);
        player1.setBounds(50, 15, 100, 40);
        frame.add(player2);
        player2.setBounds(50, 580, 100, 40);
        frame.add(score1);
        score1.setBounds(200, 15, 100, 40);
        frame.add(score2);
        score2.setBounds(200, 580, 100, 40);
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
        label1.setBounds(55, 495, 80, 80);
        label2.setBounds(55, 430, 80, 80);
        label3.setBounds(55, 365, 80, 80);
        label4.setBounds(55, 300, 80, 80);
        label5.setBounds(55, 240, 80, 80);
        label6.setBounds(55, 175, 80, 80);
        label7.setBounds(55, 115, 80, 80);
        label8.setBounds(55, 55, 80, 80);
        labela.setBounds(93, 542, 30, 30);
        labelb.setBounds(150, 542, 30, 30);
        labelc.setBounds(210, 542, 30, 30);
        labeld.setBounds(270, 542, 30, 30);
        labele.setBounds(330, 542, 30, 30);
        labelf.setBounds(389, 542, 30, 30);
        labelg.setBounds(445, 542, 30, 30);
        labelh.setBounds(503, 542, 30, 30);
        
        
        //Mina's part
        ChessBoard chessBoard1 = new ChessBoard();
        JPanel chessPanel = chessBoard1.getChessBoard();
        chessPanel.setBorder(BorderFactory.createLineBorder(new Color(0x57354b)));
        chessPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(15.0f)));
        chessPanel.setPreferredSize(new Dimension(520, 520));
        chessPanel.setBounds(50, 65, 500, 500);
        frame.getContentPane().add(chessPanel);
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
      }
}




