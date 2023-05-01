package Piece;
import java.awt.*;

public abstract class Piece
{
    public enum Type
    {
        Pawn,
        Knight,
        Queen,
        Rock,
        Bishop,
        King
    }
    public Color color; int x,y ;
    private Type type;
    public Piece(Color color, int x, int y) // CONSTRUCTOR
    {
        this.color = color;
        this.x = x;
        this.y = y;
    }


///////////////////setters and getters
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
    public Type getType() {
        return type;
    }

    public String get_icon(Piece p) { //this returnss the path of the image
        if (p instanceof Knight ){
        if (p.getColor()== Color.BLACK){
            return "1_deliverabless/Piece/bH.png";//is black
        }
        else {return "1_deliverabless/Piece/wH.png";}}// is white
        // add the rest of the pieces here
        return "";
    }



    public abstract boolean isValidMove(int newX, int newY);//should be implemented in each piece



}
