package lottery;

public class Bag {
	private static final int STARTING_SIZE = 10;
	private int[] tickets = new int[STARTING_SIZE];
	private int size = 0;
	
	
	
	//add ticket number to person's bag
	public void add(int ticket_number) {
		if (size == tickets.length) {
			resize();
		}
		tickets[size] = ticket_number;	
		size++;
	}
	
	//double the size of the array tickets
	public void resize() {
		int[] bigger_tickets = new int[tickets.length * 2];
		for (int i = 0; i < tickets.length; i++) {
			bigger_tickets[i] = tickets[i];
		}
		tickets = bigger_tickets;
	}
	
	public int contains(int number) {
		int count = 0;
		for (int ticket : tickets) {
			//System.out.println(ticket);
			if (ticket == number) {
				count++;
			}
		}
		//System.out.println(count);
		return count;
	}
}
