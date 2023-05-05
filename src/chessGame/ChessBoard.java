package chessGame;
import Piece.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard
{
    public static JPanel chessBoard;
    public static Square[][] tile = new Square[8][8];
    Piece p = null;
    public Square fromButton = null;
	public Square toButton = null;

    public ChessBoard()
    {
        createBoard();
        showPieces();
    }

    private void createBoard()
    {
        // Create the chessboard panel with a GridLayout
        chessBoard = new JPanel(new GridLayout(8, 8));

        // 64 tiles of class square wich is extendend from Jpanel
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                tile[i][j] = new Square(i, j, p);
                //======================================================================================================//
                //adding mouse listeners for user interaction
                tile[i][j].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        Square clickedButton = (Square) e.getSource();
                        if (fromButton == null )
                        {
                            // First click - set fromButton to the clicked button
                            fromButton = clickedButton;
                        }
                        else
                        {
                            // Second click - set toButton to the clicked button and do something with the move

                            if (clickedButton != fromButton )   // avoid double click
                            {
                                toButton = clickedButton;
                                boolean isItValid = fromButton.getPiece().isValidMove(toButton.getMyX(), toButton.getMyY());
                                  // the isValidMove function is the core of the logic and the rules behind the game
                                if(isItValid && !isSameTeam(fromButton.getPiece(),toButton.getPiece()))
                                    movePiece(fromButton, toButton);
                            }
                            fromButton = null;
                        }
                    }
                });
                //===========================================================================================================//
                chessBoard.add(tile[i][j]);
            }
        }
    }
    
    public static boolean isSameTeam(Piece p1, Piece p2) {
    	if(p1.getColor()==p2.getColor())
    		return true;
    	return false;
    }

    
    public void showPieces() {
        // Black Pieces
        tile[0][0].setPiece(new Rook(Color.BLACK, 0, 0));
        tile[0][1].setPiece(new Knight(Color.BLACK, 0, 1));
        tile[0][2].setPiece(new Bishop(Color.BLACK, 0, 2));
        tile[0][3].setPiece(new Queen(Color.BLACK, 0, 3));
        tile[0][4].setPiece(new King(Color.BLACK, 0, 4));
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
        tile[7][4].setPiece(new King(Color.WHITE, 7, 4));
        tile[7][5].setPiece(new Bishop(Color.WHITE, 7, 5));
        tile[7][6].setPiece(new Knight(Color.WHITE, 7, 6));
        tile[7][7].setPiece(new Rook(Color.WHITE, 7, 7));
        for (int j = 0; j < 8; j++) {
            tile[6][j].setPiece(new Pawn(Color.WHITE, 6, j));
        }

        // Set other squares to no Piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setPiece(new Null(null , i , j));
            }
        }
    }

    //=====================================================================================================================//
    private void movePiece(Square fromButton, Square toButton)
    {
    	Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());  //generic null piece, this i equivalent to removing the piece from the
        //original square
    	if(!King.getCastling()) {
	        // get the piece from frombutton and setting it to tobutton
	        toButton.setPiece(fromButton.getPiece());
	        fromButton.setPiece(noPiece);
	    }
    	else {
    		int dx = Integer.signum(toButton.getX() - fromButton.getX());
    		tile[fromButton.getX()+2*dx][fromButton.getY()].setPiece(fromButton.getPiece());
    		fromButton.setPiece(noPiece);
    		tile[fromButton.getX()+dx][fromButton.getY()].setPiece(toButton.getPiece());
    		King.setCastling(false);
    	}
    }
    public static JPanel getChessBoard()
    {
        return chessBoard;
    }
}



