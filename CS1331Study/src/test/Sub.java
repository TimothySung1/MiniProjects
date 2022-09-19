package test;

public class Sub extends Super{
	private String name;
	
	public Sub(int num, String name) {
		super(num);
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name + " " + String.valueOf(super.getNum());
	}
	
	//accessible is a protected variable
	public boolean getAccessible() {
		boolean thi = super.accessible;
		boolean thi2 = Super.access2;
		return accessible;
	}
	
}
