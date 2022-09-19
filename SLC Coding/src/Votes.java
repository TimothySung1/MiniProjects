import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Votes {
	
	private static void printWinner(String[] temp, int i) {
		//depending on i, print the corresponding position
		List<String> winners = getWinners(temp);
		String winners2 = "";
		//if the list winners is greater than size 2, it indicates a tie. It checks > 2 because the number of votes is also in the list.
		boolean tie = (winners.size() > 2);
		if (tie) {
			winners2 = " -tie-";
		}
		for (int j = 0; j < winners.size() - 1; j++) {
			winners2 += " " + winners.get(j);
		}
		winners2 += ", " + winners.get(winners.size() - 1);
		String position = "";
		if (i == 0) {
			position = "President:";
		}
		
		if (i == 1) {
			position = "Vice President:";
		}
		
		if (i == 2) {
			position = "Secretary:";
		}
		
		if (i == 3) {
			position = "Treasurer:";
		}
		
		if (i == 4) {
			position = "Reporter:";
		}
		
		if (i == 5) {
			position = "Sergeant-at-Arms:";
		}
		
		System.out.println(position + winners2);
	}
	
	//this function gets the winner of a specific position
	private static List<String> getWinners(String[] temp) {
		Map<String, Integer> contenders = new HashMap<String, Integer>();
		//this for loop adds each person who received a vote into a hashmap, keeping track of the number of votes it has
		for(String contender : temp) {
			if (!contenders.containsKey(contender)) {
				contenders.put(contender, 1);
			}
			else {
				contenders.put(contender, contenders.get(contender) + 1);
			}
		}
		
		int highest = 1;
		Integer votes = 1;
		//We use this list of strings, winners, to store the winners.
		List<String> winners = new ArrayList<String>();
		
		//Add the winner(s) with the most votes to winners.
		for (Map.Entry<String, Integer> contender : contenders.entrySet()) {
			if (contender.getValue() > highest) {
				winners.clear();
				winners.add(contender.getKey());
				highest = contender.getValue();
				votes = highest;
			}
			else if (contender.getValue() == highest) {
				winners.add(contender.getKey());
			}
		}
		//add the number of votes to the list, since we will need to print it as well.
		winners.add(votes.toString());
		return winners;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//count is the number of ballots
		int count = Integer.parseInt(br.readLine());
		int tempcount = count;
		String[][] ballots = new String[count][6];
		
		for (int i = 0; i < count; i++) {
			ballots[i] = br.readLine().split(" ");
		}
		
		//the for loop and while loop takes each list in the list of lists ballots, which represents the votes for a specific position, and then calls printWinner for each position.
		String[] temp = new String[count];
		for (int i = 0; i < 6; i++) {
			tempcount = count - 1;
			while (tempcount >= 0) {
				temp[tempcount] = ballots[tempcount][i];
				tempcount--;
			}
			printWinner(temp, i);
		}
		 
		
	}
}
