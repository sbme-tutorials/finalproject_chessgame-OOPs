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
                if ((i + j) % 2 != 0) {
                    squares[i][j].setBackground(new Color(117,22,63));
                } else {
                    squares[i][j].setBackground(new Color(255,145,127));
                }
            }
        }
    }

    private void addPieces() {
        // Add the white pieces
        //حاولت احط القطع في النص ماحصلش تغيير بس خلوا الكود ممكن نحتاجه
        squares[7][0].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wR.png")), JLabel.CENTER);
        squares[7][1].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wH.png")));
        squares[7][2].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wB.png")));
        squares[7][3].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wQ.png")));
        squares[7][4].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wK.png")));
        squares[7][5].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wB.png")));
        squares[7][6].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wH.png")));
        squares[7][7].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wR.png")));
        for (int i = 0; i < 8; i++) {
            squares[6][i].add(new JLabel(new ImageIcon("1_deliverabless/Piece/wP.png")));
        }

        // Add the black pieces
        squares[0][0].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bR.png")));
        squares[0][1].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bH.png")));
        squares[0][2].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bB.png")));
        squares[0][3].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bQ.png")));
        squares[0][4].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bK.png")));
        squares[0][5].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bB.png")));
        squares[0][6].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bH.png")));
        squares[0][7].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bR.png")));
        for (int i = 0; i < 8; i++) {
            squares[1][i].add(new JLabel(new ImageIcon("1_deliverabless/Piece/bP.png")));
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

