package Piece;

import java.awt.*;

import static chessGame.ChessBoard.tile;


public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(color, x, y);
    }



    @Override
    public boolean isValidMove(int newX, int newY) {
        int xDir = Integer.signum(newX - getX());
        int yDir = Integer.signum(newY - getY());

        // Check if there are pieces in the path
        for (int i = getX() + xDir, j = getY() + yDir; i != newX || j != newY; i += xDir, j += yDir) {
            if (i == 8 || j == 8||i<0||j<0)
                return false;
            if (tile[i][j].getColor() != null) {
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