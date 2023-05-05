package Piece;

import java.awt.*;

import chessGame.ChessBoard;


public class Rook extends Piece {
    //private final Piece p = knight;
    public Rook (Color color, int x, int y) {
        super(color, x, y);
    }

    static boolean isMovedR = false;

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - getX());
        int diff2 = Math.abs(newY - getY());
        if (diff1 == 0||diff2 == 0) {
            int dx = Integer.signum(newX - getX());
            int dy = Integer.signum(newY - getY());
            int x = getX() + dx;
            int y = getY() + dy;
            while (x != newX || y != newY) {
                if (ChessBoard.tile[x][y] != null) {
                	return false;
                }
                x += dx;
                y += dy;
            }
            isMovedR = true;
            return true; 
        }
        return false;
    }
    @Override
    public String get_icon(Color color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wR.png";
        }
        else
            return "1_deliverabless/Piece/bR.png";
    }
    
    public static boolean getStatusR() {
    	return isMovedR;
    }
}
