package Piece;

import java.awt.*;

import chessGame.ChessBoard;


public class King extends Piece {
    //private final Piece p = knight;
    public King(Color color, int x, int y) {
        super(color, x, y);
    }
    
    boolean isMovedK = false;
    boolean isMovedR = Rook.getStatusR();
    boolean noObstacle = false;
    static boolean isCastling = false;

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diff1 = Math.abs(newX - getX());
        int diff2 = Math.abs(newY - getY());
        if ((diff1 == 1 && diff2 == 0)||(diff1 == 0 && diff2 == 1)||( diff1 == 1  && diff2 == 1)){
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
            isMovedK = true;
            return true;
        }
        else if((diff1 ==3|| diff1 ==2)&&diff2==0) {
        	isCastling = true;
        	castling(isMovedR,isMovedK,noObstacle);
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
    public boolean castling(boolean r, boolean k, boolean o) {
    	if((ChessBoard.tile[1][7]!=null&&ChessBoard.tile[2][7]!=null&&ChessBoard.tile[3][7]!=null)||(ChessBoard.tile[5][7]!=null||ChessBoard.tile[6][7]!=null)||(ChessBoard.tile[1][0]!=null&&ChessBoard.tile[2][0]!=null&&ChessBoard.tile[3][0]!=null)||(ChessBoard.tile[5][0]!=null||ChessBoard.tile[6][0]!=null)) {
    		noObstacle = true;}
    	if(r && k && o)
    		return false;
    	return true;
    }
	public static boolean getCastling () {
		return isCastling; 
		}
	public static void setCastling(boolean cast) {
		King.isCastling = cast;
	}
}
