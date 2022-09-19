package interfaces;

public class Organism implements Movable{
	public int x;
	public int y;
	public Organism(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x: " + x + "; y: " + y;
	}
	
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public static void main(String[] args) {
		Organism organism = new Organism(20, 30);
		System.out.println(organism);
		organism.move(-10, 5);
		System.out.println(organism);
		organism.move(50, 20);
		System.out.println(organism);
	}
}
