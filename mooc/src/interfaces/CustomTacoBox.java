package interfaces;

public class CustomTacoBox implements TacoBox{
	int tacos;
	public CustomTacoBox(int tacos) {
		this.tacos = tacos;
	}
	public void eat() {
		tacos--;
	}
	public int tacosRemaining() {
		return tacos;
	}
}
