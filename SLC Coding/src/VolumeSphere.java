import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class VolumeSphere {
	
	public static void calculateSphere(String given, double value) {
		DecimalFormat df = new DecimalFormat(".#");
		//this if statement calculates the volume if the user has the radius
		if (given.equals("radius")) {
			double volume = (4 * (3.14159) * (Math.pow(value, 3)) / 3);
			System.out.println("Volume: " + df.format(volume));
		}
		
		//this if statement calculates the radius if the user has the volume
		if (given.equals("volume")) {
			double radius = Math.cbrt((3 * value) / (4 * 3.14159));
			System.out.println("Radius: " + df.format(radius));
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String given = br.readLine();
		double value = Double.parseDouble(br.readLine());
		
		calculateSphere(given, value);
	}
}
