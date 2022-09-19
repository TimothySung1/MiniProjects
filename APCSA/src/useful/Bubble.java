package useful;

public class Bubble {
	static void bubbleSort(int[] arr) {
		boolean swap = true;
		while (swap) {
			swap = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swap = true;
				}
			}
			printArray(arr);
		}
	}
	
	static void printArray(int[] arr) {
		for (int ints : arr) {
			System.out.print(ints + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {0, -20, 5, -15, 3, 7, 12, 2};
		bubbleSort(arr);
	}
}
