package Piece;
import chessGame.Square;

import java.awt.*;
import java.util.ArrayList;
public abstract class Piece
{
    public abstract String get_icon(Color color);
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
    public boolean isValidMove(int newX, int newY)//should be implemented in each piece
    {
        return !(this.getColor() == color);

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

}
