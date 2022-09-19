package multithreading;

import java.util.HashSet;
import java.util.Vector;

public class Consumer implements Runnable {
	
	private final int toConsume;
	Vector<Product> consumedProducts = new Vector();
	Vector<Product> allProducts; //products in circulation
	int ID;
	
	
	public Consumer(int consumerID, Vector<Product> products, int toConsume) {
		ID = consumerID;
		allProducts = products;
		this.toConsume = toConsume;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		consume();
	}

	
	//consume a certain amount of products, remove from all products, add to consumed products
	public void consume() {
		int consumed = 0;
		while (consumed < toConsume) {
			//System.out.println("Consumer " + ID + " consuming...");
			
			while (allProducts.size() == 0) {
				//could replace with producers notifying consumer, or sleeping, etc.
			}
			try {
				consumedProducts.add(allProducts.remove(0));
				System.out.println("Consumer " + ID + " consumed " + consumedProducts.size());
				consumed++;
			} catch(Exception e) {
				
			}
		}
	}
	
	public int getID() {
		return this.ID;
	}
	
}
