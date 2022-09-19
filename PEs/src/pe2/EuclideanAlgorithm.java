package pe2;

public class EuclideanAlgorithm {
	public static void main(String[] args) {
		int num1 = 396;
		int num2 = 450;
		int steps = 0;
		int dividend = num1;
		int divisor = num2;
		int gcd, quotient, remainder;
		System.out.printf("Finding the greatest common divisor of %d and %d.\n", num1, num2);
		if (divisor > dividend) {
			System.out.println("The inputs would have caused an unnecessary step.");
			int temp = divisor;
			divisor = dividend;
			dividend = temp;
		}
		else {
			System.out.println("An extra step was avoided.");
		}
		do {
			steps++;
			quotient = dividend / divisor;
			remainder = dividend % divisor;
			System.out.printf("Step %d: %d = %d * %d + %d\n", steps, dividend, divisor, quotient, remainder);
			gcd = divisor;
			dividend = divisor;
			divisor = remainder;
		} while (remainder != 0);
		System.out.println("The GCD is " + gcd);
		switch (steps) {
			case 1:
				System.out.println("Only one step was needed!");
				break;
			case 2:
				System.out.println("Two steps were taken!");
				break;
			case 3:
				System.out.println("This process took three steps.");
				break;
			case 4:
				System.out.println("Wow! Four steps.");
				break;
			default:
				System.out.println(steps + " steps is a lot of steps!");
		}
		System.out.printf("%d and %d are %srelatively prime.", num1, num2, (gcd == 1) ? "" : "not ");
	}
}
