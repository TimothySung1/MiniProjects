package HashingAnagrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	final Integer[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	Map<Character, Integer> letterTable;
	Map<Long, ArrayList<String>> anagramTable;
	
	public Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long, ArrayList<String>>();
	}
	
	private void buildLetterTable() {
		letterTable = new HashMap<Character, Integer>();
		Character letter = 'a';
		for (Integer prime : PRIMES) {
			letterTable.put(letter, prime);
			letter++;
		}
	}
	
	private void addWord(String s) {
		Long hash = myHashCode(s);
		if (anagramTable.containsKey(hash)) {
			anagramTable.get(hash).add(s);
		}
		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(s);
			anagramTable.put(hash, list);
		}
		
	}
	
	private Long myHashCode(String s) {
		//multiplying primes associated to characters means anagrams have same hash code.
		long hash = 1;
		for (char letter : s.toCharArray()) {
			hash *= PRIMES[letter - 97];
		}
		return hash;
	}
	
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
	}
	
	private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
		ArrayList<Map.Entry<Long, ArrayList<String>>> list = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		int max = 0;
		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
			if (entry.getValue().size() > max) {
				list.clear();
				max = entry.getValue().size();
				list.add(entry);
			}
			
			else if (entry.getValue().size() == max) {
				list.add(entry);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		try {
		a.processFile ("words_alpha.txt");
		} catch ( IOException e1 ) {
		e1.printStackTrace ();
		}
		ArrayList < Map.Entry < Long , ArrayList < String >>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime () - startTime;
		final double seconds = (( double ) estimatedTime / 1000000000 ) ;
		System.out.println ( "Time : "+ seconds );
		System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey());
		System.out.println ( "List of max anagrams : "+ maxEntries );
		System.out.println("Length of list of max anagrams: " + maxEntries.get(0).getValue().size());
	}

}
