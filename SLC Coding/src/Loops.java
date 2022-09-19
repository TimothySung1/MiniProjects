import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loops {
	
	//print the phrase for as long as the integer repeats is.
	private static void loop(int repeats, String phrase) {
		for (int i = 0; i < repeats; i++) {
			System.out.println((i + 1) + " " + phrase);
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeats = Integer.parseInt(br.readLine());
		String phrase = br.readLine();
		
		loop(repeats, phrase);
	}
}
