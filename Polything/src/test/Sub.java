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
}
