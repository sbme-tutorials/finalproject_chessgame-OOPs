package chessGame;

public class Main {

	public static void main(String[] args){
		
		//new GameView();
		IDandPassword idandpassword = new IDandPassword();

        LoginPage loginpage  = new LoginPage(idandpassword.getLoginInfo());

		
	}

}

