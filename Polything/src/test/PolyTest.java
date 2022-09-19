package test;

public class PolyTest {
	
	public static void test(Super thing) {
		System.out.println(thing.getNum());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super sup = new Super(2);
		Super sub = new Sub(2, "me");
		Sub sub2 = new Sub(3, "huh");
		
		System.out.println(sup);
		System.out.println(sub);
		System.out.println((Sub) sub);
		
		Object maggie = new Kitten("Maggie");
		Object fiona = new Kitten("Fiona");
		Object fiona2 = new Kitten("Fiona");
		
		System.out.println(maggie.toString());
		System.out.println(fiona.equals(maggie));
		
		test(sub);
		test(sub2);
	}

}
