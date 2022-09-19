import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class bus {

	private static void getNicest(int[] niceness) {
		boolean overrated = true;
		for (int i = 0; i < niceness.length; i++) {
			if (niceness[i] > 0) {
				overrated = false;
			}
		}
		if (overrated) {
			System.out.println("Yet another overrated tourist destination");
		}
		
		
		int end = niceness.length - 1;
		int max = 0;
		
		int startstop = 0;
		int endstop = 0;
		for (int i = 0; i < niceness.length; i++) {
			for (int j = end; j >= 0; j--) {
				int tempmax = 0;
				for (int start = i; start <= j; start++) {
					tempmax += niceness[start];
				}
				System.out.println("i " + i + " j " + j);
				System.out.println("tempmax " + tempmax);
				if (tempmax > max) {
					max = tempmax;
					startstop = i;
					endstop = j;
				}
				if (tempmax == max) {
					if ((j - i) > (endstop - startstop)) {
						startstop = i;
						endstop = j;
					}
					if ((j - i) == (endstop - startstop)) {
						if (i < startstop) {
							startstop = i;
							endstop = j;
						}
					}
				}
				
				
			}
		}
		startstop++;
		endstop += 2;
		System.out.println("The nicest part of Y1 is between stops " + startstop + " and " + endstop);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("bus.txt");
		Scanner scanner = new Scanner(file);
		int numstops = scanner.nextInt();
		int[] niceness = new int[numstops - 1];
		for (int i = 0; i < numstops - 1; i++) {
			niceness[i] = scanner.nextInt();
		}
		
		getNicest(niceness);
	}

}
