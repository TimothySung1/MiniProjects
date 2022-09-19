package comparatorpractice;

public class ThingCompared implements Comparable<ThingCompared>{
	
	private int someValue;
	
	public int getValue() {
		return this.someValue;
	}
	
	@Override
	public int compareTo(ThingCompared other) {
		return this.someValue - other.getValue();
	}
	
}
