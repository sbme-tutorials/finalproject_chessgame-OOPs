package Piece;
import chessGame.ChessBoard;
import chessGame.Square;

import javax.swing.*;
import java.awt.*;

import static chessGame.ChessBoard.tile;

public class King extends Piece {
    public King(Color color, int x, int y) {
        super(color, x, y);
    }
    public King king;
    boolean isMovedK = false;
    boolean isMovedR = Rook.getStatusR();
    boolean noObstacle = false;
    static boolean isCastling = false;

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - this.getX());
        int diff2 = Math.abs(newY - this.getY());

        boolean check1 = (diff1 == 0 && diff2 == 1);
        boolean check2 = (diff2 == 0 && diff1 == 1);
        boolean check3 = (diff2 == 1 && diff1 == 1);
        
        // remember to add another check to avoid kings being next to each other
        if ((check1 || check2 || check3)&& !this.doesNewMovePutInCheck(newX,newY)) {
        	System.out.println("is moved? "+isMovedK);
        	isMovedK = true;
            return true;
        }
        else if((diff2 == 4|| diff2 == 3) && diff1==0&&!isMovedK) {
        	return castling(isMovedR,isMovedK, diff2);
        }
        return false;
    }
    public boolean IsinItCheck (Square[][] tile) {//this function checks if any piece can check the king
        //tile[i][j] is the one attacking the king
        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                        if (tile[i][j].getPiece().isValidMove(this.getX(),this.getY()))
                            if (this.getColor() != tile[i][j].getColor()) {
                                //System.out.println(this + "check");//change this with a msg on the interface
                                return true;
                            }
            }
        }
        return false;
    }
    public boolean CanGetOutofCheck(King king) {
        int oldX = king.getX();
        int oldY = king.getY();

        // Simulate all possible moves of the king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (king.isValidMove(i, j)) {
                    if (king.getColor() != tile[i][j].getColor()) {
                        // Try the move
                        king.setX(i);
                        king.setY(j);

                        // Check if the king is out of check
                        if (!king.IsinItCheck(tile)) {
                            // Reset the king's position and return true
                            king.setX(oldX);
                            king.setY(oldY);
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

    public boolean doesNewMovePutInCheck(int newX, int newY) {
        int oldX = this.getX();
        int oldY = this.getY();

        // Try the move
        this.setX(newX);
        this.setY(newY);

        // Check if the king is in check after the move
        boolean isInCheck = this.IsinItCheck(tile);

        // Reset the king's position
        this.setX(oldX);
        this.setY(oldY);

       return isInCheck;
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
	public boolean castling(boolean r, boolean k, int diff2) {
	  	if(diff2 == 4) {
	  		for(int i = getY()-1; i>0; i--) {
	        	if(tile[getX()][i].getColor()!=null) {
	        		noObstacle = false;
	        		System.out.println("there is an obstacle. diff2 =4");
	        		break;
	        	}
	        	else {
	        		noObstacle = true;
	    			System.out.println("there is no obstacle. diff2 =4");
	        	}
			}
    	}
	  	{
	  		if(diff2 == 3) {
	  			for(int i = getY()+1; i<7; i++) {
	  				if(tile[getX()][i].getColor()!=null) {
	  					noObstacle = false;
	  					System.out.println("there is an obstacle. diff2 =3");
	  					break;
	  				}
	  				else {
	  					noObstacle = true;
	  					System.out.println("there is no obstacle. diff2 =3");
	  				}
	  			}
			}
		}
		
		if(!r && !k && noObstacle) {
			isCastling = true;
			System.out.println("can castle."+ isMovedK);
			return true;
		}
		return false;
	}
	public static boolean getCastling () {
		return isCastling; 
		}
	public static void setCastling(boolean cast) {
		isCastling = cast;
	}
}