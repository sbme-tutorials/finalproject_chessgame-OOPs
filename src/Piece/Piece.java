package Piece;

import java.awt.*;

import static chessGame.ChessBoard.*;

public abstract class Piece
{
    public abstract String get_icon(Color color);

    public void setColor(Color color) {
        this.color = color;
    }
    private boolean isMoved = false;

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public enum type
    {
        Pawn,
        Knight,
        Queen,
        Rock,
        Bishop,
        King,
        Null
    }
    public Color color; int x,y ;
    private static type type;
    public Piece(Color color, int x, int y) // CONSTRUCTOR
    {
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public boolean isMoveValid(int newX, int newY)//should be implemented in each piece
    {
       if(isValidMove(newX,newY))
           return !doesNewMovePutInCheck(newX,newY);
       else return false;
    }
    public abstract boolean isValidMove(int newX, int newY);

    //=========================================================================================================//
    public boolean doesNewMovePutInCheck(int newX, int newY) {
        if (this.getColor() == Color.WHITE) {
            int oldX = this.getX();
            int oldY = this.getY();
            Color tempColor = this.getColor();
            Color my_color = tile[newX][newY].getColor();
            // Try the move
            this.setX(newX);
            this.setY(newY);
            this.setColor(null);
            tile[newX][newY].getPiece().setColor(tempColor);

            // Check if the king is in check after the move
            boolean isInCheck = whiteKing.IsinItCheck(tile);


            // Reset the Piece's position and color
            this.setX(oldX);
            this.setY(oldY);
            this.setColor(tempColor);
            tile[newX][newY].getPiece().setColor(my_color);

            return isInCheck;
        }
        //==================================================================================//
        else if (this.getColor() == Color.black) {
            int oldX = this.getX();
            int oldY = this.getY();
            Color tempColor = this.getColor();
            Color my_color = tile[newX][newY].getColor();
            // Try the move
            this.setX(newX);
            this.setY(newY);
            this.setColor(null);
            tile[newX][newY].getPiece().setColor(tempColor);

            // Check if the king is in check after the move
            boolean isInCheck = blackKing.IsinItCheck(tile);


            // Reset the Piece's position and color
            this.setX(oldX);
            this.setY(oldY);
            this.setColor(tempColor);
            tile[newX][newY].getPiece().setColor(my_color);

            return isInCheck;
        }
        else return false;
    }

//setters and getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Color getColor() {
        return color;
    }
    public type gettype() {
        return type;
    }

    public boolean CanGetKingOutofCheck(King king) {
        int oldX = this.getX();
        int oldY = this.getY();

        // Get the army color of the king
        Color armyColor = king.getColor();

        // Simulate all possible moves of the army's pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = tile[i][j].getPiece();
                if (piece.getColor() == armyColor) {
                    // Check if the piece can move to get the king out of check
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (piece.isValidMove(x, y)) {
                                // Try the move
                                int pieceOldX = piece.getX();
                                int pieceOldY = piece.getY();
                                Color pieceOldColor = piece.getColor();
                                piece.setX(x);
                                piece.setY(y);
                                piece.setColor(null);

                                // Check if the king is out of check
                                if (!king.IsinItCheck(tile)) {
                                    // Reset the piece's position and return true
                                    piece.setX(pieceOldX);
                                    piece.setY(pieceOldY);
                                    piece.setColor(pieceOldColor);
                                    return true;
                                }

                                // Reset the piece's position
                                piece.setX(pieceOldX);
                                piece.setY(pieceOldY);
                                piece.setColor(pieceOldColor);
                            }
                        }
                    }
                }
            }
        }

        // Reset the king's position and return false
        this.setX(oldX);
        this.setY(oldY);
        return false;
    }
    public boolean canCastle (int newX,int newY) {
        if (this instanceof King) {
            if (tile[newX][newY].getPiece() instanceof Rook) {
                if (this.getisMoved() == false && tile[newX][newY].getPiece().getisMoved() == false) {
                    int oldKingX = this.getX();
                    int oldKingY = this.getY();
                    int oldRookX = newX;
                    int oldRookY = newY;
                    if (oldKingX == oldRookX) {
                        int sign = Integer.signum(newY - this.getY());
                        boolean pathClear = true;


                        // Check if the squares between the king and the rook are empty
                        for (int j = oldKingY + sign; j != oldRookY; j += sign) {
                            if (tile[oldKingX][j].getPiece().getColor() != null) {
                                pathClear = false;
                                break;
                            }
                        }

                        // If the path is clear, move the king and rook
                        if (pathClear) {
                            System.out.println("im here");
                            return true;
                        }
                    }
                }

            }
        }

            return false;

        }


    public boolean getisMoved(){
        return isMoved;
    }


}