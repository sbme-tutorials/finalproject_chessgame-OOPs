package Piece;
import java.awt.*;
public class Knight extends Piece
{
    public Knight(Color color, int x, int y)
    {
        super(color, x, y);
    }
    @Override
    public boolean isValidMove(int newX, int newY)
    {
        int diff1 = Math.abs(newX - this.getX());
        int diff2 = Math.abs(newY - this.getY());

        if ( (diff1==3 && diff2 == 2) || (diff1 == 2 && diff2 == 3) )
        {
            return true;
        }
        else
        return false;
    }
    @Override
    public String get_icon(Color color)//this function returns the icon path to the setPiece method in the Square class
    {
        if (this.color == Color.white)
        {
            return "1_deliverabless/Piece/wH.png";
        }
        else
        return "1_deliverabless/Piece/bH.png";
    }
}
