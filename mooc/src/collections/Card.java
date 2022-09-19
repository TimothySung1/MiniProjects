package collections;

import java.util.ArrayList;
import java.util.Collections;

public class Card implements Comparable<Card>{
	
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		if (getValue() <= 10) {
			return suit + " " + getValue();
		}
		else {
			if (getValue() == 11) {
				return suit + " J";
			}
			if (getValue() == 12) {
				return suit + " Q";
			}
			if (getValue() == 13) {
				return suit + " K";
			}
			else {
				return suit + " A";
			}
		}
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int compareTo(Card card) {
		return getValue() - card.getValue();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Card first = new Card(10, Suit.HEART);

		System.out.println(first);

		if (first.getSuit() == Suit.SPADE) {
		    System.out.println("is a spade");
		} else {
		    System.out.println("is not a spade");
		}
		*/
		ArrayList<Card> cards = new ArrayList<>();

		cards.add(new Card(3, Suit.SPADE));
		cards.add(new Card(2, Suit.DIAMOND));
		cards.add(new Card(14, Suit.SPADE));
		cards.add(new Card(12, Suit.HEART));
		cards.add(new Card(2, Suit.SPADE));

		BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
		Collections.sort(cards, sortBySuitSorter);

		cards.stream().forEach(c -> System.out.println(c));
	}

}
