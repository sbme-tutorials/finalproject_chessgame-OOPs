package chessGame;
import Piece.*;
import javax.swing.*;


public class Square extends JButton {

    private final int x,y;
    private Piece p; // Type of the chess piece on the square (e.g. "king", "queen", "rook", etc.)


    public Square( int x , int y) {

        this.x = x;
        this.y = y;
        // set background color of chess board
        if ((x + y) % 2 == 0)
            setBackground(new java.awt.Color(117, 22, 63));

        else
            setBackground(new java.awt.Color(255, 145, 127));
        // show piecess
        if (p != null)
            setPiece(p);


    }
    public void setPiece(Piece p)
        {
        this.p=p;
        this.add(new JLabel(new ImageIcon( p.get_icon(p))));
    }

    public Piece getPieceType()
    {
        return p;
    }


}


