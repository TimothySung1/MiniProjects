package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable{
	public List<Movable> organisms = new ArrayList<Movable>();
	public String toString() {
		String line = "";
		for(Movable org : organisms) {
			line += org.toString() + "\n";
		}
		return line;
	}
	
	public void addToHerd(Movable movable) {
		organisms.add(movable);
	}
	
	public void move(int dx, int dy) {
		for (Movable org : organisms) {
			org.move(dx, dy);
		}
	}
	
	public static void main(String[] args) {
		Herd herd = new Herd();
		herd.addToHerd(new Organism(57, 66));
		herd.addToHerd(new Organism(73, 56));
		herd.addToHerd(new Organism(46, 52));
		herd.addToHerd(new Organism(19, 107));
		System.out.println(herd);
	}
}
