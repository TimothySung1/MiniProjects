import java.util.Scanner;

/*
 * Timothy Sung P7
 * This class creates a new LuckyGame object so that the user can play.
 */
public class LuckyGameRun {
	
	//gets user response, stop ends game, dice and number are the different games, checks for invalid response
	public static boolean getResponse(Scanner scanner, LuckyGame game) {
		boolean invalid = true;
		System.out.println("*************************");
		System.out.print("What do you want to do? [dice, number, double, stop]: ");
		while (invalid) {
			String response = scanner.next().toLowerCase();
			if (response.equals("stop")) {
				return false;
			}
			
			else if (response.equals("dice")) {
				game.dice(scanner);
				invalid = false;
			}
			
			else if (response.equals("number")) {
				game.randomNumber(scanner);
				invalid = false;
			}
			
			else if (response.equals("double")) {
				game.doubleUp(scanner);
				invalid = false;
			}
			
			else {
				System.out.print("Please enter a valid response [dice, number, stop]: ");
			}
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//Introduction to game
		System.out.println("Welcome to my lucky game!");
		System.out.print("Enter 'no' if you want to exit: ");
		boolean running = !scanner.next().toLowerCase().equals("no");
		if (!running) {
			System.out.println("Closing the game.");
			return;
		}
		//create the game and start if the player doesn't quit
		LuckyGame game = new LuckyGame();
		System.out.print("Would you like to read the instructions? [yes/no] ");
		boolean instruction = scanner.next().toLowerCase().equals("yes");
		if (instruction) {
			game.printInstructions();
		}
		System.out.println("You have " + game.START_POINTS + " points.");
		boolean lost = false;
		//start the game
		while(running) {
			running = getResponse(scanner, game);
			//if user inputs stop, ends the game, print statistics, otherwise loop to get response
			if (game.getPoints() == 0) {
				lost = true;
			}
			
			if (lost) {
				System.out.println("You lost! You ran out of points!");
				running = false;
			}
			
			if (!running) {
				System.out.println("*************************");
				System.out.println("Thank you for playing");
				game.printStatistics();
				System.out.println("Ending the game.");
			}
		}
	}

}
