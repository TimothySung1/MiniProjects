package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>{
	private String name;
	public Student(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Student student) {
		return name.compareToIgnoreCase(student.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		students.add(new Student("John"));
		students.add(new Student("Aaron"));
		students.add(new Student("Timothy"));
		students.add(new Student("Daniel"));
		Collections.sort(students);
		students.stream().forEach(s -> System.out.println(s));
	}

}
