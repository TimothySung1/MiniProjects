package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
	HashMap<String, String> dict;
	String file;
	
	public SaveableDictionary() {
		this.dict = new HashMap<>();
	}
	
	public SaveableDictionary(String file) {
		this.dict = new HashMap<>();
		this.file = file;
	}
	
	public boolean load() {
		try {
			File file2 = new File(file);
			Scanner fileReader = new Scanner(file2);
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] parts = line.split(":");
				
				dict.put(parts[0], parts[1]);
				
				
			} 
		return true;
		} catch (Exception e){
			return false;
		}
		
	}
	
	public void add(String words, String translation) {
		if (!dict.containsKey(words)) {
			dict.put(words, translation);
		}
		
	}
	
	public String translate(String word) {
		if (dict.containsKey(word)) {
			return dict.get(word);
		}
		if (dict.containsValue(word)) {
			for (String key : dict.keySet()) {
				if (dict.get(key).equals(word)) {
					return key;
				}
			}
		}
		return null;
	}
	
	public void delete(String word) {
		if (dict.containsKey(word)) {
			dict.remove(word);
		}
		if (dict.containsValue(word)) {
			String key1 = "";
			for (String key : dict.keySet()) {
				if (dict.get(key).equals(word)) {
					key1 = key;
					break;
				}
			}
			dict.remove(key1);
		}
	}
	
	public boolean save() throws IOException{
		try {
			PrintWriter writer = new PrintWriter(this.file);
			for (String key : this.dict.keySet()) {
				
				writer.println(key + ":" + dict.get(key));
			}
			writer.close();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		SaveableDictionary dictionary = new SaveableDictionary("words.txt");
		boolean wasSuccessful = dictionary.load();

		if (wasSuccessful) {
		    System.out.println("Successfully loaded the dictionary from file");
		}

		System.out.println(dictionary.translate("apina"));
		System.out.println(dictionary.translate("ohjelmointi"));
		System.out.println(dictionary.translate("alla oleva"));
		
		dictionary.add("tietokone", "computer");
		dictionary.save();
	}
	
}
