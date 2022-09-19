package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class stream {
	
	public static List<Integer> positive(List<Integer> numbers){
		List<Integer> posNums = numbers.stream()
				.filter(num -> num > 0)
				.collect(Collectors.toList());
		return posNums;
	}
	
	public static List<Integer> positive2(List<Integer> numbers){
		List<Integer> posNums = numbers.stream()
				.filter(num -> num > 0)
				.collect(Collectors.toCollection(ArrayList::new));
		return posNums;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<String>();
		while (true) {
			String next = scanner.next();
			if(next.equals("end")) {
				break;
			}
			inputs.add(next);
		}
		double average = inputs.stream()
				.mapToInt(x -> Integer.valueOf(x))
				.average()
				.getAsDouble();
		double posAverage = inputs.stream()
				.mapToInt(s -> Integer.valueOf(s))
				.filter(s -> s > 0)
				.average()
				.getAsDouble();
		double negAverage = inputs.stream()
				.mapToInt(s -> Integer.valueOf(s))
				.filter(s -> s < 0)
				.average()
				.getAsDouble();
		System.out.println("Average: " + average);
		System.out.println("Print out the average of positive or negative numbers? [n/p]");
		String decision = scanner.next();
		if (decision.equals("n")) {
			System.out.println("Negative average: " + negAverage);
		}
		else {
			System.out.println("Positive average: " + posAverage);
		}
		
	}

}
