import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class labyrinth3d {
	static int layers;
	static int rows;
	static int cols;
	static boolean escaped;
	static int time = -1;

	private static void printLabyrinth(char[][][] labyrinth) {
		//System.out.println(layers + " " + rows + " " + cols);
		for (int layer = 0; layer < layers; layer++) {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					System.out.print(labyrinth[layer][row][col]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static void search(int layer, int row, int col, char[][][] labyrinth, int cur_time, int prev_layer, int prev_row, int prev_col) {
		
		
		
		//check if escaped
		if (labyrinth[layer][row][col] == 'E') {
			escaped = true;
			if (time < 0) {
				time = cur_time;
			}
			else if (cur_time < time) {
				time = cur_time;
			}
		}
		//check possible movements, layer, row, col
		//make sure dont go in a loop, back and forth
		
		//check layer
		if (layer + 1 < layers) {
			if (labyrinth[layer + 1][row][col] != '#' && layer + 1 != prev_layer) {
				search(layer + 1, row, col, labyrinth, cur_time + 1, layer, row, col);
			}
		}
		
		if (layer - 1 >= 0) {
			if (labyrinth[layer - 1][row][col] != '#' && layer - 1 != prev_layer) {
				search(layer - 1, row, col, labyrinth, cur_time + 1, layer, row, col);
			}
		}
		
		//check row
		if (row + 1 < rows) {
			if (labyrinth[layer][row + 1][col] != '#' && row + 1 != prev_row) {
				search(layer, row + 1, col, labyrinth, cur_time + 1, layer, row, col);
			}
		}
		
		if (row - 1 >= 0) {
			if (labyrinth[layer][row - 1][col] != '#' && row - 1 != prev_row) {
				search(layer, row - 1, col, labyrinth, cur_time + 1, layer, row, col);
			}
		}
		
		//check col
		if (col + 1 < cols) {
			if (labyrinth[layer][row][col + 1] != '#' && col + 1 != prev_col) {
				search(layer, row, col + 1, labyrinth, cur_time + 1, layer, row, col);
			}
		}
		
		if (col - 1 >= 0) {
			if (labyrinth[layer][row][col - 1] != '#' && col - 1 != prev_col) {
				search(layer, row, col - 1, labyrinth, cur_time + 1, layer, row, col);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("labyrinth.txt");
		Scanner scanner = new Scanner(file);
		layers = scanner.nextInt();
		rows = scanner.nextInt();
		cols = scanner.nextInt();
		scanner.nextLine();
		
		//System.out.println(layers + " " + rows + " " + cols);
		//k n m
		char[][][] labyrinth = new char[layers][rows][cols];
		
		//run for as many layers; input
		for (int layer = 0; layer < layers; layer++) {
			//2x2 grid (rows and cols)
			for (int row = 0; row < rows; row++) {
				String stringrow = scanner.nextLine();
				//System.out.println("Stringrow " + stringrow);
				for (int col = 0; col < cols; col++) {
					labyrinth[layer][row][col] = stringrow.charAt(col);
				}
			}
		}
		
		printLabyrinth(labyrinth);
		//find S
		for (int layer = 0; layer < layers; layer++) {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					if (labyrinth[layer][row][col] == 'S') {
						int[] start = new int[3];
						start[0] = layer;
						start[1] = row;
						start[2] = col;
						search(layer, row, col, labyrinth, 0, layer, row, col);
					}
				}
			}
		}
		if (escaped) {
			System.out.println("Escaped in " + time + " minute(s).");
		}
		else {
			System.out.println("Trapped!");
		}
		//printLabyrinth(labyrinth);
		
	}

}
