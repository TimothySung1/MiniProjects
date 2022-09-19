package collections;

import java.util.ArrayList;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		//String builder reduces number of strings created, string creation takes space.
		
		//this creates 7 strings
		ArrayList<String> words = new ArrayList<>();
		words.add("first");
		words.add("second");
		words.add("third");

		String connectedString = "";
		for (int i = 0; i < words.size(); i++) {
		    connectedString = connectedString + words.get(i);
		}
		System.out.println(connectedString);
		
		//this creates 4 strings
		ArrayList<String> words2= new ArrayList<>();
		words.add("first");
		words.add("second");
		words.add("third");

		StringBuilder connectedString2 = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
		    connectedString2.append(words.get(i));
		}
		System.out.println(connectedString.toString());
	}

}
