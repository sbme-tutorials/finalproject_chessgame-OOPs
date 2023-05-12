package chessGame;

import javax.swing.*;
import javax.swing.border.Border;

import Piece.Bishop;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import log_in.Choose;

import java.awt.*;

public class GameView extends JFrame{
	
	public static String score_1 = "0", score_2 = "0";     //score black army and white army respectively
	JLabel player1, player2;
	static JLabel score1;
	static JLabel score2;
	//================================Updated====================================

	static Counter timerw;
	static Counter timerb;
	{

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
        if(welcomePage.getUser()) {
        	if(Choose.getArmy()) {
	        	player2 = new JLabel(LoginPage.getName());
	        	player1 = new JLabel(Choose.getOppo());
	        }
        	else {
        		player1 = new JLabel(LoginPage.getName());
	        	player2 = new JLabel(Choose.getOppo());
        	}
        }
        else {
        	player1 = new JLabel("Player1");
        	player2 = new JLabel("Player2");
        }
        player1.setFont(new Font("Arial",Font.BOLD,20));
        player1.setForeground(new Color(0x57354b));
        player2.setFont(new Font("Arial",Font.BOLD,20));
        player2.setForeground(new Color(0x57354b));
        score1 = new JLabel("Score: "+score_1);                               //score of black army
        score1.setFont(new Font("Arial", Font.BOLD, 22));
        score1.setForeground(new Color(0x57354b));
        score2 = new JLabel("Score: "+score_2);                               //score of white army
        score2.setFont(new Font("Arial", Font.BOLD, 22));
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
        JPanel chessPanel = chessBoard1.getChessBoard_1();
        chessPanel.setBorder(BorderFactory.createLineBorder(new Color(0x57354b)));
        chessPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(15.0f)));
        chessPanel.setPreferredSize(new Dimension(520, 520));
        chessPanel.setBounds(250, 65, 500, 500);
        JPanel eatenPanel1 = ChessBoard.getChessBoard_2();
        eatenPanel1.setBounds(50, 65, 150, 500);
        eatenPanel1.setBorder(BorderFactory.createLineBorder(new Color(0x57354b)));
        eatenPanel1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(15.0f)));
        JPanel eatenPanel2 = ChessBoard.getChessBoard_3();
        eatenPanel2.setBounds(800, 65, 150, 500);
        eatenPanel2.setBorder(BorderFactory.createLineBorder(new Color(0x57354b)));
        eatenPanel2.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(15.0f)));
        frame.getContentPane().add(chessPanel);
        frame.getContentPane().add(eatenPanel1);
        frame.getContentPane().add(eatenPanel2);
        frame.setVisible(true);}


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
        public static void getScore(Piece buttonMovedTo) {                  //change score of 2 players
            if (buttonMovedTo.getColor()==Color.WHITE){
                if (buttonMovedTo instanceof Pawn){
                	score_1=String.valueOf(Integer.parseInt(score_1)+ 1);
                	score1.setText("Score: "+score_1);}
	         else if (buttonMovedTo instanceof Knight) {
	        	 score_1=String.valueOf(Integer.parseInt(score_1)+ 3);
	        	 score1.setText("Score: "+score_1);}
	         else if (buttonMovedTo instanceof Bishop) {
	        	 score_1=String.valueOf(Integer.parseInt(score_1)+ 3);
	        	 score1.setText("Score: "+score_1);}
	         else if (buttonMovedTo instanceof Rook) {
	        	 score_1=String.valueOf(Integer.parseInt(score_1)+ 5);
	        	 score1.setText("Score: "+score_1);}
	         else if (buttonMovedTo instanceof Queen) {
	        	 score_1=String.valueOf(Integer.parseInt(score_1)+ 9);
	        	 score1.setText("Score: "+score_1);}
                }
         else if (buttonMovedTo.getColor()==Color.BLACK) {
        	 if (buttonMovedTo instanceof Pawn){
        		 score_2=String.valueOf(Integer.parseInt(score_2)+ 1);
        		 score2.setText("Score: "+score_2);}
        	 else if (buttonMovedTo instanceof Knight) {
        		 score_2=String.valueOf(Integer.parseInt(score_2)+ 3);
        		 score2.setText("Score: "+score_2);}
             else if (buttonMovedTo instanceof Bishop) {
            	 score_2=String.valueOf(Integer.parseInt(score_2)+ 3);
            	 score2.setText("Score: "+score_2);}
             else if (buttonMovedTo instanceof Rook) {
            	 score_2=String.valueOf(Integer.parseInt(score_2)+ 5);
            	 score2.setText("Score: "+score_2);}
             else if (buttonMovedTo instanceof Queen) {
            	 score_2=String.valueOf(Integer.parseInt(score_2)+ 9);
            	 score2.setText("Score: "+score_2);}}
            } 
}





