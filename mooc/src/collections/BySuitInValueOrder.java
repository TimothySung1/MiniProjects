package collections;

import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card>{
	public int compare(Card c1, Card c2) {
		if (c1.getSuit().ordinal() - c2.getSuit().ordinal() > 0) {
			return 1;
		}
		if (c1.getSuit().ordinal() - c2.getSuit().ordinal() < 0) {
			return -1;
		}
		else {
			return c1.getValue() - c2.getValue();
		}
	}
}