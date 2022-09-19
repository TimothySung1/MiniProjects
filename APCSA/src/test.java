import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void thing() {
		int x = 0;
	}
	
	public static void main(String[] args) {
		if (true && false || true) {
			System.out.println("yee");
		}
		
		if (true || false && true) {
			System.out.println("yee2");
		}
		
		if (true || false && true && true) {
			System.out.println("yee3");
		}
		
		int a = 5;
		int b = 4;
		
		System.out.println(-a * 1.0 /b);
		
		double base = 10 + 1.1 * 60;
		System.out.println(base);
		
		/*
		String bruh = "something";
		System.out.println(bruh.substring(3, 10));
		*/
		Parent p1 = new Child();
		p1.m1();
		
		ArrayList<String> arrList = new ArrayList<String>();

		arrList.add("A");

		arrList.add("B");

		arrList.add("C");

		arrList.add("D");

		for (int i = 0; i < arrList.size(); i++)

		{

			System.out.print(arrList.remove(i));

		}
		
		ArrayList<String> words = new ArrayList<String>();

		words.add("mat");

		words.add("new");

		words.add("open");

		words.add("pet");

		int i = 0;

		while (i < words.size())

		{

			words.remove(i);
	
			i++;

		}
		System.out.println();
		System.out.println(words.toString());
		
		System.out.println(words.add("test"));
		
		/*
		ExampleObject obj1 = new ExampleObject(1);
		ExampleObject obj2 = new ExampleObject(2);
		
		obj1 = obj2;
		obj2.setNum(3);
		System.out.println(obj1.getNum());
		System.out.println(obj2.getNum());
		*/
	}

}
