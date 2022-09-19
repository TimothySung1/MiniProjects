package collections;

import java.util.ArrayList;

public class terminal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Integer> numbers = new ArrayList<>();
	        numbers.add(3);
	        numbers.add(2);
	        numbers.add(-17);
	        numbers.add(-5);
	        numbers.add(7);

	        

	        numbers.stream()
	                .forEach(num -> System.out.println(num));
	        
	        ArrayList<Integer> values = new ArrayList<>();
	        values.add(7);
	        values.add(3);
	        values.add(2);
	        values.add(1);

	        int sum = values.stream()
	            .reduce(0, (previousSum, value) -> previousSum + value);
	        System.out.println("sum: " + sum);
	        
	        ArrayList<String> words = new ArrayList<>();
	        words.add("First");
	        words.add("Second");
	        words.add("Third");
	        words.add("Fourth");

	        String combined = words.stream()
	            .reduce("", (previousString, word) -> previousString + word + "\n");
	        System.out.println(combined);
	}

}
