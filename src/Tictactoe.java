import java.util.*;

public class Tictactoe {
   private char [][] board;
   private char currentPlayer;  
   
   public Tictactoe() {
       board = new char[3][3];
       currentPlayer= 'X';/*Player X starts first*/
       initializeBoard();
   }
   
// Set/Reset the board back to all empty values.
    public void initializeBoard() {
	// Loop through rows
     for (int i = 0; i < 3; i++) {
    // Loop through columns
       for (int j = 0; j < 3; j++) {
          board[i][j] = ' ';
         }
       }
     }

 // Print the current board
    public void printBoard() {
        System.out.println("-------------");
		
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
 // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    
    public boolean isBoardFull() {
    	boolean isFull= true;
    	
    	for (int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			if(board[i][j]==' ') {
    				isFull=false;
    			}
    		}
    	}
		return isFull;
     }
 
 // Returns true if there is a win, false otherwise.
    public boolean checkForWin() {
    	
    	return(checkRowsForWin()||checkColumnsForWin()||checkDiagonalsForWin());
    }   
    
 // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
    	for (int i = 0; i < 3; i++) {
    		if(checkRowCol(board[i][0],board[i][1],board[i][2])) {
    			return true;
    		}
    	}
    	return false;
    }
    
 // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) ) {
                return true;
            }
        }
        return false;
    }
    
 // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
    
    
    
    

 // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return  ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }
    
// Change player marks back and forth.
    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }
 
    public void ComputerPlay(){
     int x = (int)Math.random()*3; 
     int y = (int)Math.random()*3;
     while(board[x][y]!=' ' ){
          x = (int)(Math.random()*3); 
          y = (int)(Math.random()*3);
     }
     placeMark(x, y);
     changePlayer();
     System.out.println("Computer played...");
    }
    
    
    
    
    public boolean checkInput(String move){
    	if(move.length()==2){
    		char one = move.charAt(0);
    		if(one=='a' || one=='b' ||one=='c'){
    			char two = move.charAt(1);
    			if(two=='1' || two=='2' || two=='3'){
    				return true ;
    			}
    		}
    	}
    	System.out.println("incompatble move plz try again");
    	return false ;
    }
 // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {
		// Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }
    
    
   }
   

   

