


public class ExtendsStuff {

	public void eat() {
		System.out.println("Eat");
	}
	
	public static void main(String[] args) {
		ExtendsStuff thing = new Animal();
		thing.eat();
		//thing.growl();
		((Animal) thing).growl();
	}

}

class Animal extends ExtendsStuff{
	public Animal() {
		super();
	}
	
	public void growl() {
		System.out.println("Growl");
	}
}