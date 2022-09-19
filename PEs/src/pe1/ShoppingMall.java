package pe1;

//Timothy Sung, I failed the 1331 exam :)

public class ShoppingMall {
	public static void main(String[] args) {
		String name = "Oswald";
		int cash = 100;
		double taxRate = 0.13;
		double subtotal = 58.62;
		
		double change = cash - ((1 + taxRate) * subtotal);
		change = ((int) (change * 100)) / 100.0;
		System.out.println(name + " has $" + change + " dollars remaining!\n"
				+ name + " started with $" + cash + " dollars!");
	}
}
