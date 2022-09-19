public class DoublyLinkedList <T> {
	private Node2 head;
	private Node2 tail;
	private int size;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	public void insertTail(T num) {
		if(tail == null) {
			tail = new Node2(num);
			head = tail;
		}
		else {
			Node2 temp = new Node2(num, null, tail);
			tail.setNext(temp);
			tail = temp;
		}
		size ++;
	}
	
	public void insertHead(T num) {
		if(head == null) {
			head = new Node2(num);
			tail = head;
		}
		else {
			Node2 temp = new Node2(num, null, null);
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		}
		size ++;
	}
	
	public int size() {
		return size;
	}
	
	public int sizeBackwards() {
		int sizeBackwards = 0;
		Node2 cur = tail;
		while(cur != null) {
			sizeBackwards++;
			cur = cur.getPrev();
		}
		return sizeBackwards;
	}
	
	public int sizeForwards() {
		int sizeForwards = 0;
		Node2 cur = head;
		while(cur != null) {
			sizeForwards++;
			cur = cur.getNext();
		}
		return sizeForwards;
	}
	
	public boolean validate() {
		int backwards = sizeBackwards();
		int forwards = sizeForwards();
		if(size != backwards) {
			System.out.println("Size: " + size + " Size backwards: " + backwards);
		}
		if(size != forwards) {
			System.out.println("Size: " + size + " Size forwards: " + forwards);
		}
		return (size == backwards && size == forwards);
	}
	
	public T getHead() {
		if(head == null) {
			throw new IllegalArgumentException();
		}
		return head.getNum();
	}
	
	public T getTail() {
		if(tail == null) {
			throw new IllegalArgumentException();
		}
		return tail.getNum();
	}
	
	public T getVal(int index) {
		//index starts at 1
		if(index > size() || index <= 0) {
			throw new IllegalArgumentException();
		}
		Node2 cur = head;
		for(int i = 1; i < index; i ++) {
			cur = cur.getNext();
		}
		return cur.getNum();
	}
	
	public T removeHead() {
		if(head == null) {
			throw new IllegalArgumentException();
		}
		Node2 temp = head;
		head = temp.getNext();
		head.setPrev(null);
		if(head == null) {
			tail = null;
		}
		size --;
		return temp.getNum();
	}
	
	public T removeTail() {
		//Shouldn't call for singly linked list - slow
		if(tail == null) {
			throw new IllegalArgumentException();
		}
		Node2 temp = tail;
		
		if(size == 1) {
			head = null;
			tail = null;
		}
		else {
			/*Node2 cur = head;
			for(int i = 1; i < size - 1; i ++) {
				cur = cur.getNext();
			}
			cur.setNext(null);
			tail = cur;
			*/
			tail = temp.getPrev();
			tail.setNext(null);;
		}
		size --;
		return temp.getNum();
	}
	
	public boolean contains(T val) {
		Node2 temp = head;
		while(temp != null) {
			if(temp.getNum() == val) {
				return true;
				
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void insertAt(int index, T num) {
		//index starts at 1
		if(index < 1 || index > (size() + 1)) {
			throw new IllegalArgumentException();
		}
		Node2 temp = head;
		if(index > size) {
			tail.setNext(new Node2(num));
			tail = tail.getNext();
			return;
		}
		for(int i = 1; i < index; i ++) {
			temp = temp.getNext();
		}
		if(temp == head) {
			head = new Node2(num, temp, null);
			temp.setPrev(head);
		}
		
		else {
			Node2 prev = new Node2(num, temp, temp.getPrev());
			temp.getPrev().setNext(prev);
			temp.setPrev(prev);
		}
		size ++;
		
	}
	
	public T removeAt(int index) {
		//starts at 1
		if(index < 1 || index > size()) {
			throw new IllegalArgumentException();
		}
		Node2 temp = head;
		for(int i = 1; i < index; i++) {
			temp = temp.getNext();
		}
		if(temp == head) {
			if(size == 1) {
				head = null;
				tail = null;
			}
			else{
				head = temp.getNext();
			}
			size --;
			return temp.getNum();
			
		}
		if(temp == tail) {
			tail = temp.getPrev();
			tail.setNext(null);
			size --;
			return temp.getNum();
		}
		else {
			//find node before temp, setNext to the one after: temp.getNext()
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			size --;
			return temp.getNum();
		}
		
	}
	
	public T remove(T num) {
		Node2 temp = head;
		Node2 prev = null;
		while(temp != null) {
			if(temp.getNum() == num) {
				if(temp == head) {
					head = temp.getNext();
					head.setPrev(null);
				}
				
				else {
					prev.setNext(temp.getNext());
					temp.getNext().setPrev(prev);
				}
				size--;
				return temp.getNum();
			}
			prev = temp;
			temp = temp.getNext();
				
		}
		throw new IllegalArgumentException();
	}
		
	
	
	public void print() {
		System.out.println(toString() + "\n");
	}
	
	public String toString() {
		Node2 node = head;
		String list = "";
		if(node != null) {
			list += node.getNum();
			node = node.getNext();
		}
		while(node != null) {
			list += " "+ node.getNum();
			node = node.getNext();
		}
		return list;
	}
	
	public void printBackwards() {
		printBackwardsHelper(tail);
	}
	
	public void printBackwardsHelper(Node2 node) {
		/*
		if(node == null) {
			return;
		}
		printBackwardsHelper(node.getNext());
		System.out.print(node.getNum() + " ");
		*/
		for(int i = 0; i < size; i++) {
			System.out.print(node.getNum() + " ");
			node = node.getPrev();
		}
		System.out.println("\n");
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	class Node2 {
		private T num;
		private Node2 next;
		private Node2 prev;
		
		public Node2(T num, Node2 next, Node2 prev) {
			super();
			this.num = num;
			this.next = next;
			this.prev = prev;
		}

		public Node2(T num) {
			super();
			this.num = num;
			next = null;
		}

		public T getNum() {
			return num;
		}

		public void setNum(T num) {
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
}