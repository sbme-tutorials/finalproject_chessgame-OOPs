package chessGame;

import Piece.*;
import log_in.Choose;
import log_in.LoginPage;
import log_in.welcomePage;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame
{
	public static String score_1 = "0", score_2 = "0"; //score black army and white army respectively
	JLabel player1, player2;
	static JLabel score1,score2;
	static Counter timerw , timerb;
    public  Frame frame = new Frame();

    {

    	Panel panelW = new Panel();
    	Panel panelB = new Panel();
    	
    	panelW.setBounds(270, 580, 460, 40);
        panelB.setBounds(270, 15, 460, 40);
    	

        
        timerw = new Counter(Choose.getTimer());
        timerb = new Counter(Choose.getTimer());
        
        panelW.add(timerw.label);
        panelB.add(timerb.label);

        JLabel clock = new JLabel(new ImageIcon("1_deliverabless/timer.png"));
        clock.setBounds(400 ,580 ,40 , 40);
        panelW.add(clock);
        JLabel clock1 = new JLabel(new ImageIcon("1_deliverabless/timer.png"));
        clock.setBounds(400 ,15 ,40 , 40);
        panelB.add(clock1);

        //=========================================================  get Player name    ================================================//
        if(welcomePage.getUser())
        {
        	if(Choose.getArmy())
            {
	        	player2 = new JLabel(LoginPage.getName());
	        	player1 = new JLabel(Choose.getOppo());
	        }
        	else
            {
        		player1 = new JLabel(LoginPage.getName());
	        	player2 = new JLabel(Choose.getOppo());
        	}
        }
        else
        {
        	player1 = new JLabel("Player1");
        	player2 = new JLabel("Player2");
        }
        //==========================================================================================================================//
        // black
        player1.setFont(new Font("Arial",Font.BOLD,20));
        player1.setForeground(Color.WHITE);
        player1.setBounds(320, 15, 100, 40);

        score1 = new JLabel("Score: "+score_1);                               //score of black army
        score1.setFont(new Font("Arial", Font.BOLD, 22));
        score1.setBounds(610, 15, 100, 40);
        score1.setForeground(Color.WHITE);

        // white
        player2.setFont(new Font("Arial",Font.BOLD,20));
        player2.setForeground(Color.WHITE);
        player2.setBounds(320, 580, 100, 40);

        score2 = new JLabel("Score: "+score_2);                               //score of white army
        score2.setFont(new Font("Arial", Font.BOLD, 22));
        score2.setBounds(610, 580, 100, 40);
        score2.setForeground(Color.WHITE);


        frame.add(player1);
        frame.add(player2);
        frame.add(score1);
        frame.add(score2);

        // Create labels for the chess board
        Label[] labels = new Label[16];
        for (int i = 0; i < 8; i++) {
            labels[i] = new Label(String.valueOf(i + 1));
            labels[i].setBounds(255, (8 - i) * 65 - 10, 80, 80);
        }
        labels[8] = new Label("a");
        labels[9] = new Label("b");
        labels[10] = new Label("c");
        labels[11] = new Label("d");
        labels[12] = new Label("e");
        labels[13] = new Label("f");
        labels[14] = new Label("g");
        labels[15] = new Label("h");
        for (int i = 8; i < 16; i++) {
            labels[i].setBounds(290 + (i - 8) * 60, 542, 30, 30);
        }
        for (Label label : labels) {
            frame.add(label);
        }
        frame.add(panelB);
        frame.add(panelW);


        ImageIcon icon = new ImageIcon("1_deliverabless/Pieces.png");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0,1060, 668);


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
        frame.add(imageLabel);
        frame.setVisible(true);

    }


        public static void getScore(Piece buttonMovedTo) {            //change score of 2 players
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

    public static void setScore_1(String score_1) {
        GameView.score_1 = score_1;
    }

    public static void setScore_2(String score_2) {
        GameView.score_2 = score_2;
    }



}





