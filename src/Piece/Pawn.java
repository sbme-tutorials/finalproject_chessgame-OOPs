package Piece;

import java.awt.*;


public class Pawn extends Piece {
    //private final Piece p = knight;
    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }



    @Override
    public boolean isValidMove(int newX, int newY) {
            return true;
    }
    @Override
    public String get_icon(Color color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wP.png";
        }
        else
            return "1_deliverabless/Piece/bP.png";
    }
}
