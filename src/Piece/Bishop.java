package Piece;

import java.awt.*;


public class Bishop extends Piece {
    //private final Piece p = knight;
    public Bishop(Color color, int x, int y) {
        super(color, x, y);
    }



    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - getX());
        int diff2 = Math.abs(newY - getY());
        if ( diff1==diff2) {
            if (diff1<=3) {return true;}
            else  return false;
        }
        else
        {if ((Math.abs(diff1-diff2)==1)&&(diff2<=3)&&(diff1<=4||diff1<=2))
        {return true;}
        else return false;}
    }
    @Override
    public String get_icon(Color color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wB.png";
        }
        else
            return "1_deliverabless/Piece/bB.png";
    }
}
