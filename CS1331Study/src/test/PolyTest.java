package test;

public class PolyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super sup = new Super(2);
		Super sub = new Sub(2, "me");
		
		System.out.println(sub);
		System.out.println((Sub) sub);
		
		Object maggie = new Kitten("Maggie");
		Object fiona = new Kitten("Fiona");
		Object fiona2 = new Kitten("Fiona");
		
		System.out.println(maggie.toString());
		System.out.println(fiona.equals(maggie));
	}

}
