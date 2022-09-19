
public class MathPractice {

	public static void main(String[] args) {
		
		double absNeg12 = Math.abs(-12);
		System.out.println("The absolute value of -12: " + absNeg12);
		
		double number = Math.abs(-3.5);
		System.out.println("The absolute value of -3.5: " + number);
		
		int number2 = (int) Math.abs(-2.5);
		System.out.println("The absolute value of -2.5 as an int is: " + number2);
		
		double eightPowerThree = Math.pow(8, 3.5);
		System.out.println("8 to the power of 3.5 is: " + eightPowerThree);
		
		int number3 = (int) Math.pow(4, 3);
		System.out.println("4 to the power of 3 as an int is: " + number3);
		
		double sqrt = Math.sqrt(24.5);
		System.out.println("The square root of 24.5 is: " + sqrt);
		
		double sqrt127 = Math.sqrt(-127);
		System.out.println("The square root of -127 is: " + sqrt127);
	}

}
