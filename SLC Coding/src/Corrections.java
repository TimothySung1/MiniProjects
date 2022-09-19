import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Corrections {
	
	private static void corrections(String phrase, String wrong, String correction) {
		String correctPhrase = phrase.replace(wrong, correction);
		System.out.println(correctPhrase);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String phrase = br.readLine();
		String wrong = br.readLine();
		String correction = br.readLine();
		corrections(phrase, wrong, correction);
	}
}
