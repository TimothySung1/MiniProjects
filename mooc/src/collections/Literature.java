package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Literature {
	private String name;
	private int age;
	public Literature(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return getName() + " (recommended for " + getAge() + " year-olds or older)";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Literature> books = new ArrayList<>();
		while(true) {
			System.out.println("Input the name of the book, empty stops: ");
			String bookName = scanner.next();
			if(bookName.equals("empty")) {
				//System.out.println("empty");
				break;
			}
			System.out.println("Input the age recommendation: ");
			int recAge = scanner.nextInt();
			books.add(new Literature(bookName, recAge));
		}
		System.out.println(books.size() + " books in total.");
		
		System.out.println("Books:");
		Comparator<Literature> comparator = Comparator.comparing(Literature::getAge).thenComparing(Literature::getName);
		Collections.sort(books, comparator);

		for (Literature e: books) {
		    System.out.println(e);
		}
	}

}
