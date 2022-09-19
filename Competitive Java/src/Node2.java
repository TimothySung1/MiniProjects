
public class Node2 {
	private int num;
	private Node2 next;
	private Node2 prev;
	
	public Node2(int num, Node2 next, Node2 prev) {
		super();
		this.num = num;
		this.next = next;
		this.prev = prev;
	}

	public Node2(int num) {
		super();
		this.num = num;
		next = null;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Node2 getNext() {
		return next;
	}

	public void setNext(Node2 next) {
		this.next = next;
	}
	
	public Node2 getPrev() {
		return prev;
	}
	
	public void setPrev(Node2 prev) {
		this.prev = prev;
	}
}
