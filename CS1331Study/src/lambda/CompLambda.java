package lambda;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class CompLambda {
	
	public static void main(String[] args) {
		// returns int, .compare(one, two)
		Comparator<String> stringcomp = (s1, s2) -> s1.compareTo(s2);
		
		Comparator<String> stringcomp2 = Comparator.comparing(String::hashCode).thenComparing(String::hashCode);
		
		//function is a functional interface that turns the first value (string) and returns the second (integer), method name is .apply()
		Function<String, Integer> stringtoint = (s) -> Integer.valueOf(s);
		
		//predicate is a functional interface that tests the value (string) and returns a boolean, .test()
		Predicate<String> stringtest = (s3) -> s3.equals("something");
		
		//predicate and function are also functional interfaces
	}
	
}
