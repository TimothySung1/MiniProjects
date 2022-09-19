import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class backtrack {
	
	//static int counter;
	static int start_row;
	static int start_col;
	static boolean solved;
	static char[][] solution = new char[9][9];
	public static boolean checkSafe(char number, int row, int col, char[][] grid) {
		//System.out.println("checksafe");
		//check rows and columns
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == number) {
				return false;
			}
			if (grid[i][col] == number) {
				return false;
			}
		}
		//System.out.println("checkSafe: Row: " + row + " Col: " + col);
		//check 3x3 subgrid
		char[][] subgrid = getSubGrid(row, col, grid);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (subgrid[i][j] == number) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static char[][] getSubGrid(int row, int col, char[][] grid){
		//System.out.println("getsubgrid");
		while(row % 3 != 0) {
			row--;
		}
		while(col % 3 != 0) {
			col--;
		}
		int tempcol = col;
		char[][] subgrid = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				//System.out.println("getSubGrid: Row: " + row + " Col: " + col);
				subgrid[i][j] = grid[row][col];
				col++;
			}
			col = tempcol;
			row++;
		}
		return subgrid;
	}
	private static void printPuzzle(char[][] grid, char[][] tempgrid) {
		System.out.println("Grid: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
				if (j == 2 || j == 5) {
					System.out.print("| ");
				}
			}
			if (i == 2 || i == 5) {
				System.out.println();
				System.out.println("----------------------");
			}
			else {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Solution: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(tempgrid[i][j] + " ");
				if (j == 2 || j == 5) {
					System.out.print("| ");
				}
			}
			if (i == 2 || i == 5) {
				System.out.println();
				System.out.println("----------------------");
			}
			else {
				System.out.println();
			}
		}
	}
	
	public static void backtrack(int row, int col, char[][] grid, char[][] tempgrid) {
		//System.out.println("Backtracking...");
		//System.out.println("row: " + row + " col: " + col);
		//System.out.println("backtrack: Row: " + row + " Col: " + col);
		
		if (row == 9 || solved) {
			if (checkSolved(tempgrid)) {
				//System.out.println("Solved");
				solved = true;
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						solution[i][j] = tempgrid[i][j];
					}
				}
				
			}
			return;
		}
		
		if (grid[row][col] != ' ') {
			//set row and col to next available/empty slot.
			
			for (int i = row; i < 9; i++) {
				for (int j = col; j < 9; j++) {
					//fix this-
					
					if (grid[i][j] == ' ') {
						row = i;
						col = j;
						break;
					}
					if (i == 8 && j == 8) {
						row = 9;
						break;
					}
					
					
					
				}
				
				if (row == 9) {
					backtrack(9, col, grid, tempgrid);
					return;
				}
				
				else if (grid[row][col] == ' ') {
					break;
				}
				else {
					col = 0;
				}
			}
			//System.out.println("new row: " + row + " new col: " + col);
		}
		
		for (char i = '1'; i <= '9'; i++) {
			if (checkSafe(i, row, col, tempgrid)) {
				
				tempgrid[row][col] = i;
				
				if (solved || (row == 8 && col == 8)) {
					backtrack(9, col, grid, tempgrid);
				}
				
				if (col < 8) {
					//printPuzzle(grid, tempgrid);
					backtrack(row, col + 1, grid, tempgrid);
					//counter++;
					
				}
				else {
					
					//printPuzzle(grid, tempgrid);
					backtrack(row + 1, 0, grid, tempgrid);
					//counter++;
				}
				
			}
			else {
				//System.out.println("UNSAFE. row: " + row + " col: " + col + " i: " + i);
			}
		}
		//System.out.println("does this run");
		if (grid[row][col] == ' ') {
			tempgrid[row][col] = ' ';
			//printPuzzle(grid, tempgrid);
			return;
		}
		
		
	}
	
	private static boolean checkSolved(char[][] tempgrid) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				if (tempgrid[i][j] == ' ') {
					return false;
				}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("sudoku.txt");
		Scanner scanner = new Scanner(file);
		char[][] grid = new char[9][9];
		for (int i = 0; i < 9; i++) {
			String row = scanner.nextLine();
			//char[] rowArray = row.toCharArray();
			//System.out.println(rowArray.length);
			//for (char character : rowArray) {
			//	System.out.print(character + " ");
			//}
			grid[i] = row.toCharArray();
		}
		
		
		char[][] tempgrid = new char[9][9];
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tempgrid[i][j] = grid[i][j];
			}
		}
		
		System.out.println("Before backtrack");
		printPuzzle(grid, tempgrid);
		
		boolean start = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == ' ') {
					start_row = i;
					start_col = j;
					backtrack(i, j, grid, tempgrid);
					start = true;
					break;
				}
			}
			if (start) {
				break;
			}
		}
		if (solved) {
			printPuzzle(grid, solution);
		}
		else {
			System.out.println("No solution");
		}
		
	}

}
