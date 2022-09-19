
public class Node {
	private int num;
	private Node next;
	
	public Node(int num, Node next) {
		super();
		this.num = num;
		this.next = next;
	}

	public Node(int num) {
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

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
