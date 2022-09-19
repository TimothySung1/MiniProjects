import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cooking {
	
	
	
	private static void match(String recipeX, String recipeY, int X, int Y) {
		int steps = 0;
		char[] charsX = recipeX.toCharArray();
		char[] charsY = recipeY.toCharArray();
		boolean found;
		int start = 0;
		for (int j = 0; j < charsX.length; j++) {
			found = false;
			for (int i = start; i < charsY.length; i++) {
				if (charsX[j] == charsY[i]) {
					charsY[i] = '-';
					charsX[j] = '-';
					found = true;
					start = i + 1;
				}
			}
			if (!found) {
				steps ++;
			}
		}
		/*
		for (char character : charsX) {
			if (character != '-') {
				steps++;
			}
		}
		*/
		for (char character : charsY) {
			if (character != '-') {
				steps++;
			}
		}
		
		System.out.println(steps);
	}
	
	public static void main(String[] args) throws IOException{
		File file = new File("cooking.txt");
		Scanner scanner = new Scanner(file);
		int lengthX = scanner.nextInt();
		String recipeX = scanner.next();
		int lengthY = scanner.nextInt();
		String recipeY = scanner.next();
		match(recipeX, recipeY, lengthX, lengthY);
	}
}
