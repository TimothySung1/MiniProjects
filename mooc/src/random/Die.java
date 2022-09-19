package random;

import java.util.Random;

public class Die {
	private Random random;
	private int numberOfFaces;
	
	public Die(int numberOfFaces) {
		this.random = new Random();
		this.numberOfFaces = numberOfFaces;
	}
	
	public int throwDie() {
		return 1 + random.nextInt(numberOfFaces);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Die die = new Die(6);

        for (int i = 0; i < 10; i++) {
            System.out.println(die.throwDie());
        }
	}

}
