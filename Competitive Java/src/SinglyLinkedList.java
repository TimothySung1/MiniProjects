
public class SinglyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
	public void insertTail(int num) {
		if(tail == null) {
			tail = new Node(num);
			head = tail;
		}
		else {
			Node temp = new Node(num, null);
			tail.setNext(temp);
			tail = temp;
		}
		size ++;
	}
	
	public void insertHead(int num) {
		if(head == null) {
			head = new Node(num);
			tail = head;
		}
		else {
			Node temp = new Node(num, null);
			temp.setNext(head);
			head = temp;
		}
		size ++;
	}
	
	public int size() {
		return size;
	}
	
	public int getHead() {
		if(head == null) {
			throw new IllegalArgumentException();
		}
		return head.getNum();
	}
	
	public int getTail() {
		if(tail == null) {
			throw new IllegalArgumentException();
		}
		return tail.getNum();
	}
	
	public int getVal(int index) {
		//index starts at 1
		if(index > size() || index <= 0) {
			throw new IllegalArgumentException();
		}
		Node cur = head;
		for(int i = 1; i < index; i ++) {
			cur = cur.getNext();
		}
		return cur.getNum();
	}
	
	public int removeHead() {
		if(head == null) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		head = temp.getNext();
		if(head == null) {
			tail = null;
		}
		size --;
		return temp.getNum();
	}
	
	public int removeTail() {
		//Shouldn't call for singly linked list - slow
		if(tail == null) {
			throw new IllegalArgumentException();
		}
		Node temp = tail;
		Node cur = head;
		for(int i = 0; i < size - 1; i ++) {
			cur = cur.getNext();
		}
		tail = cur;
		size --;
		return temp.getNum();
	}
	
	public boolean contains(int val) {
		Node temp = head;
		while(temp != null) {
			if(temp.getNum() == val) {
				return true;
				
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void insertAt(int index, int num) {
		//index starts at 1
		if(index < 1 || index > (size() + 1)) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		Node prev = tail;
		for(int i = 1; i < index; i ++) {
			prev = temp;
			temp = temp.getNext();
		}
		if(temp == head) {
			head = new Node(num, temp);
		}
		else if(temp == tail) {
			
			prev.setNext(new Node(num, temp));
			
		}
		else {
			prev.setNext(new Node(num, temp));
			if(prev == tail) {
				tail = prev.getNext();
			}
		}
		size ++;
		
	}
	
	public int removeAt(int index) {
		//starts at 1
		if(index < 1 || index > size()) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		Node prev = null;
		for(int i = 1; i < index; i++) {
			prev = temp;
			temp = temp.getNext();
		}
		if(temp == head) {
			head = temp.getNext();
			return temp.getNum();
			
		}
		else {
			//find node before temp, setNext to the one after: temp.getNext()
			prev.setNext(temp.getNext());
			return temp.getNum();
		}
	}
	
	public int remove(int num) {
		Node temp = head;
		Node prev = null;
		while(temp != null) {
			if(temp.getNum() == num) {
				if(temp == head) {
					head = temp.getNext();
				}
				
				else {
					prev.setNext(temp.getNext());
				}
				return temp.getNum();
			}
			prev = temp;
			temp = temp.getNext();
				
		}
		throw new IllegalArgumentException();
	}
		
	
	
	public void print() {
		System.out.println(toString());
	}
	
	public String toString() {
		Node node = head;
		String list = "";
		while(node != null) {
			list += node.getNum() + " ";
			node = node.getNext();
		}
		list += "\n";
		return list;
	}
	
	public void printBackwards() {
		printBackwardsHelper(head);
	}
	
	public void printBackwardsHelper(Node node) {
		if(node == null) {
			return;
		}
		printBackwardsHelper(node.getNext());
		System.out.print(node.getNum() + " ");
	}
	
}
