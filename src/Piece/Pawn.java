
package Piece;

import chessGame.GameView;
import chessGame.Square;

import javax.swing.*;
import java.awt.*;

import static chessGame.ChessBoard.*;


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
                	return true;
                }
            }
            else if ((diff1 == 1 && diff2 == 0)
            		||(diff2==1 && diff1==1 && tile[getX()+dx][getY()+dy].getColor()==Color.WHITE)) {
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
                	return true;
                }
            }
            else if ((diff1 == -1 && diff2 == 0)
            		||(diff2==1&&diff1==-1&&tile[getX()+dx][getY()+dy].getColor()==Color.BLACK)) {
            	if(newX == 0)
            		isPromoted = true;
            	return true ;
            }
        }
        return false;
    }
    //==============================================Promotion===========================================================//
    public static void promotion(Square fromButton, Square toButton) {
        boolean promoted = true;
        Piece takenPiece = toButton.getPiece();
        ImageIcon logo = new ImageIcon("1_deliverabless/Pro1.PNG");
        Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());
        Object[] options = {"Queen", "Rook", "Bishop", "Knight"};
        int choice = JOptionPane.showOptionDialog(
                null, "Congratulations, You are promoted!", "Promotion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, logo,
                options, options[3]);
        if(fromButton.getMyX()==6)
            switch (choice) {
                case 0:
                    toButton.setPiece(new Queen(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 1:
                    toButton.setPiece(new Rook(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 2:
                    toButton.setPiece(new Bishop(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 3:
                    toButton.setPiece(new Knight(Color.BLACK, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                default:
                    isWhiteTurn = !isWhiteTurn;
                    promoted = false;
                    break;
            }
        else if(fromButton.getMyX()==1)
            switch (choice) {
                case 0:
                    toButton.setPiece(new Queen(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 1:
                    toButton.setPiece(new Rook(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 2:
                    toButton.setPiece(new Bishop(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                case 3:
                    toButton.setPiece(new Knight(Color.WHITE, toButton.getMyX(), toButton.getMyY()));
                    fromButton.setPiece(noPiece);
                    break;
                default:
                    isWhiteTurn = !isWhiteTurn;
                    promoted = false;
                    break;
            }
        GameView.getScore(takenPiece);
        if (takenPiece.getColor()==Color.white&&promoted) {
            rowsLoop: for (int i = 0; i < 8; i++) {  //displaying eaten pieces
                for (int j = 0; j < 2; j++) {
                    if (tile_1[i][j].getPiece() == null){
                        tile_1[i][j].setPiece(takenPiece);
                        break rowsLoop;
                    }
                }
            }
        }
        else if (takenPiece.getColor()==Color.black&&promoted) {
            rowsLoop:
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 2; j++) {
                    if (tile_2[i][j].getPiece() == null) {
                        tile_2[i][j].setPiece(takenPiece);
                        break rowsLoop;
                    }
                }
            }
        }}

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
	public  boolean getPassent() {
		return enPassent;
	}
	public  void setPassent(boolean state) {
		Pawn.enPassent = state;
		
	}
}
