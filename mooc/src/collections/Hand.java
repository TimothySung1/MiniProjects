package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand> {
	private List<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<>();
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public void print() {
		this.cards.stream().forEach(card -> System.out.println(card));
	}
	
	public void print2() {
		Iterator<Card> iterator = cards.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void sort() {
		Collections.sort(this.cards);
	}
	
	public void sortBySuit() {
		Collections.sort(this.cards, new SortBySuit());
	}
	
	public void removeWorst(int value) {
		Iterator<Card> iterator = cards.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getValue() < value) {
				iterator.remove();
			}
		}
	}
	
	public int compareTo(Hand hand) {
		int thisSum = 0;
		for (Card card : this.cards) {
			thisSum += card.getValue();
		}
		int thatSum = 0;
		for (Card card : hand.cards) {
			thatSum += card.getValue();
		}
		return thisSum - thatSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Hand hand1 = new Hand();

		hand1.add(new Card(2, Suit.DIAMOND));
		hand1.add(new Card(14, Suit.SPADE));
		hand1.add(new Card(12, Suit.HEART));
		hand1.add(new Card(2, Suit.SPADE));
		
		Hand hand2 = new Hand();

		hand2.add(new Card(11, Suit.DIAMOND));
		hand2.add(new Card(11, Suit.SPADE));
		hand2.add(new Card(11, Suit.HEART));

		int comparison = hand1.compareTo(hand2);

		if (comparison < 0) {
		    System.out.println("better hand is");
		    hand2.print();
		} else if (comparison > 0){
		    System.out.println("better hand is");
		    hand1.print();
		} else {
		    System.out.println("hands are equal");
		}
		*/
		Hand hand = new Hand();

		hand.add(new Card(12, Suit.HEART));
		hand.add(new Card(4, Suit.SPADE));
		hand.add(new Card(2, Suit.DIAMOND));
		hand.add(new Card(14, Suit.SPADE));
		hand.add(new Card(7, Suit.HEART));
		hand.add(new Card(2, Suit.SPADE));

		hand.sortBySuit();

		hand.print();
	}

}
