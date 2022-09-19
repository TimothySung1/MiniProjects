package test;

public class Super {
	private int num;
	protected boolean accessible;
	protected static boolean access2;
	
	public Super(int num) {
		this.num = num;
		this.accessible = true;
	}
	
	public Super() {
		this.num = 0;
		this.accessible = true;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
}
