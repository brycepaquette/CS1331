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
		// Create array to store location boards
		char[][][] locBoards = new char[2][5][5];
		int[] pScores = {0,0};
		
		System.out.println(welcomeMsg);

		// Get coordinates from P1 & P2 and create location board
		for (int i=0; i < 2; i++){
			int plyrNum = i + 1;
			System.out.printf("PLAYER %d, ENTER YOUR SHIP'S COORDINATES.\n", plyrNum);
			locBoards[i] = createLocationBoard(sc);
			printBattleShip(locBoards[i]);
			printLines(100);
		}		

		// Create Target History Boards to visually track player moves
		char[][][] tarBoards = {
			createCharArr(5, 5, noShip),
			createCharArr(5, 5, noShip)
		};

		
		while(pScores[0] != NUM_SHIPS && pScores[1] != NUM_SHIPS) {
			for (int i = 0; i < 2; i++) {
				if (pScores[0] == NUM_SHIPS || pScores[1] == NUM_SHIPS) {
					break;
				}
				int plyrNum = i + 1;
				int otherPlyrNum = (plyrNum == 1) ? 2 : 1;
				int otherPlyrIndex = (plyrNum == 1) ? 1 : 0;
				String hitInputMsg = String.format("Player %d, enter hit row/column: ", plyrNum);
				do {
					int[] xy = getCoordinates(sc, hitInputMsg);
					char value = tarBoards[i][xy[0]][xy[1]];
					boolean fired = (value == sunkShip || value == missedShip);
					if (fired) {
						System.out.println(firedErrMsg);
					}
					else {						
						boolean hit = locBoards[otherPlyrIndex][xy[0]][xy[1]] == bShip;
						if (hit) {
							pScores[i] += 1;
							tarBoards[i][xy[0]][xy[1]] = sunkShip;
							String hitMsg = String.format("PLAYER %d HIT PLAYER %d's SHIP!\n", plyrNum, otherPlyrNum);
							System.out.println(hitMsg);
						}
						else {
							tarBoards[i][xy[0]][xy[1]] = missedShip;
							String hitMsg = String.format("PLAYER %d MISSED!\n", plyrNum);
							System.out.println(hitMsg);
						}
						printBattleShip(tarBoards[i]);
						System.out.printf("P1 Score: %d --- P2 Score: %d\n", pScores[0], pScores[1]);
						break;
					}	
				} while (true);
			}			
		}
		int plyrwins = pScores[0] == 5 ? 1 : 2;
		System.out.printf("GAME OVER. PLAYER %d WINS!", plyrwins);
	}

	// Get hit coordinates from player
	public static int[] getCoordinates(Scanner sc, String msg) {
		int[] coorArr = new int[2];
		while (true) {
			// clears the scanner in the event more than 2 ints are provided
			sc.reset();
			System.out.print(msg);
			String[] xy = sc.nextLine().split(" ");
			int x = xy.length > 0 ? Integer.parseInt(xy[0]) : INVALID_INT;
			boolean xInvalid = x > upperBound || x < lowerBound || x == INVALID_INT;
			int y = xy.length > 1 ? Integer.parseInt(xy[1]) : INVALID_INT;
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