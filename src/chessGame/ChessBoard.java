package chessGame;
import Piece.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard {
    public static JPanel chessBoard;
    public static Square[][] tile = new Square[8][8];

    Piece p = null;
    Square fromButton = null, toButton = null;
    private boolean isWhiteTurn = true;
    King blackKing = new King(Color.BLACK, 0, 4);
    King whiteKing = new King(Color.WHITE, 7, 4);


    public ChessBoard() {
        createBoard();
        showPieces();
    }

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

    private void addMouseListenerToSquare(Square square) {
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Square clickedButton = (Square) e.getSource();
                if (fromButton == null) {
                    if ((isWhiteTurn && clickedButton.getPiece().getColor() == Color.WHITE) ||
                            (!isWhiteTurn && clickedButton.getPiece().getColor() == Color.BLACK)) {
                        // First click - set fromButton to the clicked button
                        fromButton = clickedButton;
                        ///////////////////////////////////////////
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                ValidBackgrounds(i, j, fromButton.getPiece());//sets the background of the valid move options to be green
                            }
                        }
                        ////////////////////////////////////////////
                    }
                } else {
                    if(clickedButton ==fromButton)//deselect
                    {
                        fromButton=null;
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    tile[i][j].resetBackground();//resets the color of the background
                                }
                            }

                    }
                    // Second click - set toButton to the clicked button and do something with the move
                   else if (clickedButton.getColor() != fromButton.getColor()) { // avoid same team
                        if ((isWhiteTurn && fromButton.getColor() == Color.WHITE) ||
                                (!isWhiteTurn && fromButton.getColor() == Color.BLACK)) {
                            //==========================================
                            toButton = clickedButton;
                            //==========================================
                            boolean isItValid = fromButton.getPiece().isValidMove(toButton.getMyX(), toButton.getMyY());
                            if (isItValid)
                            {
                                for (int i = 0; i < 8; i++)
                                {
                                    for (int j = 0; j < 8; j++)
                                    {
                                        tile[i][j].resetBackground();//resets the color of the background after the move is done
                                    }
                                }
                                //========================================
                                movePiece(fromButton, toButton);
                                //========================================fi moshkela hena
                                if (whiteKing.IsinItCheck(tile) && !whiteKing.CanGetOutofCheck(whiteKing))
                                    System.out.println("GAME OVER BLACK WINS");
                                if (blackKing.IsinItCheck(tile) && !blackKing.CanGetOutofCheck(blackKing))
                                    System.out.println("GAME OVER White WINS");
                                //=========================================
                                // Switch turns after a successful move
                                isWhiteTurn = !isWhiteTurn;
                                fromButton = null;
                                //=========================Updated===========================
                                //stopping counter
                                if(isWhiteTurn) { 
                                	GameView.timerw.start();
                                	GameView.timerb.stop();
                                	//System.out.println("white turn.");
                                }
                                else {
                                	GameView.timerw.stop();
                                	GameView.timerb.start();
                                	//System.out.println("black turn.");
                                }
                                //============================================================
                            }
                        }
                    }
                }
            }
        });
    }
    
   
    
    void showPieces() {
        // Black Pieces
        tile[0][0].setPiece(new Rook(Color.BLACK, 0, 0));
        tile[0][1].setPiece(new Knight(Color.BLACK, 0, 1));
        tile[0][2].setPiece(new Bishop(Color.BLACK, 0, 2));
        tile[0][3].setPiece(new Queen(Color.BLACK, 0, 3));
        tile[0][4].setPiece(blackKing);
        tile[0][5].setPiece(new Bishop(Color.BLACK, 0, 5));
        tile[0][6].setPiece(new Knight(Color.BLACK, 0, 6));
        tile[0][7].setPiece(new Rook(Color.BLACK, 0, 7));
        for (int j = 0; j < 8; j++) {
            tile[1][j].setPiece(new Pawn(Color.BLACK, 1, j));
        }

        // White Pieces
        tile[7][0].setPiece(new Rook(Color.WHITE, 7, 0));
        tile[7][1].setPiece(new Knight(Color.WHITE, 7, 1));
        tile[7][2].setPiece(new Bishop(Color.WHITE, 7, 2));
        tile[7][3].setPiece(new Queen(Color.WHITE, 7, 3));
        tile[7][4].setPiece(whiteKing);
        tile[7][5].setPiece(new Bishop(Color.WHITE, 7, 5));
        tile[7][6].setPiece(new Knight(Color.WHITE, 7, 6));
        tile[7][7].setPiece(new Rook(Color.WHITE, 7, 7));
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

//    =====================================================================================================================
   	public void movePiece(Square fromButton, Square toButton) {
   	 Null noPiece = new Null(null,fromButton.getX(), fromButton.getY()); //generic null piece, this i equivalent to remove
   	 //original square the piece from the
//King.getCastling()&&fromButton.getPiece().gettype()==Piece.type.King
		if(fromButton.getPiece().gettype()==Piece.type.King&&toButton.getPiece().gettype()==Piece.type.Rook) {
			System.out.println("callig castling function");
			castling(fromButton, toButton);
			System.out.println("castling");
		}
		else {
			if (fromButton.getColor() != toButton.getColor()) { // get the piece from frombutton and setting it to tobutton
				toButton.setPiece(fromButton.getPiece()); 
				fromButton.setPiece(noPiece);
				System.out.println("normal");
			}
		}
   	}
   	
	private void castling(Square fromButton, Square toButton) {
		Null noPieceFrom = new Null(null,fromButton.getX(), fromButton.getY());
		Null noPieceTo = new Null(null,toButton.getX(), toButton.getY());
		int dy = Integer.signum(toButton.getMyY() - fromButton.getMyY());
		tile[fromButton.getMyX()][fromButton.getMyY()+2*dy].setPiece(fromButton.getPiece());
		tile[fromButton.getMyX()][fromButton.getMyY()+1*dy].setPiece(toButton.getPiece());
		fromButton.setPiece(noPieceFrom);
		toButton.setPiece(noPieceTo);
		King.setCastling(false);
	 }
	 
    void ValidBackgrounds(int i, int j, Piece orginalPiece) {
        if (orginalPiece.isValidMove(i, j)){
            if ((fromButton.getColor() != tile[i][j].getColor())||(King.getCastling()&&tile[i][j].getPiece().gettype()==Piece.type.Rook
            		&&fromButton.getColor() == tile[i][j].getColor())) {
            	
            	if(King.getCastling()&&tile[i][j].getPiece().gettype()==Piece.type.Rook
            		)
            		System.out.println("معايا طابية اما نشوف اخرتها");
                tile[i][j].setBackground(Color.green);
                tile[i][j].repaint();
            }
            else{
                tile[i][j].setBackground(Color.red);
                tile[i][j].repaint();
            }

            }

    }

    public static JPanel getChessBoard() {
        return chessBoard;
    }
}