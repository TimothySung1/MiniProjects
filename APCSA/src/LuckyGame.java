import java.util.Scanner;

/*
 * Timothy Sung P7
 * In this game, the user can pick a number of luck-based/random games to test their luck and gain (or lose) all their virtual points.
 * 
 */


public class LuckyGame {
	//class instance variables, store starting points user gets and statistics
	final int START_POINTS = 10;
	private int gamesWon, gamesLost, pointsWon, pointsLost, points;
	
	//default constructor
	public LuckyGame() {
		this.gamesWon = 0;
		this.gamesLost = 0;
		this.pointsWon = 0;
		this.pointsLost = 0;
		this.points = START_POINTS;
	}
	
	//returns the attribute points
	public int getPoints() {
		return this.points;
	}
	
	//prints user statistics
	public void printStatistics() {
		System.out.println("Here are your statistics:");
		System.out.println("Games won: " + gamesWon);
		System.out.println("Games lost: " + gamesLost);
		System.out.println("Points won: " + pointsWon);
		System.out.println("Points lost: " + pointsLost);
		System.out.println("Current Points: " + points);
	}
	
	//print instructions if the user wants
	public void printInstructions() {
		//25
		System.out.println("*************************");
		System.out.println("Are you feeling lucky? Here's how you play!");
		System.out.println("There are three minigames that you can play: Dice, Random Number, and Double Up.");
		System.out.println("The game will prompt you to input either: dice, number, or double to play their respective games.");
		System.out.println("Be mindful of your points, because playing each game spends 1 point, except for Double Up.");
		System.out.println("The Dice Game: You will be prompted to guess a number 1-6 to try and guess the dice roll.\n"
				+ "You get 1 attempts to guess it correctly for 6 points.");
		System.out.println("The Random Number Game: You first enter a range of numbers that you will guess a number in.\n"
				+ "The higher the range, the higher the potential points you can earn.\n"
				+ "You can choose the number of attempts to guess the number, but each additional attempt will reduce the points you can earn.\n"
				+ "If you don't guess the correct number within your attempts, you lose!");
		System.out.println("The Double Up Game: Here, you can lose it all or double your points!\n"
				+ "With a 50/50 chance, enter an odd or even (positive) number.\n"
				+ "Pick the correct one and you double your points!\n"
				+ "If not, you lose everything and the game ends.");
		System.out.println("Good Luck!");
		System.out.println("*************************");
	}
	
	//dice game, user rolls the dice, predicts number.
	public void dice(Scanner scan) {
		System.out.println("Playing the Dice Game...");
		
		int potentialPoints = 6;
		//print image of dice using characters or something
		System.out.println("Enter the dice roll you predict: ");
		int guess = scan.nextInt();
		System.out.println("You guessed: " + guess);
		
		//get random dice roll
		int roll = (int) (Math.random() * 6) + 1;
		
		System.out.println("Dice rolling...");
		System.out.println("Here is the die: ");
		printDie(roll);
		if (guess == roll) {
			System.out.println("You guessed the correct roll!");
			System.out.println("You earned " + potentialPoints + " points!");
			points += potentialPoints;
			gamesWon++;
			pointsWon += potentialPoints;
			printStatistics();
		}
		else {
			System.out.println("You didn't guess the correct roll! 1 point lost.");
			gamesLost++;
			points--;
			pointsLost++;
			printStatistics();
		}
	}
	
