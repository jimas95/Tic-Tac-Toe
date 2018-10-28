import java.util.Scanner;

public class Main {
	
	private static Scanner systIn;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// Create game and initialize it.
// First player will be 'x'
		Tictactoe game = new Tictactoe();
		
		
// Lets print the board
		game.printBoard();
		systIn = new Scanner(System.in);
		int x = 0,y=0;
while ((!game.checkForWin()) && (!game.isBoardFull())){
	String input = systIn.nextLine();
	
	if(game.checkInput(input)){
		switch(input.charAt(0)){
		case('a') : x = 0 ; break ;
		case('b') : x = 1 ; break ;
		case('c') : x = 2 ; break ;
		}
		switch(input.charAt(1)){
		case('1') : y = 0 ; break ;
		case('2') : y = 1 ; break ;
		case('3') :  y = 2 ; break ;
		}
		if(game.placeMark(x, y)){
			if ((game.checkForWin()) || (game.isBoardFull())){
				break;
			}
			game.changePlayer();
			game.ComputerPlay();
			game.printBoard();
		}
		else{
			System.out.println("Place already taken, play again");
		}
	}
	
	

}
game.printBoard();

		
		
// Did we have a winner?
		if (game.checkForWin()) {
		   System.out.println("We have a winner! Congrats!");
		   System.exit(0);
		}
		else if (game.isBoardFull()) {
			   System.out.println("Appears we have a draw!");
			   System.exit(0);
	}

// No winner or draw, switch players to 'o'
		game.changePlayer();
}
	
	

	
	
	
	
	
	
	
	
}
