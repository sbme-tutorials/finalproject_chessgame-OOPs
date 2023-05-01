package chessGame;
import Piece.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;


public class Square extends JButton
{
    private final int x,y;
    JButton fromButton = null;
    JButton toButton = null;
    private Piece p; // Type of the chess piece on the square (e.g. "king", "queen", "rook", etc.)


    public Square( int x , int y)
    {

        this.x = x;
        this.y = y;
        JButton button = this ;
        /////////
        this.addMouseListener(new MouseListener()
                              {
                                    @Override
                                    public void mouseClicked(MouseEvent e)
                                    {

                                        if (fromButton == null)
                                        {
                                            // First button clicked, set it as the 'fromButton'
                                            fromButton = button;
                                            fromButton.setBorder(BorderFactory.createLineBorder(Color.RED));
                                        }
                                        else
                                        {
                                            // Second button clicked, set it as the 'toButton' and call 'movePiece'
                                            toButton = button;
                                            movePiece(fromButton, toButton ,ChessBoard.getChessBoard());
                                            fromButton.setBorder(null);
                                            fromButton = null;
                                            toButton = null;
                                        }
                                    }

                                    @Override
                                    public void mousePressed(MouseEvent e) {}
                                    @Override
                                    public void mouseReleased(MouseEvent e) {}
                                    @Override
                                    public void mouseEntered(MouseEvent e) {}
                                    @Override
                                    public void mouseExited(MouseEvent e) {}
                                }
        );/////////////
        // set background color of chess board
        if ((x + y) % 2 == 0)
            setBackground(new java.awt.Color(117, 22, 63));

        else
            setBackground(new java.awt.Color(255, 145, 127));
        // show piecess
        if (p != null)
            setPiece(p);


    }

    private void movePiece(JButton fromButton, JButton toButton, JPanel chessBoard)
    {
            // Get the icon of the piece from the 'fromButton'
            Icon pieceIcon = fromButton.getIcon();
        System.out.println(pieceIcon);
            // Set the icon of the 'toButton' to the piece icon
            toButton.setIcon(pieceIcon);
        System.out.println(toButton.getIcon());
            // Set the icon of the 'fromButton' to null to remove the piece icon
            fromButton.setIcon(null);
        chessBoard.repaint();

    }

    public Piece.Type getP()
    {
        return p.getType();
    }

    public void setPiece(Piece p)
        {
        this.p=p;
        this.setIcon(new ImageIcon( p.get_icon(p)));
    }
}


