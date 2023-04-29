
// timer, player name, score and board will be added here 

package chessGame;

public class GameView {{
	
	//Counter is added
	//new Counter();
	
	//Board display
	Frame frame = new Frame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

    // Create the chessboard
    ChessBoard chessBoard = new ChessBoard();

    // Add the chessboard to the frame
    frame.getContentPane().add(chessBoard.getChessBoard());

}}
