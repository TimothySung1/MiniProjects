package basic;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		switch (num) {
		case 1:
			System.out.println("gang1");
			break;
		case 2:
			System.out.println("gang2");
			break;
		default:
			System.out.println("gang all");
		}
	}

}
