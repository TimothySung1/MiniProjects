package interfaces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
	public Map<String, Integer> productsStock;
	public Map<String, Integer> productsPrice;
	
	public Warehouse() {
		productsStock = new HashMap<String, Integer>();
		productsPrice = new HashMap<String, Integer>();
	}
	
	public void addProduct(String product, int price, int stock) {
		productsStock.put(product, stock);
		productsPrice.put(product, price);
	}
	
	public int price(String product) {
		if (productsPrice.containsKey(product)) {
			return productsPrice.get(product);
		}
		productsPrice.put(product, 0);
		return productsPrice.get(product);
	}
	
	public int stock(String product) {
		if (productsStock.containsKey(product)) {
			return productsStock.get(product);
		}
		productsStock.put(product, 0);
		return productsStock.get(product);
	}
	
	public boolean take(String product) {
		if(productsStock.containsKey(product)) {
			productsStock.put(product, productsStock.get(product) - 1);
			if(productsStock.get(product) < 0) {
				productsStock.put(product,  0);
				return false;
			}
			return true;
		}
		return false;
	}
	
	public Set<String> products(){
		Set<String> prods = new HashSet();
		for (String product : productsStock.keySet()){
			prods.add(product);
		}
		return prods;
	}
	
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.addProduct("milk", 3, 10);
		warehouse.addProduct("coffee", 5, 6);
		warehouse.addProduct("buttermilk", 2, 20);
		warehouse.addProduct("yogurt", 2, 20);

		System.out.println("products:");

		for (String product: warehouse.products()) {
		    System.out.println(product);
		}
	}
}
