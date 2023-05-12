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
        
        // remember to add another check to avoid kings being next to each other

        if ((check1 || check2 || check3 || this.canCastle(newX,newY))) {

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
                          // Try the move
                          int pieceOldX = piece.getX();
                          int pieceOldY = piece.getY();
                          Color pieceOldColor = piece.getColor();
                          Color my_color = tile[x][y].getColor();
                          piece.setX(x);
                          piece.setY(y);
                          piece.setColor(null);
                          tile[x][y].getPiece().setColor(pieceOldColor);

                          // Check if the king is out of check
                          if (!king.IsinItCheck(tile)) {
                              // Reset the piece's position and return true
                              piece.setX(pieceOldX);
                              piece.setY(pieceOldY);
                              piece.setColor(pieceOldColor);
                              tile[x][y].getPiece().setColor(my_color);
                              return true;
                          }

                          // Reset the piece's position
                          piece.setX(pieceOldX);
                          piece.setY(pieceOldY);
                          piece.setColor(pieceOldColor);
                          tile[x][y].getPiece().setColor(my_color);
                      }
                  }
              }
          }
      }
  }

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