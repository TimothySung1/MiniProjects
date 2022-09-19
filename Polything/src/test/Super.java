package test;

public class Super {
	private int num;
	
	public Super(int num) {
		this.num = num;
	}
	
	public Super() {
		this.num = 0;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
}
