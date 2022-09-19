package typinggame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TreeSet;

public class Game {
	int score;
	static int wpm;
	static List<String> letters = new ArrayList<String>();
	static TreeSet<String> words = new TreeSet<String>();
	boolean running;
	public Game() {
		score = 0;
		running = true;
	}
	
	
	private static String getLetters() {
		Random rand = new Random();
		//get random number from 0-2
		int twoOrThree = rand.nextInt(3);
		int repeat = 0;
		if(twoOrThree == 2) {
			//two letters
			repeat = 2;
		}
		if(twoOrThree != 2) {
			//three letters
			repeat = 3;
		}
		
		String pair = "";
		for (int i = 0; i < repeat; i++) {
			int letter = rand.nextInt(26);
			pair+= letters.get(letter);
		}
		return pair;
	}
	
	private static boolean checkWord(String word, String randpair) {
		if (words.contains(word.toLowerCase()) && word.contains(randpair)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		
		File file = new File("words.txt");
		Scanner scanner = new Scanner(file);
		String word;
		//words contains a lot of words in the english language.
		
		while(true) {
			try{
				word = scanner.next().toLowerCase();
				words.add(word);
			} catch(Exception e){
				break;
			}
		}
		
		//letters is all the letters in the english alphabet
		for(char letter = 'a'; letter <= 'z'; letter++) {
			letters.add(String.valueOf(letter));
		}
		
		
		Game game = new Game();
		System.out.println("Game is running");
		
		Scanner input = new Scanner(System.in);
		String inputword;
		String randpair;
		System.out.println("Input a word that includes the letters randomly generated to you in that sequence.");
		
		//add time limit
		while(game.running) {
			randpair = getLetters();
			System.out.println(randpair);
			inputword = input.next();
			if(checkWord(inputword, randpair)) {
				game.score++;
			}
			else {
				System.out.println("Wrong word!");
				break;
			}
		}
		System.out.println("You figured out " + game.score + " words!");
		
	}

}
