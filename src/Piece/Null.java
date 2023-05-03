package Piece;
import java.awt.*;
public class Null extends Piece
{
    public Null(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY)  // Always returns false
    {
            return false;
    }
    @Override
    public String get_icon(Color color)
    {
        return "";
    }
}
