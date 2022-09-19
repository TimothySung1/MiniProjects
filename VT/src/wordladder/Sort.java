package wordladder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {

	public static void sortFile(File file) throws IOException {
		Scanner scanner = new Scanner(file);
		ArrayList<String> list = new ArrayList<String>();
		while (scanner.hasNext()) {
			list.add(scanner.next());
		}
		
		Collections.sort(list);
		
		File file2 = new File("SortedFiveLetterWords.txt");
		
		FileWriter writer = new FileWriter(file2);
		
		for (String string : list) {
			writer.write(string + "\n");
		}
		writer.close();
	}
	
	public static void sortFile2(File file) throws IOException {
		Scanner scanner = new Scanner(file);
		ArrayList<String> list = new ArrayList<String>();
		while (scanner.hasNext()) {
			list.add(scanner.next());
		}
		File file2 = new File("SortedFourLetterWords.txt");
		
		FileWriter writer = new FileWriter(file2);
		
		for (String string : list) {
			writer.write(string + "\n");
		}
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File four = new File("FourLetterWords.txt");
		//sortFile2(four);
		File five = new File("FiveLetterWords.txt");
		FileWriter writer = new FileWriter(five);
		Scanner scanner = new Scanner(five);
		while (scanner.hasNext()) {
			writer.write(scanner.next().toUpperCase());
		}
	}

}
