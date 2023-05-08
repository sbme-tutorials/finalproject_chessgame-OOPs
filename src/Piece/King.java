package Piece;

import chessGame.Square;

import java.awt.*;

import static chessGame.ChessBoard.*;

public class King extends Piece {
    public King(Color color, int x, int y) {
        super(color, x, y);

    }
    public King king;
    boolean ismoved = false;
    Color originalKingColor = this.getColor();

    @Override
    public boolean isValidMove(int newX, int newY) {
        ismoved=true;
        int diff1 = Math.abs(newX - this.getX());
        int diff2 = Math.abs(newY - this.getY());

        boolean check1 = (diff1 == 0 && diff2 == 1);
        boolean check2 = (diff2 == 0 && diff1 == 1);
        boolean chek3 = (diff2 == 1 && diff1 == 1);
        // remember to add another check to avoid kings being next to each other

        if ((check1 || check2 || chek3 || this.canCastle(newX,newY))&& !this.doesNewMovePutInCheck(newX,newY) ) {

            return true;
        }

        else
            return false;
    }
    public boolean IsinItCheck(Square[][] tile) {//this function checks if any piece can check the king
        //tile[i][j] is the one attacking the king
        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tile[i][j].getPiece().isValidMove(whiteKing.getX(), whiteKing.getY())&& tile[i][j].getColor()==Color.black) {
                    System.out.println(tile[i][j].getPiece() + " check white king");//change this with a msg on the interface
                    return true;
                } else if (tile[i][j].getPiece().isValidMove(blackKing.getX(), blackKing.getY())&&tile[i][j].getColor()==Color.white) {
                    System.out.println(tile[i][j].getPiece() + " check black king");//change this with a msg on the interface
                    return true;
                }
            }
        }
        return false;
    }
    public boolean CanGetOutofCheck(King king) {
        int oldX = this.getX();
        int oldY = this.getY();

        // Simulate all possible moves of the king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.isValidMove(i, j)) {
                    if (this.getColor() != tile[i][j].getColor()) {
                        // Try the move
                        this.setX(i);
                        this.setY(j);

                        // Check if the king is out of check
                        if (!this.IsinItCheck(tile)) {
                            // Reset the king's position and return true
                            this.setX(oldX);
                            this.setY(oldY);
                            return true;
                        }
                    }
                }
            }
        }

        // Reset the king's position and return false
        king.setX(oldX);
        king.setY(oldY);
        return false;
    }

    //==========================================================================//








    @Override
    public String get_icon(Color color){
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wK.png";
        }
        else
            return "1_deliverabless/Piece./bK.png";
    }
}
