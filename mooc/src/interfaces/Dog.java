package interfaces;

public class Dog extends Animal implements NoiseCapable{

	public Dog(String name) {
		super(name);
		
	}
	public Dog() {
		super("Dog");
		
	}
	
	public void bark() {
		System.out.println(super.name + " barks");
	}
	
	public void makeNoise() {
		System.out.println(super.name + " barks");
	}
	
	
	public static void main(String[] args) {
		/*
		Dog dog = new Dog();
		dog.bark();
		dog.eat();

		Dog fido = new Dog("Fido");
		fido.bark();
		*/
		NoiseCapable dog = new Dog();
		dog.makeNoise();

		NoiseCapable cat = new Cat("Garfield");
		cat.makeNoise();
		Cat c = (Cat) cat;
		c.purr();
	}
}
