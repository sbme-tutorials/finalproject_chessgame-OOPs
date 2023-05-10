package Piece;

import static chessGame.ChessBoard.tile;
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
    static boolean isPromoted = false;
    static boolean enPassent = false;
    boolean firstMoveB = false;
    boolean firstMoveW = false;

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = newX - getX();   //don't take abs as the pawn can't return back.
        int diff2 = Math.abs(newY - getY());
        int dx = Integer.signum(newX-getX());
        int dy = Integer.signum(newY-getY());

        if (this.color == Color.black ){
            if (isFirst(this.color)){
                if ((diff1 == 2 && diff2 == 0)
                		||(diff1 == 1 && diff2 == 0)
                		||(diff2==1 && diff1==1 && tile[getX()+dx][getY()+dy].getColor()==Color.WHITE)) {

                	if(diff1 == 2)
                		if(tile[getX()+1][getY()].getPiece().getColor()!=null)
                			return false;
                		else 
                			firstMoveB = true;
                	return true;
                }
            }
            else if ((diff1 == 1 && diff2 == 0)
            		||(diff2==1 && diff1==1 && tile[getX()+dx][getY()+dy].getColor()==Color.WHITE)
            		||(diff2==1 && diff1==1 && firstMoveW && tile[getX()][getY()+dy].getColor()==Color.white)) {
            	if((diff2==1 && diff1==1 && firstMoveW &&tile[getX()][getY()+dy].getColor()==Color.white)) {
            		enPassent = true;
            		firstMoveW=false;}
            	if(newX == 7)
            		isPromoted = true;
            	return true ;
            }
            else
                return false;
        }
        else if (this.color == Color.white){
            if(isFirst(this.color)){
                if ((diff1 == -2 && diff2 == 0)
                		|| (diff1 == -1 && diff2 == 0)
                		||(diff2==1&&diff1==-1&&tile[getX()+dx][getY()+dy].getColor()==Color.BLACK)) {
                	
                	if(diff1 == -2)
	                	if(tile[getX()-1][getY()].getPiece().getColor()!=null)
	            			return false;
	                	else {
                			firstMoveW = true;}
                	return true;
                }
            }
            else if ((diff1 == -1 && diff2 == 0)
            		||(diff2==1&&diff1==-1&&tile[getX()+dx][getY()+dy].getColor()==Color.BLACK)) {
        		firstMoveW=false;
            	if(newX == 0)
            		isPromoted = true;
            	return true ;
            }
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
    public static boolean getPromotion() {
    	return isPromoted;
    }

	public static void setPromotion(boolean state) {
		Pawn.isPromoted = state;
		
	}
	public static boolean getPassent() {
		return enPassent;
	}
	public static void setPassent(boolean state) {
		Pawn.enPassent = state;
		
	}
}
