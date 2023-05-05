package Piece;

import java.awt.*;


public class Pawn extends Piece {
    //private final Piece p = knight;
    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }

    public boolean isFirst(Color color){
       if ((this.color == Color.black) && (getX() == 1))
             return true ;
       else if ((this.color == Color.white) && (getX() == 6))
             return true;
       else
             return false;
        }

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff2 = newX - getX();   //don't take abs as the pawn can't return back.  
        int diff1 = Math.abs(newY - getY());
    
      if (this.color == Color.black ){
           if(isFirst(this.getColor())){
              if ((diff1 == 2 && diff2 == 0) || (diff1 == 1 && diff2 == 0))
                 return true;
          }
          else if ((diff1 == 1 && diff2 == 1) || (diff1 == 1 && diff2 == 0))
                  return true ;
      }
      else
    	  return false;

      if (this.color == Color.white){
           if(isFirst(this.getColor())){
               if ((diff1 == -2 && diff2 == 0) || (diff1 == -1 && diff2 == 0))
                 return true;
                      }
           else if ((diff1 == -1 && diff2 == 1) || (diff1 == -1 && diff2 == 0))
                  return true ;
      }
      return false; 
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