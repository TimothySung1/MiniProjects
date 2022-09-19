import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Train {
	
	public static boolean permute(int coaches, int[] order) {
		Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> b = new Queue<Integer>();
		Queue<Integer> a = new Queue<Integer>();
		
		for (int i = 0; i < coaches; i++) {
			a.enqueue(i + 1);
		}
		int seq = 0;
		
		while (!a.isEmpty()) {
			int car = a.peek();
			a.dequeue();
			s.push(car);
			if(s.peek() == order[seq]) {
				b.enqueue(s.peek());
				s.pop();
				seq++;
				while(!s.isEmpty()) {
					if(s.peek() == order[seq]) {
						b.enqueue(s.peek());
						s.pop();
						seq++;
					}
					else {
						break;
					}
				}
			}
			
			
		}
		if (s.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("train.txt");
		Scanner scanner = new Scanner(file);
		int cars = scanner.nextInt();
		boolean end = false;
		int car;
		while (true){
			int[] train = new int[cars];
			for (int i = 0; i < cars; i ++) {
				car = scanner.nextInt();
				//System.out.println("car: " + car);
				if(car == 0) {
					end = true;
					break;
				}
				train[i] = car;
			}
			if (end) {
				break;
			}
			if (permute(cars, train)) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

}
