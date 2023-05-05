package Piece;

import chessGame.ChessBoard;
import chessGame.Square;

import java.awt.*;

import static chessGame.ChessBoard.tile;


public class Rook extends Piece {
    //private final Piece p = knight;
    public Rook (Color color, int x, int y) {
        super(color, x, y);
    }



        @Override
        public boolean isValidMove(int newX, int newY) {
            int diffX = Math.abs(newX - x);
            int diffY = Math.abs(newY - y);

            if (diffX != 0 && diffY != 0) {
                // The move is not vertical or horizontal
                return false;
            }

            int xDir = Integer.signum(newX - x);
            int yDir = Integer.signum(newY - y);

            // Check if there are pieces in the path
            for (int i = x + xDir, j = y + yDir; i != newX || j != newY; i += xDir, j += yDir) {
                if (tile[i][j].getPiece().getColor() != null) {
                    return false;
                }
            }
isMovedR = true;
            return true;
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

    static boolean isMovedR = false;
    public static boolean getStatusR() {
        return isMovedR;
    }
}

