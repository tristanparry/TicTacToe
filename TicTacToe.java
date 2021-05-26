// IMPORT STATEMENTS
import java.util.Scanner; // Imports the Scanner class, and allows it to be used by Java

// MAIN PROGRAM CLASS
class TicTacToe {
  public static void main(String[] args) { // Auto-generated method stub for program to run
		
	// VARIABLE INITIALIZATION
	char[][] gameBoard = { {'-','-','-'} , {'-','-','-'} , {'-','-','-'} }; // Initializes/declares a new 2D Java character array with 3 rows and 3 columns. On starting the program, each cell in the 3x3 array contains the character '-' (as placeholders for game moves (Xs and Os)
	Scanner scan = new Scanner(System.in); // Initializes a new Scanner variable/object, used to recognize user inputs and store values in variables
	boolean xPlayer = true; // Initializes a new boolean variable/object, used to check which player's turn it is (xPlayer is initially set to true -> x goes first)
	int row, column; // Initializes 2 new int variables/objects, used to take user row and column position input for game moves
	int totalMoveCount = 0; // Initializes a new int variable/object, used as a counter to track the number of game moves (and later used to define game activity when the board is full)
	char winnerCharacter = '-'; // Initializes a new char variable/object, replaced later with the winning character, and used to print the winner to the user


	// GAME LOOP
	while (true) { // This while true loop will loop until forcibly broken out of
		// USER X INPUT (GAME MOVE)
		while (true) { // This while true loop will loop until forcibly broken out of
			if (xPlayer == true) { // If it is xPlayer's turn...
				System.out.print("X Player - Enter your row number [1, 2, or 3]: "); // Asks xPlayer for input on the row they would like to play in
			} else if (xPlayer == false) { // If it is oPlayer's turn...
				System.out.print("O Player - Enter your row number [1, 2, or 3]: "); // Asks oPlayer for input on the row they would like to play in
			}
			row = scan.nextInt() - 1; // Scans the user input, and stores the entered int value (-1 to match correctly with array indexes) in the row variable
			if (xPlayer == true) { // If it is xPlayer's turn...
				System.out.print("X Player - Enter your column number [1, 2, or 3]: "); // Asks xPlayer for input on the column they would like to play in
			} else if (xPlayer == false) { // If it is oPlayer's turn...
				System.out.print("O Player - Enter your column number [1, 2, or 3]: "); // Asks oPlayer for input on the column they would like to play in
			}
			column = scan.nextInt() - 1; // Scans the user input, and stores the entered int value (-1 to match correctly with array indexes) in the column variable

			if (row < 0 || row > 2 || column < 0 || column > 2) { // If the user chooses rows/columns that are out of range...
				System.out.println("Invalid input. Try again.\n"); // Print an error message to the user
				continue; // Restart the loop, allow the user to choose a different play
			} else if (gameBoard[row][column] == 'X' || gameBoard[row][column] == 'O') { // If there has already been a move on the chosen spot...
				System.out.println("Someone has made a move there already. Try again.\n"); // Print an error message to the user
				continue; // Restart the loop, allow the user to choose a different play
			} else { // If there was a valid move...
				break; // Break out of this inner while loop, continue the program with the next piece of code
			}
		}
		if (xPlayer == true) { // If it is xPlayer's turn/move...
			gameBoard[row][column] = 'X'; // Place an X in the move spot
		} else if (xPlayer == false) { // If it is oPlayer's turn/move...
			gameBoard[row][column] = 'O'; // Place an O in the move spot
		}

		totalMoveCount++; // Increment the totalMoveCount int variable by 1

		// REDRAW BOARD
		System.out.println("\n\n"); // Prints blank lines (cosmetic)
		for (int i = 0; i < 3; i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the number 3 (less than), and sets the variable to increment by 1 each loop iteration (for each row in the gameBoard)
			for (int j = 0; j < 3; j++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the number 3 (less than), and sets the variable to increment by 1 each loop iteration (for each column in the gameBoard)
				System.out.print(gameBoard[i][j] + " "); // Print the current iterated cell of the gameBoard array
			}
			System.out.print("\n"); // Prints blank line (cosmetic)
		}
		System.out.println("\n\n"); // Prints blank lines (cosmetic)


		// CHECK FOR WINNING ROWS/COLUMNS/DIAGONAL LINES			
		for (int i = 0; i < 3; i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the number 3 (less than), and sets the variable to increment by 1 each loop iteration (for each column in the gameBoard)
			if (gameBoard[0][i] != '-' && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) { // If each cell in the current column has the same character (X/O)...
				winnerCharacter = gameBoard[0][i]; // Make the winnerCharacter variable the character at the iterated cell
			}
		}
		for (int i = 0; i < 3; i++) { // Initializes a new for loop with an int variable/object, used to store int values. Compares the i value to the number 3 (less than), and sets the variable to increment by 1 each loop iteration (for each row in the gameBoard)
			if (gameBoard[i][0] != '-' && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) { // If each cell in the current row has the same character (X/O)...
				winnerCharacter = gameBoard[i][0]; // Make the winnerCharacter variable the character at the iterated cell
			}
		}
		if (gameBoard[0][0] != '-' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) { // If each cell in the current diagonal (1/2) has the same character (X/O)...
			winnerCharacter = gameBoard[0][0]; // Make the winnerCharacter variable the character at the iterated cell
		}
		if (gameBoard[0][2] != '-' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]) { // If each cell in the current diagonal (2/2) has the same character (X/O)...
			winnerCharacter = gameBoard[0][2]; // Make the winnerCharacter variable the character at the iterated cell
		}


		// CHECK WINNER BEFORE BREAKING
		if (winnerCharacter == 'X' || winnerCharacter == 'O') { // If there is a defined winning character (from the conditionals/loops above)...
			System.out.println("\n\n\nThe winner is: " + winnerCharacter); // Prints the winning player
			break; // Breaks out of the while true loop (this effectively ends the program, as there is no reachable code beyond the loop)
		} else { // Entered if all other conditionals cannot be satisfied
			// CHECK FOR FULL BOARD
			if (totalMoveCount == 9) { // If there have been 9 total moves...
				System.out.println("\n\n\nThe board is full. Tie."); // Print "tie" to the user(s), the board is full and no winner has been declared
				break; // Breaks out of the while true loop (this effectively ends the program, as there is no reachable code beyond the loop)
			} else if (totalMoveCount < 9) { // If there have been less than 9 total moves...
				xPlayer = !xPlayer; // Inverts the value of the player boolean variable (true -> false OR false -> true)
				continue; // Restarts the while true loop from the beginning
			}
		}
	}
	// CLOSE SCANNER
	scan.close(); // This optional line closes the scanner, not allowing it to accept any other input (this occurs after the loop has been exited)
  }
}
