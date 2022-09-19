import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AwesomeNumber {
	
	private static void getAwesome(int number) {
		int start = 0;
		if (number % 10 == 1) {
			start = number;
		}
		else {
			while (true) {
				number--;
				if (number % 10 == 1) {
					start = number;
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		File awesome = new File("awesome.txt");
		Scanner scanner = new Scanner(awesome);
		int number = scanner.nextInt();
		getAwesome(number);
	}

}
