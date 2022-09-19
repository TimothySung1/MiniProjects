package multithreading;

public class Driver {
	
	public static void main(String[] args) throws InterruptedException {
		int total = 0;
		int[] array = new int[1000];
		for (int i = 1; i < 1001; i++) {
			array[i - 1] = i;
		}
		Main[] mainArray = new Main[10];
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			Main main = new Main(i + 1, array);
			threadArray[i] = new Thread(main);
			mainArray[i] = main;
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].join();
		}
		for (int i = 0; i < 10; i++) {
			total += mainArray[i].getSum();
		}
		System.out.println(total);
	}
	
}
