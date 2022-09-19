package collections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Literacy implements Comparable<Literacy>{
	private String country;
	private String gender;
	private int literacy;
	public Literacy(String country, String gender, int literacy) {
		this.country = country;
		this.gender = gender;
		this.literacy = literacy;
	}
	
	@Override
	public int compareTo(Literacy country) {
		return this.getLiteracy() - country.getLiteracy();
	}
	
	public int getLiteracy() {
		return this.literacy;
	}
	
	@Override
	public String toString() {
		return (this.country + ", " + this.gender + "," + this.getLiteracy());
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("countries.txt");
		Scanner scanner = new Scanner(file);
		List<Literacy> countries = new ArrayList<>();
		while(true) {
			try {
				String countryLine = scanner.nextLine();
				//System.out.println(countryLine);
				String[] parts = countryLine.split(",");
				//for(String string : parts) {
				//	System.out.println(string);
				//}
				
				Literacy country = new Literacy(parts[3], parts[2], (int)(Double.parseDouble(parts[5])));
				countries.add(country);
			} catch(Exception e) {
				break;
			}
		}
		
		countries.stream().sorted().forEach(country -> System.out.println(country));
		
	}

}
