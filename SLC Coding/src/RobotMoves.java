import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotMoves {
	
	private static void move(int col, int rows, String location, String moves) {
		char x = location.charAt(0);
		//get the x and y coordinates to the robot's starting position
		int x_pos = x - 64;
		int y_pos = Integer.parseInt(location.substring(1, 2));
		boolean outOfBounds = false;
		
		//keep track of the robot's location when given directions
		for (char ch : moves.toCharArray()) {
			if (ch == 'N') {
				y_pos--;
			}
			else if (ch == 'E') {
				x_pos++;
			}
			else if (ch == 'S') {
				y_pos++;
			}
			else {
				x_pos--;
			}
			if (y_pos > rows || y_pos <= 0) {
				outOfBounds = true;
			}
			if (x_pos > col || x_pos <= 0) {
				outOfBounds = true;
			}
		}
		
		if (outOfBounds) {
			System.out.println("Out of bounds.");
		}
		//print the final position. x_pos is converted to a letter using ASCII.
		else {
			System.out.println(String.valueOf((char)(x_pos + 64)) + String.valueOf(y_pos));
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int col = Integer.parseInt(br.readLine());
		int rows = Integer.parseInt(br.readLine());
		String location = br.readLine();
		String moves = br.readLine();
		move(col, rows, location, moves);
	}
}
