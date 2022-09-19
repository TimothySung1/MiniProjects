package multithreading3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Producer implements Runnable{
	private final int toProduce;
	private final Object lock = new Object();
	
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
		int produced = 0;
		while (produced < toProduce) {
			
			synchronized(allProducts) {
				Product prod = new Product(ID);
				producedProducts.add(prod);
				allProducts.add(prod);
				produced++;
				System.out.println("Producer " + ID + " producing..." + producedProducts.size());
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public int getID() {
		return this.ID;
	}
	
}
