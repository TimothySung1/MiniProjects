package multithreading2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Producer implements Runnable{
	private final int toProduce;
	ArrayList<Product> producedProducts = new ArrayList();
	List<Product> allProducts;
	private int ID;
	
	public Producer(int producerID, List<Product> products, int toProduce) {
		ID = producerID;
		allProducts = products;
		this.toProduce = toProduce;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		produce();
	}

	
	//produce a given amount of products based on toProduce
	public void produce() {
		for (int i = 0; i < toProduce; i++) {
			
			Product prod = new Product(ID);
			producedProducts.add(prod);
			allProducts.add(prod);
			System.out.println("Producer " + ID + " producing..." + producedProducts.size());
		}
		
	}
	
	public int getID() {
		return this.ID;
	}
	
}
