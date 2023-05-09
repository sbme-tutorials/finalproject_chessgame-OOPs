package chessGame;
import Piece.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard {
    public static JPanel chessBoard;
    public static Square[][] tile = new Square[8][8];
    Piece p = null;
    Square fromButton = null, toButton = null;
    private boolean isWhiteTurn = true;
    public static King blackKing = new King(Color.BLACK, 0, 4);
    public static King whiteKing = new King(Color.WHITE, 7, 4);
    public static Rook BlackRightRook =new Rook(Color.BLACK, 0, 7);
    public static Rook BlackLeftRook =new Rook(Color.BLACK, 0, 0);
    public static Rook WhiteRightRook =new Rook(Color.WHITE, 7, 7);
    public static Rook WhiteLeftRook =new Rook(Color.white, 7, 0);

    public ChessBoard() {
        createBoard();
        resetBackground();
        showPieces();
    }
//==========================================================================================================================//
    private void createBoard() {
        // Create the chessboard panel with a GridLayout
        chessBoard = new JPanel(new GridLayout(8, 8));

        // 64 tiles of class square which is extended from JPanel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j] = new Square(i, j, p);
                addMouseListenerToSquare(tile[i][j]);
                chessBoard.add(tile[i][j]);
            }
        }
    }
//==============================================================================================================================//
    private void addMouseListenerToSquare(Square square) {
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Square clickedButton = (Square) e.getSource();
                if (fromButton == null)
                {
                    if ((isWhiteTurn && clickedButton.getPiece().getColor() == Color.WHITE) ||
                            (!isWhiteTurn && clickedButton.getPiece().getColor() == Color.BLACK))
                    {
                        // First click - set fromButton to the clicked button
                        fromButton = clickedButton;
                        fromButton.setBackground(Color.BLUE);
                        // set valid moves to green and valid moves where there are pieces from thr same army to red
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                ValidBackgrounds(i, j, fromButton.getPiece());
                            }
                        }

                    }
                }
                //=====================================================================================================================//
                //second click
                else {
                    //========================================    DESELECT   ====================================================//
                    if(clickedButton ==fromButton)
                    {
                        fromButton=null;
                        // resets the color of the background
                            resetBackground();
                    }
                    //=============================================   MOVE    ======================================================//
                    // Second click - set toButton to the clicked button and do something with the move
                   else if (clickedButton.getColor() != fromButton.getColor()) {
                        if ((isWhiteTurn && fromButton.getColor() == Color.WHITE) ||
                                (!isWhiteTurn && fromButton.getColor() == Color.BLACK)) {
                            //==========================================
                            toButton = clickedButton;
                            //==========================================
                            boolean isItValid = fromButton.getPiece().isMoveValid(toButton.getMyX(), toButton.getMyY());
                            if (isItValid)
                            {
                                resetBackground();
                                //========================================
                                movePiece(fromButton, toButton);
                                //========================================  end Game   ===================================//
                                if (whiteKing.IsinItCheck(tile) && !CanGetKingOutofCheck(whiteKing))
                                {
                                    System.out.println("GAME OVER BLACK WINS");
                                    disableAllSquares();}
                                if (blackKing.IsinItCheck(tile) && !CanGetKingOutofCheck(blackKing)){
                                    System.out.println("GAME OVER White WINS");
                               disableAllSquares();}
                                if (!whiteKing.IsinItCheck(tile) && !CanGetKingOutofCheck(whiteKing)){
                                    System.out.println("GAME OVER STALEMATE");
                                disableAllSquares();}
                                if (!blackKing.IsinItCheck(tile) && !CanGetKingOutofCheck(blackKing)){
                                    System.out.println("GAME OVER STALEMATE");
                                disableAllSquares();}
                                if (Stalemate()){
                                    System.out.println("GAME OVER STALEMATE");
                                    disableAllSquares();
                                }
                                //=========================================
                                // Switch turns after a successful move
                                isWhiteTurn = !isWhiteTurn;
                                fromButton = null;
                            }
                        }
                    }
                   else if (clickedButton.getColor() == fromButton.getColor()){
                        if ((isWhiteTurn && fromButton.getColor() == Color.WHITE) ||
                                (!isWhiteTurn && fromButton.getColor() == Color.BLACK)) {
                            //==========================================
                            toButton = clickedButton;
                            //==========================================
                            if (fromButton.getPiece().canCastle(toButton.getMyX(), toButton.getMyY())) {
                                Castling(fromButton.getPiece(), toButton.getPiece());
                                resetBackground();
                                // Switch turns after a successful move
                                isWhiteTurn = !isWhiteTurn;
                                fromButton = null;
                            }
                        }
                    }

                }
            }
        });
    }


    void showPieces() {
        // Black Pieces

        tile[0][0].setPiece(BlackLeftRook);
        tile[0][1].setPiece(new Knight(Color.BLACK, 0, 1));
        tile[0][2].setPiece(new Bishop(Color.BLACK, 0, 2));
        tile[0][3].setPiece(new Queen(Color.BLACK, 0, 3));
        tile[0][4].setPiece(blackKing);
        tile[0][5].setPiece(new Bishop(Color.BLACK, 0, 5));
        tile[0][6].setPiece(new Knight(Color.BLACK, 0, 6));
        tile[0][7].setPiece(BlackRightRook);
        for (int j = 0; j < 8; j++) {
            tile[1][j].setPiece(new Pawn(Color.BLACK, 1, j));
        }

        // White Pieces
        tile[7][0].setPiece(WhiteLeftRook);
        tile[7][1].setPiece(new Knight(Color.WHITE, 7, 1));
        tile[7][2].setPiece(new Bishop(Color.WHITE, 7, 2));
        tile[7][3].setPiece(new Queen(Color.WHITE, 7, 3));
        tile[7][4].setPiece(whiteKing);
        tile[7][5].setPiece(new Bishop(Color.WHITE, 7, 5));
        tile[7][6].setPiece(new Knight(Color.WHITE, 7, 6));
        tile[7][7].setPiece(WhiteRightRook);
        for (int j = 0; j < 8; j++) {
            tile[6][j].setPiece(new Pawn(Color.WHITE, 6, j));
        }

        // Set other squares to no Piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setPiece(new Null(null, i, j));
            }
        }
    }

    //=====================================================================================================================//
    public void movePiece(Square fromButton, Square toButton){

            if (fromButton.getColor() != toButton.getColor()) {
                // get the piece from frombutton and setting it to tobutton
                toButton.setPiece(fromButton.getPiece());
                Null noPiece = new Null(null, fromButton.getX(), fromButton.getY());  //generic null piece, this i equivalent to removing the piece from the
                //original square
                toButton.getPiece().setMoved(true);
                fromButton.setPiece(noPiece);
            }
        }

    public void Castling (Piece king , Piece rook) {
        if (king.getisMoved() == false && rook.getisMoved() == false) {


            // in casteling they re on the same horizontal level , they have same x
            int oldKingX = king.getX();
            int oldKingY = king.getY();
            int oldRookX = rook.getX();
            int oldRookY = rook.getY();
            int sign = Integer.signum(rook.getY() - king.getY());
            if (Math.abs(oldKingY - oldRookY) == 3)
            {
                if (!king.doesNewMovePutInCheck(oldKingX,oldKingY + 2 * sign) )
                {
                    tile[oldKingX][oldKingY + 2 * sign].setPiece(king);
                    tile[oldKingX][oldKingY].setPiece(new Null(null, oldKingX, oldKingY));
                    tile[oldRookX][oldRookY - 2 * sign].setPiece(rook);
                    tile[oldRookX][oldRookY].setPiece(new Null(null, oldRookX, oldRookY));
                }
                 else isWhiteTurn = !isWhiteTurn;
            }
            else if((Math.abs(oldKingY - oldRookY) == 4)) {
                if (!king.doesNewMovePutInCheck(oldKingX, oldKingY + 2 * sign)) {
                    {
                        tile[oldKingX][oldKingY + 2 * sign].setPiece(king);
                        tile[oldKingX][oldKingY].setPiece(new Null(null, oldKingX, oldKingY));
                        tile[oldRookX][oldRookY - 3 * sign].setPiece(rook);
                        tile[oldRookX][oldRookY].setPiece(new Null(null, oldRookX, oldRookY));
                    }
                }
               else  isWhiteTurn = !isWhiteTurn;
            }

            }
        }


    //=======================================     Color      =================================================================//
    public void resetBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    tile[i][j].setBackground(new java.awt.Color(0x57354b));
                } else {
                    tile[i][j].setBackground(new java.awt.Color(0xedc3bb));
                }
            }
        }
    }
    void ValidBackgrounds(int i, int j, Piece orginalPiece) {
       if (orginalPiece.isMoveValid(i, j)){
            if (fromButton.getColor() != tile[i][j].getColor()) {
                tile[i][j].setBackground(Color.green);
                tile[i][j].repaint();
            }
            else{
                tile[i][j].setBackground(Color.red);
                tile[i][j].repaint();
            }

            }

    }
    //======================================================================================================================//
    private void disableAllSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile[i][j].setEnabled(false);
            }
        }
    }
    //=================================================================//
    public boolean CanGetKingOutofCheck(King king) {
        // Get the army color of the king
        Color armyColor = king.getColor();

        // Simulate all possible moves of the army's pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = tile[i][j].getPiece();
                if (piece.getColor() == armyColor) {
                    // Check if the piece can move to get the king out of check
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (piece.isMoveValid(x, y)) {
                                // Try the move
                                int pieceOldX = piece.getX();
                                int pieceOldY = piece.getY();
                                Color pieceOldColor = piece.getColor();
                                Color my_color = tile[x][y].getColor();
                                piece.setX(x);
                                piece.setY(y);
                                piece.setColor(null);
                                tile[x][y].getPiece().setColor(pieceOldColor);

                                // Check if the king is out of check
                                if (!king.IsinItCheck(tile)) {
                                    // Reset the piece's position and return true
                                    piece.setX(pieceOldX);
                                    piece.setY(pieceOldY);
                                    piece.setColor(pieceOldColor);
                                    tile[x][y].getPiece().setColor(my_color);
                                    return true;
                                }

                                // Reset the piece's position
                                piece.setX(pieceOldX);
                                piece.setY(pieceOldY);
                                piece.setColor(pieceOldColor);
                                tile[x][y].getPiece().setColor(my_color);
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    //========================================================================//
    public boolean Stalemate() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(tile[i][j].getPiece() instanceof  Null)){
                    sum ++;
                }
            }
        }
        if (sum == 2)
            return true;
        if (sum ==3 )
        {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tile[i][j].getPiece() instanceof Bishop
                            || tile[i][j].getPiece() instanceof Knight) {
                        return true;
                    }
                }
            }
        }
        return false;

    }






    public static JPanel getChessBoard() {
        return chessBoard;
    }
}