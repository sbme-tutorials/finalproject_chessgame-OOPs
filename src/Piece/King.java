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
        boolean check3 = (diff2 == 1 && diff1 == 1);

        return check1 || check2 || check3 || this.canCastle(newX, newY);

    }
    public boolean IsinItCheck(Square[][] tile) {//this function checks if any piece can check the king
        //tile[i][j] is the one attacking the king
        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tile[i][j].getPiece().isValidMove(this.getX(), this.getY())) {
                    if (tile[i][j].getColor()==Color.BLACK && this == whiteKing
                    || tile[i][j].getColor()==Color.white && this ==blackKing) {
                        System.out.println(tile[i][j].getPiece() + " check king");//change this with a msg on the interface
                        return true;
                    }
                }
            }
        }
        return false;
    }
  public static boolean CanGetKingOutofCheck(King king) {
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
                      if (piece.isMoveValid(x, y)) {
                              return true;
                          }
                      }
                  }
              }
          }
      }

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