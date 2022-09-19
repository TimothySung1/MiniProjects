package collections;

import java.util.Scanner;

public class RegularExpressions {
	
	public static boolean isDayOfWeek(String string) {
		if (string.matches("(mon|tue|wed|thu|fri|sat|sun|)")) {
			return true;
		}
		return false;
	}
	
	public static boolean allVowels(String string) {
		return string.matches("(a|e|i|o|u)+");
	}

	public static boolean timeOfDay(String string) {
		return string.matches("([2][0-4]|[0-1][0-9])((:)([0-5][0-9])){2}");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Alternation, the | means that the string must be exactly one of the options.
		String string = "1111";
		if (string.matches("00|111|0000")) {
		    System.out.println("The string contained one of the three alternatives");
		} else {
		    System.out.println("The string contained none of the three alternatives");
		}
		
		//Parentheses, specific character/part of string..
		String car = "car";
		if (car.matches("car(|s|)")) {
			System.out.println("Plural or singular car.");
		}
		
		//quantifier + repeats 1 or more times, * repeats 0 or more times, ? repeats 0 or 1 times
		//{a} repeats a times, {a, b} repeats a to b times, {a,} repeats a or more times.
		
		//brackets/character classes. [145] means (1|4|5) [2-36-9] means (2|3|6|7|8|9).
		//[a-c]* defines regular expression that requires string to contain only a b and c.
		
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("Enter a day: ");
		String day = scanner.next();
		if (isDayOfWeek(day)) {
			System.out.println("This form is correct.");
		}
		else {
			System.out.println("This form is incorrect.");
		}
		
		System.out.println("Enter a word: ");
		String word = scanner.next();
		if (allVowels(word)) {
			System.out.println("This form is correct.");
		}
		else {
			System.out.println("This form is incorrect.");
		}
		*/
		
		System.out.println("Enter a time: ");
		String time = scanner.next();
		if (timeOfDay(time)) {
			System.out.println("This form is correct.");
		}
		else {
			System.out.println("This form is incorrect.");
		}
	}

}
