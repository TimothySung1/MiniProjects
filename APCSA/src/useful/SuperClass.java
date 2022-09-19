package useful;

public class SuperClass {
	public int counter;
	public String thing;
	
	public SuperClass() {
		counter = 0;
		thing = "";
	}
	
	public void method() {
		System.out.println("Super class method");
	}
	
	public String toString() {
		return ("SuperClass");
	}
}
