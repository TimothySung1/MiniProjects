package multithreading3;

public class Product {
	private int producerID;
	
	
	public Product(int producerID) {
		this.producerID = producerID;
		
	}
	
	public int getID() {
		return this.producerID;
	}
}
