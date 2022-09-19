package wordladder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordLadder {
	private static String beginning;
	private static String end;
	private static ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
	private static Queue<Stack<String>> ladders = new LinkedList<Stack<String>>();
	private static int wordlength;
	
	//return number of same letters in order
	public static int compareLetters(String word1, String word2) {
		int counter = 0;
		char[] word1CharArray = word1.toCharArray();
		char[] word2CharArray = word2.toCharArray();
		for (int i = 0; i < word2.length(); i++) {
			if (word1CharArray[i] == word2CharArray[i]) {
				counter++;
			}
		}
		return counter;
	}
	
	//get arraylist from stack
	public static ArrayList<String> toArrayList(Stack<String> ladder){
		ArrayList<String> solution = new ArrayList<String>();
		for (int i = 0; i < ladder.size(); i++) {
			solution.add(ladder.get(i));
		}
		
		
		//returns reverse currently
		return solution;
	}
	
	public static void find(String cur, ArrayList<String> wordlist) {
		//add start word to ladders
		Stack<String> singleLadder = new Stack<String>();
		singleLadder.add(cur);
		ladders.add(singleLadder);
		
		while (!ladders.isEmpty()) {
			//System.out.println(ladders.size());
			Stack<String> ladder = ladders.poll();
			//System.out.println(ladders.size());
			cur = ladder.peek();
			//if ladder reaches the end word
			if (cur.equals(end)) {
				//printStack(ladder);
				solutions.add(toArrayList(ladder));
				//return for shortest solution
				return;
			}
			else {
				addLadders(cur, wordlist, ladder);
			}
			
		}
	}
	
	public static void addLadders(String cur, ArrayList<String> wordlist, Stack<String> ladder){
		//get all similar words into an arraylist
		ArrayList<String> similarWords = new ArrayList<String>();
		for (String word : wordlist) {
			int similarity = compareLetters(cur, word);
			
			if (similarity == wordlength - 1 && !ladder.contains(word)) {
				similarWords.add(word);
			}
		}
		
		if (similarWords.size() == 0) {
			return;
		}
		
		//could add priority / weight to similar words with higher similarity
		
		//create new ladders for each similar word found
		//loop through all similar words
		for (int i = 0; i < similarWords.size(); i++) {
			//System.out.println("Similar word: " + similarWords.get(i));
			Stack<String> newLadder = new Stack<String>();
			//copy ladder into new ladder
			for (int j = 0; j < ladder.size(); j++) {
				newLadder.add(ladder.get(j));
				//printStack(newLadder);
			}
			//add similar word to new ladder
			newLadder.add(similarWords.get(i));
			//System.out.println();
			//printStack(newLadder);
			//System.out.println();
			ladders.add(newLadder);
		}
	}
	
	public static void printStack(Stack<String> ladder) {
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.get(i));
		}
	}
	
	public static void printSolution(ArrayList<String> solution) {
		for (int i = 0; i < solution.size(); i++) {
			if (i != solution.size() - 1) {
				System.out.print(solution.get(i) + "->");
			}
			else {
				System.out.println(solution.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the starting word: ");
		beginning = scanner.nextLine().toUpperCase();
		System.out.print("Enter the final word: ");
		end = scanner.nextLine().toUpperCase();
		
		ArrayList<String> list = new ArrayList<String>();
		
		wordlength = beginning.length();
		
		if (beginning.length() - end.length() == 0) {
			if (beginning.length() == 4) {
				File file = new File("SortedFourLetterWords.txt");
				Scanner scanner2;
				try {
					scanner2 = new Scanner(file);
					while (scanner2.hasNext()) {
						list.add(scanner2.next().toUpperCase());
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			else if (beginning.length() == 5) {
				File file = new File("SortedFiveLetterWords.txt");
				Scanner scanner2;
				try {
					scanner2 = new Scanner(file);
					while (scanner2.hasNext()) {
						list.add(scanner2.next().toUpperCase());
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			return;
		}
		//ArrayList<String> words = new ArrayList<String>();
		//words.add(beginning);
		
		
		
		find(beginning, list);
		
		if (solutions.size() == 0) {
			System.out.println("No word ladder");
		}
		
		//print shortest solution
		System.out.println("Shortest solution:");
		printSolution(solutions.get(0));
		
		//Print solutions
		/*
		System.out.println("# of solutions: " + solutions.size());
		for (ArrayList<String> solution : solutions) {
			printSolution(solution);
		}
		*/
		
	}
	
}
