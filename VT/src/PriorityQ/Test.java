package PriorityQ;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		/*
		PriorityQueue q = new PriorityQueue(7);
		q.insert(0, 1);
		q.insert(4, 5);
		q.insert(2, 3);
		
		q.insert(2, 2);
		q.insert(1, 2);
		q.insert(3, 4);
		q.insert(5, 6);
		//q.insert(7, 7);
		//q.insert(-1, 3);
		
		System.out.println(q);
		
		assertEquals(q.peek().hasPrev(), false);
		assertEquals(q.peek().getPriority(), 0);
		q.get().printNode();
		q.get().printNode();
		q.get().printNode();
		q.get().printNode();
		q.get().printNode();
		q.get().printNode();
		q.get().printNode();
		
		System.out.println(q);
		*/
		
		PriorityQueue queue = new PriorityQueue(5);
		System.out.println(queue);
		queue.insert(2, 3);
		queue.insert(2, 1);
		queue.insert(4, 1);
		System.out.println(queue);
		
	}

}
