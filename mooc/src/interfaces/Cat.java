package interfaces;

public class Cat extends Animal implements NoiseCapable{
	public Cat(String name) {
		super(name);
	}
	public Cat() {
		super("Cat");
	}
	
	public void purr() {
		System.out.println(super.name + " purrs");
	}
	
	public void makeNoise() {
		System.out.println(super.name + " purrs");
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.purr();
		cat.eat();

		Cat garfield = new Cat("Garfield");
		garfield.purr();
	}
}
