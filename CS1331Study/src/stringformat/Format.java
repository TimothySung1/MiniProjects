package stringformat;

public class Format {
	
	public static void main(String[] args) {
		String thing = String.format("%s thing %s %s", "hi", "after", "last");
		System.out.println(thing);
		double pi = Math.PI;
		String math = String.format("%.2f 2 decimal", pi);
		System.out.println(math);
		
		System.out.printf("%5d 5 before int%n", 10);
		
		double num = (double) 3f / 4f;
		System.out.println(num);
		float num1 = 3f/4f;
		System.out.println(num1);
		
		float num2 = 3f / 4;
		System.out.println(num2);
		
		double num3 = 4.0f - 3.0 * 2;
		System.out.println(num3);
	}
	
}
