package useful;

public class SubClass extends SuperClass{
	
	int anotherCounter;
	
	public SubClass() {
		super();
		anotherCounter = 1;
	}
	
	public String toString() {
		return "SubClass";
	}
	
	public void subClassMethod() {
		System.out.println("Sub method");
	}
	
	public void method() {
		System.out.println("Sub class method");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClass[] array = new SuperClass[2];
		array[0] = new SubClass();
		array[1] = new SuperClass();
		
		SuperClass thing = new SubClass();
		System.out.println(thing);
		thing.method();
		
		//thing cannot do .subClassMethod()
	}

}
