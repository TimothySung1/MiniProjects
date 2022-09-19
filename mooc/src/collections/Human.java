package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Comparable<Human>{
	private String name;
	private int wage;
	public Human(String name, int wage) {
		this.name = name;
		this.wage = wage;
	}
	
	public String toString() {
		return ("Name: " + name + "; Wage: " + wage);
	}
	
	public int compareTo(Human human) {
		return this.wage - human.getWage();
	}
	
	public int getWage() {
		return this.wage;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("guy1", 60));
		humans.add(new Human("guy2", 40));
		humans.add(new Human("guy3", 100));
		Collections.sort(humans);
		humans.stream().forEach(human -> System.out.println(human));
	}

}
