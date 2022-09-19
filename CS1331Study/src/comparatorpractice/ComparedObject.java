package comparatorpractice;

public class ComparedObject implements Comparable{
	
	private int value;
	
	public ComparedObject(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Object other) {
		if (other == null) {
			return 1;
		}
		if (!(other instanceof ComparedObject)) {
			return 1;
		}
		ComparedObject that = (ComparedObject) other;
		return (getValue() - that.getValue());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
