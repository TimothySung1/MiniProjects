package PriorityQ;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
	private Node head = null;
	//private Node tail = null;
	public int priorityCount;
	//private int size = 0;
	//List<Node> nodes = new ArrayList<Node>();
	//set size, size of priorityCount
	public Node[] tails;
	
	public PriorityQueue(int nprios) {
		if (nprios <= 0) {
			throw new IllegalArgumentException("Number of priorities must be at least 1");
		}
		priorityCount = nprios;
		tails = new Node[nprios];
	}
	
	public void insert(int priority, int value) {
		//if priority is outside priorityCount range
		if (priority >= priorityCount || priority < 0) {
			throw new IllegalArgumentException("Priority out of range");
			
		}
		Node newNode = new Node(priority, value);
		//if queue empty
		boolean empty = true;
		for (Node tail : tails) {
			if (tail != null) {
				empty = false;
			}
		}
		if (empty) {
			head = newNode;
			//tail = newNode;
			//nodes.add(newNode);
			tails[priority] = newNode;
			
			//System.out.println("Empty queue, add");
			return;
		}
		
		//if queue not empty
		else {
			
			
			//if the new node is added to a priority with no nodes in it
			if (tails[priority] == null) {
				//System.out.println("No node priority, add");
				tails[priority] = newNode;
				for (int i = 1; i <= priority; i++) {
					if (tails[priority - i] != null) {
						newNode.setPrev(tails[priority - i]);
						Node temp = tails[priority - i].getNext();
						tails[priority - i].setNext(newNode);
						newNode.setNext(temp);
						return;
					}
				}
			}
			/*
			//if newnode has highest priority (last)
			if (newNode.getPriority()  > tail.getPriority()) {
				tails[priority] = newNode;
				this.tail.setNext(newNode);
				newNode.setPrev(this.tail);
				this.tail = newNode;
				nodes.add(newNode);
				size++;
				//System.out.println("Highest priority, add");
				return true;
			}
			*/
			//if newNode has lowest priority (first)
			if (newNode.getPriority() < head.getPriority()) {
				tails[priority] = newNode;
				Node temp = head;
				this.head = newNode;
				newNode.setNext(head);
				temp.setPrev(newNode);
				//nodes.add(newNode);
				
				//System.out.println("Lowest priority, add");
				return;
			}
			
			//if newnode has other priority
			int lowest = 0;
			for (Node tail : tails) {
				if (tail != null) {
					if (tail.getPriority() > lowest) {
						lowest = tail.getPriority();
					}
				}
				
					
			}
			if (newNode.getPriority() <= lowest){
				Node node = null;
				//loop through tails array until same priority
				for (Node priorTail : tails) {
					if (priorTail != null) {
						if (priorTail.getPriority() == newNode.getPriority()) {
							//link newNode in between the previous tail of priority and the next node
							Node temp = priorTail.getNext();
							priorTail.setNext(newNode);
							newNode.setPrev(priorTail);
							newNode.setNext(temp);
							//remove previous tail of priority, add newNode to tails
							tails[priority] = newNode;
							if (newNode.getPriority() == lowest) {
								tails[lowest].setNext(newNode);
								newNode.setPrev(tails[lowest]);
								
							}
							//nodes.add(newNode);
							
							//System.out.println("Same priority, add");
							return;
						}
						
					}
					
				}
				return;
			}
			
		}
	}
	
	//remove head, return node
	public Node get() {
		Node tempHead = this.head;
		this.head = this.head.getNext();
		for (int i = 0; i < priorityCount; i++) {
			if (tails[i] == tempHead) {
				tails[i] = null;
			}
		}
		if (this.head != null) {
			this.head.setPrev(null);
		}
		
		return tempHead;
	}
	
	public Node peek() {
		return this.head;
	}
	
	
	public String toString() {
		String string = "";
		string += ("Tails array: \n");
		for (int i = 0; i < priorityCount; i++) {
			if (tails[i] == null) {
				string += ("Priority " + i + ": null\n");
			}
			else {
				string += ("Priority " + i + ": " + tails[i].getValue() + "\n");
			}
		}
		
		string += "Head: ";
		if (head != null) {
			string += "" + head.getPriority() + " " + head.getValue() + "\n";
		}
		else {
			string += "null\n";
		}
		
		return string;
	}
	
	public boolean validate(PriorityQueue queue) {
		//inv 1
		if (queue.peek() == null) {
			for (Node tail : queue.tails) {
				if (tail != null) {
					return false;
				}
			}
		}
		
		//inv 2
		Node node = queue.peek();
		while (node.hasNext()) {
			if (node.hasPrev()) {
				if (node.getPriority() < node.getPrev().getPriority()) {
					return false;
				}
			}
			node = node.getNext();
		}
		
		//inv 3
		node = queue.peek();
		while (node.hasNext()) {
			if (node.getPriority() < 0 || node.getPriority() >= queue.priorityCount) {
				return false;
			}
			node = node.getNext();
		}
		
		//inv 4
		if (queue.peek().hasPrev()) {
			return false;
		}
		
		//inv 5
		node = queue.peek();
		while (node.hasNext()) {
			if (node.hasPrev()) {
				if (node.getPrev().getNext() != node) {
					return false;
				}
			}
			node = node.getNext();
		}
		
		//inv 6
		int lowest = 0;
		for (Node tail : queue.tails) {
			if (tail.getPriority() > lowest) {
				lowest = tail.getPriority();
			}
		}
		if (tails[lowest].hasNext()) {
			return false;
		}
		
		//inv 7
		node = queue.peek();
		while (node.hasNext()) {
			if (node.hasNext()) {
				if (node.getNext().getPrev() != node) {
					return false;
				}
			}
			node = node.getNext();
		}
		
		//inv 8 ??
		/*
		for (int i = 0; i < queue.priorityCount; i ++) {
			if (tails[i] != null) {
				if (i != tails[i].getNext().getPriority()) {
					return false;
				}
			}
		}*/
		
		//inv 9
		for (int i = 0; i < queue.priorityCount; i++) {
			if (tails[i] == null) {
				node = queue.peek();
				while (node.hasNext()) {
					if (node.hasNext()) {
						if (node.getPriority() == i) {
							return false;
						}
					}
					node = node.getNext();
				}
			}
		}
		
		
		return true;
	}
}
