package useful;

public class Insertion {
	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int curIndex = i;
			int curVal = arr[i];
			while (curIndex > 0 && curVal < arr[curIndex - 1]) {
				arr[curIndex] = arr[curIndex - 1];
				curIndex--;
			}
			arr[curIndex] = curVal;
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
		int[] array = {15, -10, 5, 9, -4, 0, 25};
		insertionSort(array);
		
	}
}
