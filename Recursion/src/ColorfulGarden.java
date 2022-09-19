import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ColorfulGarden {
	static int rows;
	static int cols;
	static boolean solved;
	static String[][] solution;
	
	private static void printSolution(String[][] solution) {
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	private static boolean checkColor(String color, int row, int col, List<Integer[]> descriptions, String[][] garden) {
		//check if the color works for that location.
		Integer[] row_condition = descriptions.get(row);
		Integer[] col_condition = descriptions.get(row + rows);
		int row_groups = row_condition[0];
		int col_groups = col_condition[0];
		if (row_groups == 1 || col_groups == 1) {
			return color.equals("B");
		}
		else {
			//col divided by 2 rounded up is total groups possible
		}
	}
	*/
	
	private static void printConditions(Integer[] condition) {
		System.out.println("print conditions");
		for (Integer num : condition) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	private static boolean checkGarden(List<Integer[]> descriptions, String[][] garden) {
		//System.out.println("Garden: ");
		//printSolution(garden);
		
		for (int row = 0; row < rows; row++) {
			Integer[] row_condition = descriptions.get(row);
			
			int row_groups = row_condition[0];
			
			//printConditions(row_condition);
			//printConditions(col_condition);
			
			//check rows first
			if (row_groups == 1 && row_condition[1] == cols) {
				for (String plant : garden[row]) {
					if (!plant.equals("B")) {
						return false;
					}
				}
			}
			
			//group is the number of groups in the row, size is the size of each group, sizes will compare sizes to input.
			int group = 0;
			int size = 0;
			List<Integer> sizes = new ArrayList<Integer>();
			if (row_groups > 1 || (row_groups == 1 && row_condition[1] != cols)) {
				for (int i = 0; i < garden[row].length; i++) {
					if (garden[row][i].equals("B")) {
						size ++;
					}
					if (garden[row][i].equals("r") && size > 0) {
						sizes.add(size);
						size = 0;
						group++;
					}
				}
				if (size > 0) {
					sizes.add(size);
					size = 0;
					group++;
				}
				
				//check if number of groups are the same
				if (group != row_groups) {
					return false;
				}
				
				//check if the size of groups are same.
				
				if (row_condition.length - 1 != sizes.size()) {
					return false;
				}
				List<Integer> row_condition_sizes = new ArrayList<Integer>();
				for (int i = 0; i < row_condition.length - 1; i++) {
					row_condition_sizes.add(row_condition[i + 1]);
				}
				if (!row_condition_sizes.equals(sizes)) {
					return false;
				}
				
			}
		}
		
		//check columns
		
		for (int col = 0; col < cols; col++) {
			Integer[] col_condition = descriptions.get(col + rows);
			
			int col_groups = col_condition[0];
			
			if (col_groups == 1 && col_condition[1] == rows) {
				for (int i = 0; i < rows; i++) {
					if (!garden[i][col].equals("B")) {
						return false;
					}
				}
			}
			
			int group = 0;
			int size = 0;
			List<Integer> sizes = new ArrayList<Integer>();
			if (col_groups > 1 || (col_groups == 1 && col_condition[1] != rows)) {
				for (int i = 0; i < rows; i++) {
					if (garden[i][col].equals("B")) {
						size ++;
					}
					if (garden[i][col].equals("r") && size > 0) {
						sizes.add(size);
						size = 0;
						group++;
					}
				}
				if (size > 0) {
					sizes.add(size);
					size = 0;
					group++;
				}
				
				//check if number of groups are the same
				if (group != col_groups) {
					return false;
				}
				
				//check if the size of groups are same.
				
				if (col_condition.length - 1 != sizes.size()) {
					return false;
				}
				List<Integer> col_condition_sizes = new ArrayList<Integer>();
				for (int i = 0; i < col_condition.length - 1; i++) {
					col_condition_sizes.add(col_condition[i + 1]);
				}
				if (!col_condition_sizes.equals(sizes)) {
					return false;
				}
				
			}
		}
		/*
		for (int col = 0; col < cols; col++) {
			Integer[] col_condition = descriptions.get(col + rows);
			printConditions(col_condition);
		}
		*/
		
		return true;
	}
	
	/*
	private static void backtrack(int row, int col, List<Integer[]> descriptions, String[][] garden) {
		if (row >= rows) {
			solved = true;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					solution[i][j] = garden[i][j];
				}
			}
			return;
		}
		
		//actual checking
		if (checkColor("B", row, col, descriptions, garden)) {
			garden[row][col] = "B";
			if (col == cols - 1) {
				backtrack(row + 1, 0, descriptions, garden);
			}
			else {
				backtrack(row, cols + 1, descriptions, garden);
			}
			
		}
		
		if (checkColor("r", row, col, descriptions, garden)) {
			garden[row][col] = "r";
			if (col == cols - 1) {
				backtrack(row + 1, 0, descriptions, garden);
			}
			else {
				backtrack(row, cols + 1, descriptions, garden);
			}
			
		}
		
		//no valid color, return
		return;
	}
	
	*/
	
	private static void backtrack(String[][] garden, List<Integer[]> descriptions, int row, int col) {
		if (row >= rows) {
			if (checkGarden(descriptions, garden)) {
				solved = true;
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						solution[i][j] = garden[i][j];
					}
				}
				
			}
			return;
		}
		
		
		else {
			garden[row][col] = "B";
			if (col == cols - 1) {
				backtrack(garden, descriptions, row + 1, 0);
			}
			else {
				backtrack(garden, descriptions, row, col + 1);
			}
			garden[row][col] = "r";
			if (col == cols - 1) {
				backtrack(garden, descriptions, row + 1, 0);
			}
			else {
				backtrack(garden, descriptions, row, col + 1);
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		File file = new File("colorful.txt");
		Scanner scanner = new Scanner(file);
		rows = scanner.nextInt();
		cols = scanner.nextInt();
		scanner.nextLine();
		List<Integer[]> descriptions = new ArrayList<Integer[]>();
		for (int i = 0; i < rows + cols; i ++) {
			String line[] = scanner.nextLine().split(" ");
			
			
			Integer[] numline = new Integer[line.length];
			for (int j = 0; j < line.length; j++) {
				numline[j] = Integer.parseInt(line[j]);
			}
			descriptions.add(numline);
			
		}
		/*
		for (int i = 0; i < rows + cols; i++) {
			for(Integer num : descriptions.get(i)) {
				System.out.print(num);
			}
			System.out.println();
		}
		*/
		String[][] garden = new String[rows][cols];
		solution = new String[rows][cols];
		backtrack(garden, descriptions, 0, 0);
		if (solved) {
			printSolution(solution);
		}
		else {
			System.out.println("No solution");
		}
	}
}
