package test;

import java.util.Random;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fruit1 = "Pear";
		String fruit2 = "Pear";
		String fruit3 = new String("Pear");
		System.out.println(fruit1 == fruit2);
		System.out.println(fruit2 == fruit3);
		System.out.println(fruit2.equals(fruit3));
		String myString = "33333";
		myString.replace("3", "e");
		System.out.println(myString);
		
		/*Scanner myScanner = new Scanner(System.in); 
		String dataOne = myScanner.next();
		String dataTwo = myScanner.nextLine();
		System.out.println(dataOne);
		System.out.println(dataTwo);
		*/
		Random rand = new Random();
		System.out.println(rand.nextInt(10) + 1);
		System.out.printf("%s\n %3.1f", "The total is:", .29);
	}

}