	//prints image of a die for the user, used in method dice()
	public void printDie(int number) {
		/* 26 - long
		 * 10 | in between
		 */
		String one = "--------------------------\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|           **           |\n"
				   + "|           **           |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "--------------------------";
		
		String two = "--------------------------\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|                ***     |\n"
				   + "|                ***     |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "|     ***                |\n"
				   + "|     ***                |\n"
				   + "|                        |\n"
				   + "|                        |\n"
				   + "--------------------------";
		
		String three = "--------------------------\n"
				     + "|                        |\n"
				     + "|                **      |\n"
				     + "|                **      |\n"
				     + "|                        |\n"
				     + "|           **           |\n"
					 + "|           **           |\n"
					 + "|                        |\n"
					 + "|      **                |\n"
					 + "|      **                |\n"
					 + "|                        |\n"
					 + "--------------------------";
		
		String four = "--------------------------\n"
				    + "|                        |\n"
				    + "|                        |\n"
				    + "|     ***        ***     |\n"
				    + "|     ***        ***     |\n"
				    + "|                        |\n"
				    + "|                        |\n"
				    + "|     ***        ***     |\n"
				    + "|     ***        ***     |\n"
				    + "|                        |\n"
				    + "|                        |\n"
				    + "--------------------------";
		
		String five = "--------------------------\n"
			    	+ "|                        |\n"
				    + "|                        |\n"
				    + "|     ***        ***     |\n"
				    + "|     ***        ***     |\n"
				    + "|           **           |\n"
				    + "|           **           |\n"
				    + "|     ***        ***     |\n"
				    + "|     ***        ***     |\n"
				    + "|                        |\n"
				    + "|                        |\n"
				    + "--------------------------";
		
		String six = "--------------------------\n"
				   + "|                        |\n"
				   + "|      ***      ***      |\n"
				   + "|      ***      ***      |\n"
				   + "|                        |\n"
				   + "|      ***      ***      |\n"
				   + "|      ***      ***      |\n"
				   + "|                        |\n"
				   + "|      ***      ***      |\n"
				   + "|      ***      ***      |\n"
				   + "|                        |\n"
				   + "--------------------------";
		
		//put them all in an array for easier returning
		String[] dice = new String[6];
		dice[0] = one;
		dice[1] = two;
		dice[2] = three;
		dice[3] = four;
		dice[4] = five;
		dice[5] = six;
		//print die according to number
		System.out.println(dice[number - 1]);
		System.out.println("Dice number: " + number);
	}
	
	//random number game, predict number in a range
	public void randomNumber(Scanner scan) {
		System.out.println("Playing the Random Number Game...");
		
		//get range and potential points user can earn
		System.out.println("Input the range of numbers you want to guess: ");
		int range = scan.nextInt(), potentialPoints = range;
		//ask for multiple chances, reduce potential points by number of attempts user chooses
		System.out.println("How many attempts do you want to take? ");
		int attempts = scan.nextInt();
		potentialPoints /= attempts;
		//get random number
		int number = (int)(Math.random() * range) + 1;
		//guessing, if guessed, give points, if not retry until get it right or attempts used
		for (int i = 0; i < attempts; i++) {
			System.out.println("What number do you think it is? Range: [1 - " + (range) + "] ");
			int guess = scan.nextInt();
			if (guess == number) {
				points += potentialPoints;
				gamesWon++;
				pointsWon += potentialPoints;
				System.out.println("Congratulations! You guessed the correct number: " + number + "!");
				//System.out.println("You earned " + potentialPoints + " points! You now have " + points + " points!");
				printStatistics();
				return;
			}
			System.out.println(guess + " was not the correct number!\n" + (attempts - i - 1) + " attempts left.");
		}
		System.out.println("You lost! Your attempts were used up! You lost 1 point.");
		gamesLost++;
		points--;
		pointsLost++;
		printStatistics();
	}
	
	//user doubles up points or loses it all, 50/50 chance
	public void doubleUp(Scanner scan) {
		System.out.println("Playing the Double Up Game...");
		
		//get even or odd, 1 is odd, 2 is even
		int number = (int) (Math.random() * 2) + 1;
		boolean even = (number % 2 == 0);
		
		System.out.println("Enter a positive integer, either even or odd: ");
		int guess = scan.nextInt();
		
		//check if the guess is odd or even and if it is the same as randomly generated
		if ((guess % 2 == 0) == even) {
			System.out.println("Congratulations, you won!");
			if (even) {
				System.out.println("You correctly guessed an even number!");
			}
			else {
				System.out.println("You correctly guessed an odd number!");
			}
			System.out.println("You doubled up your points!");
			pointsWon += points;
			points *= 2;
			gamesWon++;
			printStatistics();
		}
		
		else {
			System.out.println("You lost all your points!");
			if (even) {
				System.out.println("You guessed an odd number when it was even!");
			}
			else {
				System.out.println("You guessed an even number when it was odd!");
			}
			pointsLost += points;
			points = 0;
			gamesLost++;
			printStatistics();
		}
	}
	
}
