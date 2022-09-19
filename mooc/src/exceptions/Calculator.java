package exceptions;

public class Calculator {
	
	public static int factorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Factorial should have a non-negative parameter");
		}
		int fact = 1;
		while (number > 0) {
			fact = fact * number;
			number--;
		}
		return fact;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(4));
		System.out.println(factorial(-1));
	}

}
