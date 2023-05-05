package Piece;

import java.awt.*;
import static chessGame.ChessBoard.tile;

public class Queen extends Piece {
    //private final Piece p = knight;
    public Queen(Color color, int x, int y) {
        super(color, x, y);
    }

    boolean isVertical(int newX,int newY) {
        if (newX == getX()) {
            if (newY > getY()) {
                for (int i = getY() + 1; i <= newY; i++) {
                    if (tile[getX()][i] != null)
                    	return false;
                }
                return true;
            }
            else {
                for (int i = getY() - 1; i >= newY; i--) {
                    if (tile[getX()][i] != null)
                    	return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - getX());
        int diff2 = Math.abs(newY - getY());
        if ((diff1 != diff2))
            return false;
        //Check if there are any pieces in the way
        int dx = (newX - getX()) / Math.abs(newX - getX());
        int dy = (newY - getY()) / Math.abs(newY - getY());
        for (int i = 1; i < Math.abs(newX - getX()); i++) {
            if (tile[getX() + i * dx][getY() + i * dy] != null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String get_icon(Color color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wQ.png";
        }
        else
            return "1_deliverabless/Piece/bQ.png";
    }
}
