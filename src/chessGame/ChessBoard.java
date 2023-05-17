package chessGame;

import Piece.*;
import log_in.Choose;
import log_in.Player;
import log_in.welcomePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static Piece.King.CanGetKingOutofCheck;
import static Piece.Pawn.promotion;
import static chessGame.Square.*;
public class ChessBoard
{
	public static String winner;
	public static boolean endgame = false;
	public static String status;
	public JPanel chessBoard;
	public static JPanel eatenPiecesWhite , eatenPiecesBlack;
    public static Square[][] tile = new Square[8][8];
    public static Square[][] tile_1 = new Square[8][2];        //tiles of white eaten pieces
    public static Square[][] tile_2 = new Square[8][2];        //tiles of black eaten pieces
    Piece p = null;
    Square fromButton = null, toButton = null;
    public static boolean isWhiteTurn = true;
    public static King blackKing = new King(Color.BLACK, 0, 4);
    public static King whiteKing = new King(Color.WHITE, 7, 4);


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
        eatenPiecesBlack.setOpaque(false);
        eatenPiecesWhite.setOpaque(false);
        // 16 tiles of class square which is extended from JPanel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                tile_1[i][j] = new Square(i, j, null);
                tile_2[i][j] = new Square( i, j, null);
                eatenPiecesBlack.add(tile_1[i][j]);
                eatenPiecesWhite.add(tile_2[i][j]);
               tile_1[i][j].setOpaque(false);
                tile_1[i][j].setContentAreaFilled(false);
                tile_2[i][j].setOpaque(false);
                tile_2[i][j].setContentAreaFilled(false);
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
                //===============================================   second click    ====================================//

                else {
                    //========================================    DESELECT   ===========================================//
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
                            boolean isMoveValid = fromButton.getPiece().isMoveValid(toButton.getMyX(), toButton.getMyY());
                            if (isMoveValid)
                            {
                                resetBackground();

                                //======================================== 
                                // check if the move is for promotion or not
                                if(Pawn.getPromotion()&&
                                        (fromButton.getMyX()==1&&fromButton.getColor()==Color.white
                                                ||fromButton.getMyX()==6&&fromButton.getColor()==Color.black)
                                        &&fromButton.getPiece() instanceof Pawn) {
                                    promotion(fromButton,toButton);
                                    Pawn.setPromotion(false);
                  	}
                                else
                                	movePiece(fromButton, toButton);

                                //========================================  end Game   ===================================//
                                
                                if ((whiteKing.IsinItCheck(tile) && !CanGetKingOutofCheck(whiteKing) )||GameView.timerw.getEnd()){
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
                                 if ((blackKing.IsinItCheck(tile) && !CanGetKingOutofCheck(blackKing))||GameView.timerb.getEnd()){
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
                                if (!whiteKing.IsinItCheck(tile) && !CanGetKingOutofCheck(whiteKing)){
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
                                if (!blackKing.IsinItCheck(tile) && !CanGetKingOutofCheck(blackKing)){
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
    //=====================================================================================================================//
    public void movePiece(Square fromButton, Square toButton) {
    	Piece takenPiece = toButton.getPiece();
        GameView.getScore(takenPiece); // passing tobutton old piece to calculate score
        if (fromButton.getColor() != toButton.getColor()) {
        	// get the piece from frombutton and setting it to tobutton
            toButton.setPiece(fromButton.getPiece());
            Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());  //generic null piece, this i equivalent to removing the piece from the
            //original square
            toButton.getPiece().setMoved(true);
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
                    tile[oldKingX][oldKingY + 2 * sign].getPiece().setMoved(true);
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
                        tile[oldKingX][oldKingY + 2 * sign].getPiece().setMoved(true);
                    }
                }
               else  isWhiteTurn = !isWhiteTurn;
            }

            }
        }
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
    public JPanel getChessBoard_1() {
        return chessBoard;
    }
    public static JPanel getChessBoard_2() {
        return eatenPiecesWhite;
    }
    public static JPanel getChessBoard_3() {
        return eatenPiecesBlack;
    }
    public static void setWinner(String winner) {
        ChessBoard.winner = winner;
    }
    public static boolean getEnd() {
    	return endgame;
    }
    public static String getWinner() {
    	return winner;
    }
}

