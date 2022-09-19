package multithreading;

public class Main implements Runnable{
	int[] array;
	int sum = 0;
	int id;
	
	public Main(int id, int[] array) {
		this.id = id;
		this.array = array;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		for (int i = 0; i < 3; i++) {
			num++;
			System.out.println(id + ": " + num);
		}
		*/
		int chunk = this.id * 100;
		add(chunk);
		//System.out.println(sum);
	}
	
	public synchronized void add(int chunk) {
		for (int i = chunk - 100; i < chunk; i++) {
			sum += array[i];
		}
		System.out.println(id + ": " + sum);
	}
	
	public int getSum() {
		return sum;
	}
	
}
