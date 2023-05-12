package chessGame;
import Piece.*;
import log_in.Choose;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard {
	
	public static String winner;
	public static boolean endgame = false;
	public static String status;
	public JPanel chessBoard;
	public static JPanel eatenPiecesWhite;
	public static JPanel eatenPiecesBlack;
    public static Square[][] tile = new Square[8][8];
    public static Square[][] tile_1 = new Square[8][8];        //tiles of white eaten pieces
    public static Square[][] tile_2 = new Square[8][8];        //tiles of black eaten pieces
    Piece p = null;
    Square fromButton = null, toButton = null;
    private boolean isWhiteTurn = true;
    public static King blackKing = new King(Color.BLACK, 0, 4);
    public static King whiteKing = new King(Color.WHITE, 7, 4);
    public static Rook BlackRightRook =new Rook(Color.BLACK, 0, 7);
    public static Rook BlackLeftRook =new Rook(Color.BLACK, 0, 0);
    public static Rook WhiteRightRook =new Rook(Color.WHITE, 7, 7);
    public static Rook WhiteLeftRook =new Rook(Color.white, 7, 0);

    public ChessBoard() {
    	createEatenBoard();
        createBoard();
        resetBackground();
        showPieces();
    }
//==========================================================================================================================//
    private void createBoard() {
        // Create the chessboard panel with a GridLayout
        chessBoard = new JPanel(new GridLayout(8, 8));

        // 64 tiles of class square which is extended from JPanel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j] = new Square(i, j, p);
                addMouseListenerToSquare(tile[i][j]);
                chessBoard.add(tile[i][j]);
            }
        }
    }
    
    private void createEatenBoard() {
        // Create the chessboard panel with a GridLayout
        eatenPiecesWhite = new JPanel(new GridLayout(8, 2));
        eatenPiecesBlack = new JPanel(new GridLayout(8, 2));
        // 16 tiles of class square which is extended from JPanel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                tile_1[i][j] = new Square(i, j, null);
                tile_2[i][j] = new Square( i, j, null);
                eatenPiecesBlack.add(tile_1[i][j]).setBackground(new Color(0xecd5d0));
                eatenPiecesWhite.add(tile_2[i][j]).setBackground(new Color(0xecd5d0));
            }
        }
    }
