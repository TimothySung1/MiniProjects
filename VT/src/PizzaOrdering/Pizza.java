package PizzaOrdering;

import java.util.HashMap;

public class Pizza {
	private double price;
	private int sizePrice;
	private int topPrice;
	private HashMap<String, Integer> toppings;
	private String size;
	private int wingPrice;
	public Pizza(double price, int sizePrice, int topPrice, HashMap<String, Integer> toppings, String size, int wingPrice) {
		this.price = price;
		this.sizePrice = sizePrice;
		this.topPrice = topPrice;
		this.toppings = toppings;
		this.size = size;
		this.wingPrice = wingPrice;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getSizePrice() {
		return this.sizePrice;
	}
	
	public int getTopPrice() {
		return this.topPrice;
	}
	
	public HashMap<String, Integer> getToppings(){
		return this.toppings;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public int getWingPrice() {
		return this.wingPrice;
	}
}
