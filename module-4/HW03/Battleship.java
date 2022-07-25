import java.util.Arrays;
import java.util.Scanner;
public class Battleship {
	static String invalidErrMsg = "Invalid coordinates. Choose different coordinates.";
	static String occupiedErrMsg = "You already have a ship there. Choose different coordinates.";
	static String firedErrMsg = "You already fired on this spot. Choose different coordinates.";
	static String welcomeMsg = "Welcome to Battleship!\n";
	static int NUM_SHIPS = 5;
	static int INVALID_INT = -1;
	static int upperBound = 4;
	static int lowerBound = 0;
	static char noShip = '-';
	static char bShip = '@';
	static char sunkShip = 'X';
	static char missedShip = 'O';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(welcomeMsg);

		// Get coordinates from P1 and create location board
		System.out.println("PLAYER 1, ENTER YOUR SHIP'S COORDINATES.");
		char[][] p1LocBoard = createLocationBoard(sc);
		printBattleShip(p1LocBoard);
		printLines(100);

		// Get coordinates from P2 and create location board
		System.out.println("PLAYER 2, ENTER YOUR SHIP'S COORDINATES.");
		char[][] p2LocBoard = createLocationBoard(sc);
		printBattleShip(p2LocBoard);
		printLines(100);

		// Create Target History Boards to visually track player moves
		char[][][] tarBoards = {
			createCharArr(5, 5, noShip),
			createCharArr(5, 5, noShip)
		};

		int[] pScores = {0,0};
		while(pScores[0] != NUM_SHIPS || pScores[1] != NUM_SHIPS) {
			for (int i = 1; i <=2; i++) {
				String hitMsg = String.format("Player %d, enter hit row/column: ", i);
				do {
					int[] coorArr = getCoordinates(sc, hitMsg);
					if (!validMove(coorArr, tarBoards[i-1])) {
						System.out.println(firedErrMsg);
					}
					
					x = coorArr[0];
					y = coorArr[1];
				} while (!validMove(coorArr, tarBoards[i-1]);
			}
			
		}
		
	}

	// validates coordinates are available to place ship/ make hit
	public static boolean validMove(int[] coorArr, char[][] board) {
		int x = coorArr[0];
		int y = coorArr[1];
		boolean firedSpot = board[x][y] == sunkShip || board[x][y] == missedShip; 
		return !firedSpot;
	}

	// Get hit coordinates from player
	public static int[] getCoordinates(Scanner sc, String msg) {
		int[] coorArr = new int[2];
		while (true) {
			// clears the scanner in the event more than 2 ints are provided
			sc.reset();
			System.out.print(msg);
			int x = sc.hasNextInt() ? sc.nextInt() : INVALID_INT;
			boolean xInvalid = x > upperBound || x < lowerBound || x == INVALID_INT;
			int y = !xInvalid && sc.hasNextInt() ? sc.nextInt() : INVALID_INT;
			boolean yInvalid = y > upperBound || y < lowerBound || y == INVALID_INT;
			if (xInvalid || yInvalid) {
				System.out.println(invalidErrMsg);
			}
			else {
				coorArr[0] = x;
				coorArr[1] = y;
				return coorArr;
			}
		}

	}
	
	// Initialize a 2D char array
	public static char[][] createCharArr(int rows, int cols, char symbol) {
		char[][] arr = new char[rows][cols];
		for(char[] row: arr) {
			Arrays.fill(row, symbol);
		}
		return arr;
	}

	// Print X blank lines
	public static void printLines(int x) {
		for (int i = 0; i < x; i++) {
			System.out.println("");
		}
	}
	// Method to get user input to initialize game
	public static char[][] createLocationBoard(Scanner sc) {
		
		// Declare and Initialize 2D array with '-'
		char[][] locBoard = createCharArr(5, 5, noShip);

		for (int i = 1; i <= NUM_SHIPS; i++) {
			int x = INVALID_INT;
			int y = INVALID_INT;
			boolean firstRun = true;
			String shipMsg = String.format("Enter ship %d location: ", i);
			do {
				if (!firstRun && locBoard[x][y] != '-') {
					System.out.println(occupiedErrMsg);
				}
				int[] coorArr = getCoordinates(sc, shipMsg);
				x = coorArr[0];
				y = coorArr[1];
				firstRun = false;
			} while (x == INVALID_INT || y == INVALID_INT || locBoard[x][y] != '-');
			locBoard[x][y] = bShip;	
		}
		return locBoard;
	}
	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}