//==============================================================================================================================//
    private void addMouseListenerToSquare(Square square) {
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Square clickedButton = (Square) e.getSource();
                if (fromButton == null)
                {
                    if ((isWhiteTurn && clickedButton.getPiece().getColor() == Color.WHITE) ||
                            (!isWhiteTurn && clickedButton.getPiece().getColor() == Color.BLACK))
                    {
                        // First click - set fromButton to the clicked button
                        fromButton = clickedButton;
                        fromButton.setBackground(Color.BLUE);
                        // set valid moves to green and valid moves where there are pieces from thr same army to red
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                ValidBackgrounds(i, j, fromButton.getPiece());
                            }
                        }

                    }
                }
                //=====================================================================================================================//
                //second click
                else {
                    //========================================    DESELECT   ====================================================//
                    if(clickedButton ==fromButton)
                    {
                        fromButton=null;
                        // resets the color of the background
                            resetBackground();
                            Pawn.setPromotion(false);
                    }
                    //=============================================   MOVE    ======================================================//
                    // Second click - set toButton to the clicked button and do something with the move
                   else if (clickedButton.getColor() != fromButton.getColor()) {
                        if ((isWhiteTurn && fromButton.getColor() == Color.WHITE) ||
                                (!isWhiteTurn && fromButton.getColor() == Color.BLACK)) {
                            //==========================================
                            toButton = clickedButton;
                            //==========================================
                            boolean isItValid = fromButton.getPiece().isMoveValid(toButton.getMyX(), toButton.getMyY());
                            if (isItValid)
                            {
                                resetBackground();

                                //======================================== 
                                // check if the move is for promotion or not
                                if(Pawn.getPromotion()&&(fromButton.getMyX()==1||fromButton.getMyX()==6)) {
                                	promotion(fromButton,toButton);
                                	Pawn.setPromotion(false);
                                	}
//                                else if(Pawn.getPassent()) {
//                                	enPassent(fromButton,toButton);
//                                	Pawn.setPassent(false);
//                                }
                                else
                                	movePiece(fromButton, toButton);

                                //========================================  end Game   ===================================//
                                
                                if (whiteKing.IsinItCheck(tile) && !King.CanGetKingOutofCheck(whiteKing)||GameView.timerw.getEnd()){
                                    //System.out.println("GAME OVER BLACK WINS");
                                    disableAllSquares();
                                    GameView.timerb.stop();
                                    endgame = true;
                                    winner = "black";
                                    new endgame();
                                    if(welcomePage.getUser()){
                                    status = Choose.getOppo()+","+Choose.getColor()+","+"Black"+","+Counter.getTime();
                                    Player.WriteToFile(status);}
                                    }
                                if (blackKing.IsinItCheck(tile) && !King.CanGetKingOutofCheck(blackKing)||GameView.timerb.getEnd()){
                                    //System.out.println("GAME OVER White WINS");
                                    GameView.timerw.stop();
                                    disableAllSquares();
                                    endgame = true;
                                    winner = "white";
                                    new endgame();
                                    if(welcomePage.getUser()) {
                                    status = Choose.getOppo()+","+Choose.getColor()+","+"White"+","+Counter.getTime();
                                    Player.WriteToFile(status);}
                                }
                                if (!whiteKing.IsinItCheck(tile) && !King.CanGetKingOutofCheck(whiteKing)){
                                    //System.out.println("GAME OVER STALEMATE");
	                                disableAllSquares();
	                                GameView.timerw.stop();
	                                GameView.timerb.stop();
	                                endgame = true;
	                                winner = "draw";
	                                new endgame();
	                                if(welcomePage.getUser()) {
	                                status = Choose.getOppo()+","+Choose.getColor()+","+"Draw"+","+Counter.getTime();
	                                Player.WriteToFile(status);}
                                }
                                if (!blackKing.IsinItCheck(tile) && !King.CanGetKingOutofCheck(blackKing)){
                                    //System.out.println("GAME OVER STALEMATE");
	                                disableAllSquares();
	                                GameView.timerw.stop();
	                                GameView.timerb.stop();
	                                endgame = true;
	                                winner = "draw";
	                                new endgame();
	                                if(welcomePage.getUser()) {
	                                status = Choose.getOppo()+","+Choose.getColor()+","+"Draw"+","+Counter.getTime();
	                                Player.WriteToFile(status);}
                                }
                                if (Stalemate()){
                                    //System.out.println("GAME OVER STALEMATE");
                                    disableAllSquares();
                                    GameView.timerw.stop();
                                    GameView.timerb.stop();
                                    endgame = true;
                                    winner = "draw";
                                    new endgame();
                                    if(welcomePage.getUser()) {
                                    status = Choose.getOppo()+","+Choose.getColor()+","+"Draw"+","+Counter.getTime();
                                    Player.WriteToFile(status);}
                                }
                                //=========================================
                                // Switch turns after a successful move
                                isWhiteTurn = !isWhiteTurn;
                                fromButton = null;
                                //=========================Updated===========================
                                //stopping counter
                                if(!endgame) {
                                if(isWhiteTurn) { 
                                	GameView.timerw.start();
                                	GameView.timerb.stop();
                                }
                                else {
                                	GameView.timerw.stop();
                                	GameView.timerb.start();
                                }}
                                //============================================================
                            }
                        }
                    }

                   else if (clickedButton.getColor() == fromButton.getColor()){
                        if ((isWhiteTurn && fromButton.getColor() == Color.WHITE) ||
                                (!isWhiteTurn && fromButton.getColor() == Color.BLACK)) {
                            //==========================================
                            toButton = clickedButton;
                            //==========================================
                            if (fromButton.getPiece().canCastle(toButton.getMyX(), toButton.getMyY())) {
                                Castling(fromButton.getPiece(), toButton.getPiece());
                                resetBackground();
                                // Switch turns after a successful move
                                isWhiteTurn = !isWhiteTurn;
                                fromButton = null;
                            }
                        }
                    }

                }
            }
        });
    }
    
   
    
    void showPieces() {
        // Black Pieces

        tile[0][0].setPiece(BlackLeftRook);
        tile[0][1].setPiece(new Knight(Color.BLACK, 0, 1));
        tile[0][2].setPiece(new Bishop(Color.BLACK, 0, 2));
        tile[0][3].setPiece(new Queen(Color.BLACK, 0, 3));
        tile[0][4].setPiece(blackKing);
        tile[0][5].setPiece(new Bishop(Color.BLACK, 0, 5));
        tile[0][6].setPiece(new Knight(Color.BLACK, 0, 6));
        tile[0][7].setPiece(BlackRightRook);
        for (int j = 0; j < 8; j++) {
            tile[1][j].setPiece(new Pawn(Color.BLACK, 1, j));
        }

        // White Pieces
        tile[7][0].setPiece(WhiteLeftRook);
        tile[7][1].setPiece(new Knight(Color.WHITE, 7, 1));
        tile[7][2].setPiece(new Bishop(Color.WHITE, 7, 2));
        tile[7][3].setPiece(new Queen(Color.WHITE, 7, 3));
        tile[7][4].setPiece(whiteKing);
        tile[7][5].setPiece(new Bishop(Color.WHITE, 7, 5));
        tile[7][6].setPiece(new Knight(Color.WHITE, 7, 6));
        tile[7][7].setPiece(WhiteRightRook);
        for (int j = 0; j < 8; j++) {
            tile[6][j].setPiece(new Pawn(Color.WHITE, 6, j));
        }

        // Set other squares to no Piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setPiece(new Null(null, i, j));
            }
        }
    }

    //=====================================================================================================================//
    public void movePiece(Square fromButton, Square toButton) {
    	Piece takenPiece = toButton.getPiece();
        GameView.getScore(takenPiece); // passing tobutton old piece to calculate score
        if (fromButton.getColor() != toButton.getColor()) {
        	// get the piece from frombutton and setting it to tobutton
            toButton.setPiece(fromButton.getPiece());
            Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());  //generic null piece, this i equivalent to removing the piece from the
            //original square
            fromButton.setPiece(noPiece);
            if (takenPiece.getColor()==Color.white) {
            	rowsLoop: for (int i = 0; i < 8; i++) {  //displaying eaten pieces
            		for (int j = 0; j < 2; j++) {
            			if (tile_1[i][j].getPiece() == null){
            				tile_1[i][j].setPiece(takenPiece);
            				break rowsLoop;
            			}
            		}
            	}
            }
            else if (takenPiece.getColor()==Color.black) {
            	rowsLoop: for (int i = 0; i < 8; i++) {
	            	for (int j = 0; j < 2; j++) {
	            		if (tile_2[i][j].getPiece() == null){
		            		tile_2[i][j].setPiece(takenPiece);
		            		break rowsLoop;
		            	}
	            	}
            	}
            }
         }
      }

    public void Castling (Piece king , Piece rook) {
        if (king.getisMoved() == false && rook.getisMoved() == false) {


            // in casteling they re on the same horizontal level , they have same x
            int oldKingX = king.getX();
            int oldKingY = king.getY();
            int oldRookX = rook.getX();
            int oldRookY = rook.getY();
            int sign = Integer.signum(rook.getY() - king.getY());
            if (Math.abs(oldKingY - oldRookY) == 3)
            {
                if (!king.doesNewMovePutInCheck(oldKingX,oldKingY + 2 * sign) )
                {
                    tile[oldKingX][oldKingY + 2 * sign].setPiece(king);
                    tile[oldKingX][oldKingY].setPiece(new Null(null, oldKingX, oldKingY));
                    tile[oldRookX][oldRookY - 2 * sign].setPiece(rook);
                    tile[oldRookX][oldRookY].setPiece(new Null(null, oldRookX, oldRookY));
                }
                 else isWhiteTurn = !isWhiteTurn;
            }
            else if((Math.abs(oldKingY - oldRookY) == 4)) {
                if (!king.doesNewMovePutInCheck(oldKingX, oldKingY + 2 * sign)) {
                    {
                        tile[oldKingX][oldKingY + 2 * sign].setPiece(king);
                        tile[oldKingX][oldKingY].setPiece(new Null(null, oldKingX, oldKingY));
                        tile[oldRookX][oldRookY - 3 * sign].setPiece(rook);
                        tile[oldRookX][oldRookY].setPiece(new Null(null, oldRookX, oldRookY));
                    }
                }
               else  isWhiteTurn = !isWhiteTurn;
            }

            }
        }


    //=======================================     Color      =================================================================//
    public void resetBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    tile[i][j].setBackground(new java.awt.Color(0x57354b));
                } else {
                    tile[i][j].setBackground(new java.awt.Color(0xedc3bb));

                }
            }

        }   
     }

    void ValidBackgrounds(int i, int j, Piece orginalPiece) {
       if (orginalPiece.isMoveValid(i, j)){
            if (fromButton.getColor() != tile[i][j].getColor()) {
                tile[i][j].setBackground(Color.green);
                tile[i][j].repaint();
            }
            else{
                tile[i][j].setBackground(Color.red);
                tile[i][j].repaint();
            }

            }

    }
    //======================================================================================================================//
    private void disableAllSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setEnabled(false);
            }
        }
    }

    //=================================================================//
