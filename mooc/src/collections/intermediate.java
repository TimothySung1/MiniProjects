package collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class intermediate {
	
	public static List<String> read(String file){
		List<String> stringFile = new ArrayList<>();
		try {
			Files.lines(Paths.get(file)).forEach(row -> stringFile.add(row));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringFile;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
