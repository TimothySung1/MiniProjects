package lottery;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
	
	private static final double LOTTERY_AMOUNT = 4000;
	private static final int MINIMUM_TICKET_NUM = 1;
	private static final int MAXIMUM_TICKET_NUM = 50;
	private static final int MINIMUM_TICKET_RANGE = 5;
	private static final int MAXIMUM_TICKET_RANGE = 10;
	private static final int STARTING_SIZE = 50;
	private static Bag[] bags = new Bag[STARTING_SIZE];
	private static String[] names = new String[STARTING_SIZE];
	
	public Lottery(String[] names) {
		this.names = names;
	}
	
	//return range between minimum and maximum ticket range (inclusive)
	public static int getRange() {
		Random random = new Random();
		int range = random.nextInt(MAXIMUM_TICKET_RANGE - MINIMUM_TICKET_RANGE) + MINIMUM_TICKET_RANGE;
		return range;
	}
	
	//return the minimum ticket number that fits the range (inclusive)
	//ex: if the range is 200, the minimum ticket can't be higher than 800
	public static int[] getTicketRange(int range) {
		Random random = new Random();
		int highest_min = MAXIMUM_TICKET_NUM - (range + 1);
		int minimum_ticket = random.nextInt(highest_min - 1) + 1;
		int maximum_ticket = minimum_ticket + range;
		int[] ticket_range = new int[2];
		ticket_range[0] = minimum_ticket;
		ticket_range[1] = maximum_ticket;
		return ticket_range;
	}
	
	public static void resetBagsNames() {
		bags = new Bag[STARTING_SIZE];
		names = new String[STARTING_SIZE];
	}
	
	public static Bag buyTickets(Scanner scanner, int[] ticketRange) {
		Bag bag = new Bag();
		System.out.println("This lottery's odds are: " + getOdds(ticketRange));
		System.out.println("The ticket range is from: " + ticketRange[0] + " - " + ticketRange[1]);
		while(true) {
			int number = 0;
			while(true) {
				System.out.println("Which ticket number would you like to buy? [-1 to stop]");
				try {
					number = scanner.nextInt();
					if (number == -1) {
						scanner.nextLine();
						return bag;
					}
					if (number < ticketRange[0] || number > ticketRange[1]) {
						throw new NumberFormatException();
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid ticket number.");
				}
				
			}
			while(true) {
				System.out.println("How many of this ticket number would you like to buy? ");
				try {
					int count = scanner.nextInt();
					if (count < 0) {
						throw new NumberFormatException();
					}
					for (int i = 0; i < count; i++) {
						bag.add(number);
					}
					scanner.nextLine();
					break;
					
				} catch (NumberFormatException e) {
					System.out.println("Invalid number of tickets.");
				}
				

			}
			
			
		}
		
	}
	
	public static double getPrizeAmount(int winners, double lotteryAmount) {
		if (winners == 0) {
			return lotteryAmount;
		}
		double amount = lotteryAmount / winners;
		//System.out.printf("%.2f%n", amount);
		return amount;
		
	}
	
	public static String getOdds(int[] ticketRange) {
		int odds = ticketRange[1] - ticketRange[0] + 1;
		return ("1 / " + odds);
	}
	
	public static int getWinningNumber(int[] ticketRange) {
		Random random = new Random();
		int range = ticketRange[1] - ticketRange[0] + 1;
		
		return random.nextInt(range) + ticketRange[0];
	}
	
	public static void main(String[] args) {
		
		double lotteryAmount = LOTTERY_AMOUNT;
		boolean moreLotteries = true;
		while (moreLotteries) {
			//set range and ticket range for this lottery. need loop for multiple lotteries
			int range = getRange();
			int[] ticket_range = getTicketRange(range);
			//System.out.println("Range: " + range);
			//System.out.println("Ticket range: " + ticket_range[0] + " - " + ticket_range[1]);
			
			Scanner scanner = new Scanner(System.in);
			
			int people = 0;
			//loop through the people who buy tickets, add their tickets to their bag.
			while (true) {
				System.out.println("More sales? [-1 to stop]");
				if (scanner.nextLine().equals("-1")) {
					break;
				}
				System.out.println("What is your name? ");
				String name = scanner.nextLine();
				//add resize
				names[people] = name;
				bags[people] = buyTickets(scanner, ticket_range);
				people++;
				
			}
			System.out.println("\n*********************************************\n");
			int numWinners = 0;
			//get the winning number and return a winner if any
			if (people > 0) {
				int winner = getWinningNumber(ticket_range);
				
				System.out.println("The winning ticket number is: " + winner);
				for (int i = 0; i < people; i++) {
					if (bags[i].contains(winner) > 0) {
						numWinners += bags[i].contains(winner);
					}
				}
				//get the prize according to the number of winning tickets
				double prize = getPrizeAmount(numWinners, lotteryAmount);
				System.out.println("Prize: " + prize);
				System.out.println("numWinners: " + numWinners);
				
				//print each person and how much they won
				for (int i = 0; i < people; i++) {
					if (bags[i].contains(winner) > 0) {
						System.out.print(names[i] + " had " + bags[i].contains(winner) + " winning ticket(s) worth $");
						System.out.printf("%.2f%n", prize * bags[i].contains(winner));
					}
				}
				
				//clear bags and names, restart lottery. add money if no one won, do nothing if no one participated.
				//if no participants
			}
			
			if (people == 0) {
				System.out.print("There were no participants. The next lottery's total prize is the same: $");
				System.out.printf("%.2f%n", lotteryAmount);
			}
			else if (numWinners == 0) {
				System.out.println("No one won. The prize money will carry over to the next lottery.");
				lotteryAmount += LOTTERY_AMOUNT;
				System.out.print("The next lottery's total prize is: $");
				System.out.printf("%.2f%n", lotteryAmount);
			}
			
			else if (numWinners > 0) {
				System.out.print("The next lottery's total prize is filled back to ");
				System.out.printf("%.2f%n", lotteryAmount);
			}
			//clear bags and names
			resetBagsNames();
			//check if user wants to continue
			System.out.println("Are there more lotteries? [-1 to stop]");
			if (scanner.nextLine().equals("-1")) {
				break;
			}
		}
		
	}
	
}