//    public boolean CanGetKingOutofCheck(King king) {
//        // Get the army color of the king
//        Color armyColor = king.getColor();
//
//        // Simulate all possible moves of the army's pieces
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Piece piece = tile[i][j].getPiece();
//                if (piece.getColor() == armyColor) {
//                    // Check if the piece can move to get the king out of check
//                    for (int x = 0; x < 8; x++) {
//                        for (int y = 0; y < 8; y++) { 
//                            if (piece.isMoveValid(x, y)) {
//                                // Try the move
//                                int pieceOldX = piece.getX();
//                                int pieceOldY = piece.getY();
//                                Color pieceOldColor = piece.getColor();
//                                Color my_color = tile[x][y].getColor();
//                                piece.setX(x);
//                                piece.setY(y);
//                                piece.setColor(null);
//                                tile[x][y].getPiece().setColor(pieceOldColor);
//
//                                // Check if the king is out of check
//                                if (!king.IsinItCheck(tile)) {
//                                    // Reset the piece's position and return true
//                                    piece.setX(pieceOldX);
//                                    piece.setY(pieceOldY);
//                                    piece.setColor(pieceOldColor);
//                                    tile[x][y].getPiece().setColor(my_color);
//                                    return true;
//                                }
//
//                                // Reset the piece's position
//                                piece.setX(pieceOldX);
//                                piece.setY(pieceOldY);
//                                piece.setColor(pieceOldColor);
//                                tile[x][y].getPiece().setColor(my_color);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
    
    //========================================================================//
    public boolean Stalemate() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(tile[i][j].getPiece() instanceof  Null)){
                    sum ++;
                }
            }
        }
        if (sum == 2)
            return true;
        if (sum ==3 )
        {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tile[i][j].getPiece() instanceof Bishop
                            || tile[i][j].getPiece() instanceof Knight) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    
    //==============================================Promotion===========================================================//
    private void promotion(Square fromButton, Square toButton) {
    	ImageIcon logo = new ImageIcon("chessGame/1_deliverabless/Pro.PNG");
    	Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());
        Object[] options = {"Queen", "Rook", "Bishop", "Knight"};
        int choice = JOptionPane.showOptionDialog(
            null, "Congratulations, You are promoted!", "Promotion",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, logo,
            options, options[3]);
        if(fromButton.getMyX()==6)
        switch (choice) {
            case 0:
                toButton.setPiece(new Queen(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 1:
            	toButton.setPiece(new Rook(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 2:
            	toButton.setPiece(new Bishop(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 3:
            	toButton.setPiece(new Knight(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            default:
            	isWhiteTurn = !isWhiteTurn;
            	break;
        	}
        else if(fromButton.getMyX()==1)
        	switch (choice) {
            case 0:
                toButton.setPiece(new Queen(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 1:
            	toButton.setPiece(new Rook(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 2:
            	toButton.setPiece(new Bishop(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            case 3:
            	toButton.setPiece(new Knight(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                fromButton.setPiece(noPiece);
                break;
            default:
            	isWhiteTurn = !isWhiteTurn;
            	break;
        	}
    }
    //============================================= en passent ====================================================================
    private void enPassent(Square fromButton, Square toButton) {
    	int dx = Integer.signum(toButton.getMyX()-fromButton.getMyX());
    	int dy = Integer.signum(toButton.getMyY()-fromButton.getMyY());
    	Null noPiece = new Null(null, fromButton.getMyX(), fromButton.getMyY());
    	toButton.setPiece(fromButton.getPiece());
    	fromButton.setPiece(noPiece);
    	tile[fromButton.getMyX()][fromButton.getMyY()+dy].setPiece(new Null(null, fromButton.getMyX()+dx, fromButton.getMyY()+dy));
    	
    }
    
    public JPanel getChessBoard_1() {
        return chessBoard;
    }
    public static JPanel getChessBoard_2() {
        return eatenPiecesWhite;
    }
    public static JPanel getChessBoard_3() {
        return eatenPiecesBlack;
    }
    public static boolean getEnd() {
    	return endgame;
    }
    public static String getWinner() {
    	return winner;
    }
}

