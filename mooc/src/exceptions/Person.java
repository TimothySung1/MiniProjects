package exceptions;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		if (name == "" || name == null || name.length() > 40) {
			throw new IllegalArgumentException("The name should be a string that is not over 40 characters in length.");
		}
		if (age < 0 || age > 120) {
			throw new IllegalArgumentException("The age should be between 0 and 120 years.");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Person guy = new Person(null, 12);
		//Person guy2 = new Person("", 0);
		//Person guy3 = new Person("yoo yoo", 200);
		Person guy4 = new Person("Timothy", 17);
	}

}
