import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class repetitive {
	
	private static int getShortestRepeating(String design) {
		int length = design.length();
		String substring = "";
		for (int i = 1; i < length / 2; i++) {
			substring = design.substring(0, i);
			int sublength = substring.length();
			if (length % sublength == 0) {
				String group = substring;
				for (int j = 0; j < length / sublength - 1; j++) {
					substring += group;
				}
				//System.out.println("substring: " + substring);
				//System.out.println("design: " + design);
				if (design.equals(substring)) {
					//System.out.println("this");
					return group.length();
				}
			}
		}
		return length;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("repetitive.txt");
		Scanner scanner = new Scanner(file);
		String design = scanner.next();
		System.out.println(getShortestRepeating(design));
	}

}
