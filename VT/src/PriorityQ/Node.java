package PriorityQ;

public class Node {
	private int priority;
	private int value;
	private Node next;
	private Node prev;
	
	public Node(int priority, int value, Node next, Node prev) {
		this.priority = priority;
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	public Node(int priority, int value) {
		this.priority = priority;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public void setPrev(Node node) {
		this.prev = node;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public boolean hasNext() {
		return (this.next != null);
	}
	
	public boolean hasPrev() {
		return (this.prev != null);
	}
	
	public void printNode() {
		System.out.println("Priority: " + this.priority);
		System.out.println("Value: " + this.value);
		System.out.println("Next: " + this.hasNext());
		System.out.println("Prev: " + this.hasPrev());
	}
	
}
