
public class Parent {
	public void m1() {
		System.out.print("pm1");
		m2();
	}
	
	public void m2() {
		System.out.print("pm2");
	}
	
	
	
}

class Child extends Parent{
	public void m1() {
		super.m1();
		System.out.print("cm1");
	}
	
	public void m2() {
		super.m2();
		System.out.print("cm2");
	}
}
