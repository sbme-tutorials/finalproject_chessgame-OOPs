package chessGame;

import Piece.*;

import javax.swing.*;
import java.awt.*;

import static chessGame.ChessBoard.*;

public class Square extends JButton
{
    private final int x,y;
    protected Piece p; // Type of the chess piece on the square (e.g. "king", "queen", "rook", etc.)
    public Square( int x , int y , Piece p)
    {
        this.x = x;
        this.y = y;
        this.p=p;
        if (p != null)
            setPiece(p);
    }


    static void showPieces() {
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
        tile[7][0].setPiece(new Rook(Color.white, 7, 0));
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
    public void setPiece(Piece p)//this function set the piece in the square and sets it as button icon
    {
        this.p=p;
        p.setX(this.getMyX());
        p.setY(this.getMyY());
        this.setIcon(new ImageIcon( p.get_icon(p.color)));
    }
    public Piece getPiece()
    {
        return p;
    }
    public Color getColor()
    {
        return p.getColor();
    }

    public int getMyY() // please don't change the naming to getY bcz it overrides the functions at javax.swing.JPanel
        //and creates errors drawing squares
    {
        return y;
    }
    public  static void ValidBackgrounds(int i, int j, Piece orginalPiece) {
        if (orginalPiece.isValidMove(i, j)){
            if (orginalPiece.getColor() != tile[i][j].getColor() && orginalPiece.isMoveValid(i,j)) {
                tile[i][j].setBackground(Color.green);
                tile[i][j].repaint();
            }
            else if (orginalPiece.canCastle(i , j))
            {
                tile[i][j].setBackground(new Color(783319));
                tile[i][j].repaint();
            }
            else{
                tile[i][j].setBackground(Color.red);
                tile[i][j].repaint();
            }

        }

    }
    public static void resetBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    tile[i][j].setBackground(new Color(0x041a43));
                } else {
                    tile[i][j].setBackground(new Color(0xf7e8d5));

                }
            }

        }
    }


    //======================================================================================================================//
    public static void disableAllSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setEnabled(false);
            }
        }
    }

    public int getMyX() {
        return x;
    }
}