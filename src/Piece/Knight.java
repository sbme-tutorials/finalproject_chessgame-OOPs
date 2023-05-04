package Piece;

import java.awt.*;


public class Knight extends Piece {
     //private final Piece p = knight;
    public Knight(Color color, int x, int y) {
        super(color, x, y);
    }



    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - getX());
        int diff2 = Math.abs(newY - getY());
        if ( (diff1==3 && diff2 == 2) || (diff1 == 2 && diff2 == 3) ) {
            return true;
        }
        else
        	return false;
    }
    /*public String get_icon(PieceColor color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece.Piece/wH.png";
        }
        else
        return "1_deliverabless/Piece.Piece/bH.png";
    }*/
}
