import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class batch {
	
	private static void minimize(int tasks, int nodes, int[] times) {
		int sum = 0;
		for (int time : times) {
			sum += time;
		}
		int avg = sum / nodes;
		System.out.println(avg);
		int start = 0;
		int[] node_times = new int[nodes];
		for (int i = 0; i < nodes; i++) {
			int count = 0;
			for (int j = start; j < tasks; j++) {
				if (count + times[j] <= avg) {
					count += times[j];
				}
				
				else if (j == tasks - 1) {
					node_times[i] = j + 1;
					break;
				}
				else {
					start = j;
					node_times[i] = j;
					break;
				}
			}
		}
		start = 0;
		for (int i = 0; i < nodes; i++) {
			for (int j = start; j < node_times[i]; j++) {
				System.out.print(times[j] + " ");
			}
			System.out.print("/ ");
			start = node_times[i];
		}
	}
	
	public static void main(String[] args) throws IOException{
		File file = new File("batch.txt");
		Scanner scanner = new Scanner(file);
		int tasks = scanner.nextInt();
		int nodes = scanner.nextInt();
		scanner.nextLine();
		String[] stringtimes = scanner.nextLine().split(" ");
		int[] times = new int[tasks];
		for (int i = 0; i < tasks; i++) {
			times[i] = Integer.parseInt(stringtimes[i]);
		}
		minimize(tasks, nodes, times);
	}
}
