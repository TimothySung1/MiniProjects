package multiD;

import java.util.ArrayList;

public class MagicSquare {
	private int[][] square;
	public MagicSquare() {
		this.square = new int[3][3];
	}
	
	public ArrayList<Integer> sumsOfRows(){
		ArrayList<Integer> sums = new ArrayList<>();
		int rowsum;
		for (int i = 0; i < 3; i++) {
			rowsum = 0;
			for (int j = 0; j < 3; j++) {
				rowsum += square[i][j];
			}
			sums.add(rowsum);
		}
		return sums;
	}
	
	public ArrayList<Integer> sumsOfColumns(){
		ArrayList<Integer> sums = new ArrayList<>();
		int colsum;
		for (int i = 0; i < 3; i++) {
			colsum = 0;
			for (int j = 0; j < 3; j++) {
				colsum += square[j][i];
			}
			sums.add(colsum);
		}
		return sums;
	}
	public ArrayList<Integer> sumsOfDiagonals(){
		ArrayList<Integer> sums = new ArrayList<>();
		int diagsum = 0;
		int diagsum2 = 0;
		for (int i = 0; i < 3; i++) {
			diagsum += square[i][i];
			diagsum2 += square[i][3-i];
		}
		sums.add(diagsum);
		sums.add(diagsum2);
		return sums;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
