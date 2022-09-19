import java.util.Scanner;

public class Scantest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What it do");
		String reply = scanner.nextLine();
		int number = scanner.nextInt();
		System.out.println(reply);
		System.out.println(number);
	}
}
