import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Optimized_Stack_Puzzle {
	public static void getSequences(String source, String target, List<String> sequences) {
		List<String> eligible = new ArrayList<String>();
		
		for (String sequence : sequences) {
			boolean works = true;
			char[] chars = sequence.toCharArray();
			int i = 0;
			int o = 0;
			for (char character : chars) {
				if (character == 'i') {
					i++;
				}
				else {
					o++;
				}
				if (i < o) {
					works = false;
					break;
				}
			}
			if (i == o && works) {
				eligible.add(sequence);
			}
			
		}
		//System.out.println("Eligible sequences: ");
		//System.out.println(eligible);
		
		char[] sourceword = source.toCharArray();
		char[] targetword = new char[target.length()];
		char[] targetarray = target.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		List<String> correctSequences = new ArrayList<String>();
		for (String sequence : eligible) {
			char[] chars = sequence.toCharArray();
			int j = 0;
			int k = 0;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == 'i') {
					stack.push(sourceword[j]);
					j++;
				}
				if (chars[i] == 'o') {
					targetword[k] = stack.peek();
					
					//~15-20ms
					if (targetword[k] != targetarray[k]) {
						break;
					}
					stack.pop();
					k++;
				}
			}
			//System.out.println("target word array");
			//System.out.println(targetword);
			
			
			
			if (new String(targetword).equals(target)) {
				correctSequences.add(sequence);
			}
			//System.out.println(sequence);
			//System.out.println(correctSequences);
		}
		/*
		System.out.println("[");
		for (String sequence : correctSequences) {
			System.out.println(sequence);
		}
		System.out.println("]");
		*/
	}
	
	public static void getCombinations(List<String> list, String sequence, String target) {
		if (sequence.length() == 2 * target.length()) {
			list.add(sequence);
		}
		else {
			getCombinations(list, sequence + "i", target);
			getCombinations(list, sequence + "o", target);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		File stackpuzzle = new File("stack.txt");
		Scanner scanner = new Scanner(stackpuzzle);
		String source = scanner.next();
		String target = scanner.next();
		List<String> sequences = new ArrayList<String>();
		String sequence = "i";
		if (source.length() == target.length()) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < 100; i++) {
				getCombinations(sequences, sequence, target);
			}
			long time2 = System.currentTimeMillis();
			//System.out.println(sequences);
			for (int i = 0; i < 100; i++) {
				getSequences(source, target, sequences);
			}
			long time3 = System.currentTimeMillis();
			
			System.out.println("Run getCombinations: ");
			long getCombTime = time2 - time1;
			System.out.println(getCombTime);
			
			long getSeqTime = time3 - time2;
			System.out.println("Run getSequences: ");
			System.out.println(getSeqTime);
			
			System.out.println("Run everything: " + (time3 - time1));
		}
		else {
			System.out.println("[");
			System.out.println("]");
		}
	}

}
