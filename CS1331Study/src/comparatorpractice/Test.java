package comparatorpractice;

import java.util.Comparator;

public class Test {
	
	public static void test(Comparator<? extends Comparable> comp) {
		System.out.println("Wow");
	}
	
	public static void main(String[] args) {
		Comparator<ThingCompared> thing = 
				(ThingCompared huh, ThingCompared hah) -> huh.compareTo(hah);
				
		test(thing);
		
		ThingComparator that = new ThingComparator();
		test(that);
	}
	
}
