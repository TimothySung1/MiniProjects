package random;

import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
	private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        // Tests whether the number is already among the randomized numbers
        return this.numbers.contains(number);
    }

    public void randomizeNumbers() {
        // initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the randomization of the numbers by using the method containsNumber() here
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
        	while (true) {
        		int random = rand.nextInt(40) + 1;
        		if (!this.numbers.contains(random)) {
        			this.numbers.add(random);
        			break;
        		}
        	}
        	
        }
    }

    public boolean equals(Object other) {
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LotteryRow row = new LotteryRow();
        ArrayList<Integer> lotteryNumbers = row.numbers();

        System.out.println("Lottery numbers:");
        for (int number: lotteryNumbers) {
            System.out.print(number + " ");
        }

        System.out.println("");
	}

}
