package functionalinterfaces;

import java.util.Comparator;

public class Stuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);
		
		Comparator<String> comp2 = Comparator.comparing(String::hashCode);
		
		String s1 = "string";
		
	}

}
