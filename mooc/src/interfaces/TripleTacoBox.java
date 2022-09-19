package interfaces;

public class TripleTacoBox implements TacoBox{
	int tacos;
	public TripleTacoBox() {
		tacos = 3;
	}
	
	public void eat() {
		tacos--;
	}
	
	public int tacosRemaining() {
		return tacos;
	}
}
