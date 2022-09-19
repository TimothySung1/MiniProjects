package useful;

public class Selection {
	static void selectionSort(int[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[index] = temp;
			printArray(arr);
			
		}
	}
	
	static void printArray(int[] arr) {
		for (int integer : arr) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {-10, 20, 5, 3, 16, 0, -5};
		selectionSort(array);
		printArray(array);
		
	}
}
