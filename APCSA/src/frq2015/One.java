package frq2015;

public class One {
	public static int arraySum(int[] array) {
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
		return sum;
	}
	
	public static int[] rowSums(int[][] arr2D) {
		int[] rows = new int[arr2D.length];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = arraySum(arr2D[i]);
		}
		return rows;
	}
	
	public static boolean isDiverse(int[][] arr2D) {
		int[] sumrow = rowSums(arr2D);
		for (int i = 0; i < sumrow.length; i++) {
			for (int j = i + 1; j < sumrow.length; j++) {
				if (sumrow[i] == sumrow[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
