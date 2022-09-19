package comparatorpractice;

import java.util.Comparator;

public class ThingComparator implements Comparator<ThingCompared>{
	
	@Override
	public int compare(ThingCompared thes, ThingCompared that) {
		return thes.compareTo(that);
	}
	
}
