package LevelsLinkedList;

public class TNode {
	private int location;
	private TNode next;
	private TNode down;
	
	public TNode(int location) {
		this.location = location;
	}
	
	public TNode(int location, TNode next) {
		this.location = location;
		this.next = next;
	}
	
	public TNode(int location, TNode next, TNode down) {
		this.location = location;
		this.next = next;
		this.down = down;
	}
	
	public void setNext(TNode next) {
		this.next = next;
	}
	
	public void setDown(TNode down) {
		this.down = down;
	}
	
	public TNode getNext() {
		return this.next;
	}
	
	public TNode getDown() {
		return this.down;
	}
	
	public int getLocation() {
		return this.location;
	}
}
