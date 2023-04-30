package chessGame;
import Piece.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoard {
    public JPanel chessBoard;
    private Square[][] tile = new Square[8][8];
    //JButton fromButton = null;
    //JButton toButton = null;

    public ChessBoard() {
        createBoard();
        //addPieces();
        showPieces();
        //movePiece(fromButton,toButton);

    }

    private void createBoard() {
        // Create the chessboard panel with a GridLayout
        chessBoard = new JPanel(new GridLayout(8, 8));

        // 64 tiles of class square wich is extendend from Jpanel
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                tile[i][j] = new Square(i, j);
                chessBoard.add(tile[i][j]);
            }
        }

        // Add ActionListener to each button
       /* for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                JButton button = tile[i][j];

                button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fromButton == null) {
                            // First button clicked, set it as the 'fromButton'
                            fromButton = button;
                            fromButton.setBorder(BorderFactory.createLineBorder(Color.RED));
                        } else {
                            // Second button clicked, set it as the 'toButton' and call 'movePiece'
                            toButton = button;
                            movePiece(fromButton, toButton);
                            fromButton.setBorder(null);
                            fromButton = null;
                            toButton = null;
                        }
                    }

                                            @Override
                                            public void mousePressed(MouseEvent e) {

                                            }

                                            @Override
                                            public void mouseReleased(MouseEvent e) {

                                            }

                                            @Override
                                            public void mouseEntered(MouseEvent e) {

                                            }

                                            @Override
                                            public void mouseExited(MouseEvent e) {

                                            }
                                        }
                );
                chessBoard.add(button);
            }*/
        }




    void showPieces() {
        // knight done
        Knight bn1 = new Knight(Color.BLACK, 0, 1);
        tile[0][1].setPiece(bn1);
        Knight bn2 = new Knight(Color.BLACK, 0, 6);
        tile[0][6].setPiece(bn2);
        Knight wn1 = new Knight(Color.WHITE, 7, 1);
        tile[7][1].setPiece(wn1);
        Knight wn2 = new Knight(Color.WHITE, 7, 6);
        tile[7][6].setPiece(wn2);

    }


    public JPanel getChessBoard() {
        return chessBoard;
    }

    public void movePiece(JButton fromButton, JButton toButton) {
        // Get the icon of the piece from the 'fromButton'
        Icon pieceIcon = fromButton.getIcon();
        // Set the icon of the 'toButton' to the piece icon
        toButton.setIcon(pieceIcon);
        // Set the icon of the 'fromButton' to null to remove the piece icon
        fromButton.setIcon(null);
    }


    }






    /*private void addPieces() {
        // Add the white pieces
        //حاولت احط القطع في النص ماحصلش تغيير بس خلوا الكود ممكن نحتاجه
        tile[0][2].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wB.png")));
        tile[0][3].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wQ.png")));
        tile[0][4].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wK.png")));
        tile[0][5].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wB.png")));
        tile[0][7].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wR.png")));
        for (int i = 0; i < 8; i++) {
            tile[1][i].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/wP.png")));
        }

        // Add the black pieces
        tile[7][0].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bR.png")));

        tile[7][2].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bB.png")));
        tile[7][3].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bQ.png")));
        tile[7][4].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bK.png")));
        tile[7][5].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bB.png")));
        ;
        tile[7][7].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bR.png")));
        for (int i = 0; i < 8; i++) {
            tile[6][i].add(new JLabel(new ImageIcon("1_deliverabless/Piece.Piece/bP.png")));
        }

    }*/
