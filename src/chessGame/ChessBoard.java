package chessGame;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {
    public JPanel chessBoard;
    private JPanel[][] squares = new JPanel[8][8];

    public ChessBoard() {
        createBoard();
        addPieces();
    }

    private void createBoard() {
        // Create the chessboard panel with a GridLayout
        chessBoard = new JPanel(new GridLayout(8, 8));

        // Create the square panels and add them to the chessboard panel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();
                chessBoard.add(squares[i][j]);
            }
        }

        // Set the background color of the square panels
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(new Color(117,22,63));
                } else {
                    squares[i][j].setBackground(new Color(255,145,127));
                }
            }
        }
    }

    private void addPieces() {
        // Add the white pieces
        squares[0][0].add(new JLabel(new ImageIcon("WR.gif")));
        squares[0][1].add(new JLabel(new ImageIcon("WN.gif")));
        squares[0][2].add(new JLabel(new ImageIcon("WB.gif")));
        squares[0][3].add(new JLabel(new ImageIcon("WQ.gif")));
        squares[0][4].add(new JLabel(new ImageIcon("WK.gif")));
        squares[0][5].add(new JLabel(new ImageIcon("WB.gif")));
        squares[0][6].add(new JLabel(new ImageIcon("WN.gif")));
        squares[0][7].add(new JLabel(new ImageIcon("WR.gif")));
        for (int i = 0; i < 8; i++) {
            squares[1][i].add(new JLabel(new ImageIcon("WP.gif")));
        }

        // Add the black pieces
        squares[7][0].add(new JLabel(new ImageIcon("BR.gif")));
        squares[7][1].add(new JLabel(new ImageIcon("BN.gif")));
        squares[7][2].add(new JLabel(new ImageIcon("BB.gif")));
        squares[7][3].add(new JLabel(new ImageIcon("BQ.gif")));
        squares[7][4].add(new JLabel(new ImageIcon("BK.gif")));
        squares[7][5].add(new JLabel(new ImageIcon("BB.gif")));
        squares[7][6].add(new JLabel(new ImageIcon("BN.gif")));
        squares[7][7].add(new JLabel(new ImageIcon("BR.gif")));
        for (int i = 0; i < 8; i++) {
            squares[6][i].add(new JLabel(new ImageIcon("BP.gif")));
        }
    }

    public JPanel getChessBoard() {
        return chessBoard;
    }}
    /**public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Chess Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the chessboard
        ChessBoard chessBoard = new ChessBoard();

        // Add the chessboard to the frame
        frame.getContentPane().add(chessBoard.getChessBoard());

        // Make the frame visible
        frame.setVisible(true);
    }

}*/
    // i diddnt delet the main here for test purposes

