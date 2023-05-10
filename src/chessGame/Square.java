package chessGame;

import Piece.Piece;

import javax.swing.*;
import java.awt.*;

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


    public int getMyX() {
        return x;
    }
}