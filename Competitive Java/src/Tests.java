import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tests {

	/*@Test
	void testQueue() {
		System.out.println("Queue");
		//fail("Not yet implemented");
		Queue<String> queue = new Queue<>();
		assertEquals(true, queue.isEmpty());
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.peek();
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.dequeue();
		});
		queue.enqueue("hello");
		assertEquals("hello", queue.peek());
		assertEquals(false, queue.isEmpty());
		assertEquals("hello", queue.dequeue());
		queue.print();
		assertEquals(true, queue.isEmpty());
		queue.enqueue("hello2");
		queue.enqueue("point");
		queue.enqueue("third");
		queue.enqueue("final");
		assertEquals(false, queue.isEmpty());
		queue.print();
		assertEquals("hello2", queue.peek());
		assertEquals("hello2", queue.dequeue());
		queue.print();
		assertEquals("point", queue.dequeue());
		queue.print();
		assertEquals(false, queue.isEmpty());
		assertEquals("third", queue.dequeue());
		queue.print();
		assertEquals("final", queue.dequeue());
		queue.print();
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	void testStack() {
		System.out.println("Stack");
		//fail("Not yet implemented");
		Stack<String> stack = new Stack<>();
		assertEquals(true, stack.isEmpty());
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stack.peek();
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stack.pop();
		});
		stack.push("hello");
		assertEquals("hello", stack.peek());
		assertEquals(false, stack.isEmpty());
		assertEquals("hello", stack.pop());
		stack.print();
		assertEquals(true, stack.isEmpty());
		stack.push("hello2");
		stack.push("point");
		stack.push("third");
		stack.push("final");
		assertEquals(false, stack.isEmpty());
		stack.print();
		assertEquals("final", stack.peek());
		assertEquals("final", stack.pop());
		stack.print();
		assertEquals("third", stack.pop());
		stack.print();
		assertEquals(false, stack.isEmpty());
		assertEquals("point", stack.pop());
		stack.print();
		assertEquals("hello2", stack.pop());
		stack.print();
		assertEquals(true, stack.isEmpty());
	}
	
	@Test
	void testSinglyLinkedList() {
		//fail("Not yet implemented");
		System.out.println("Singly Linked List");
		SinglyLinkedGeneric<String> list = new SinglyLinkedGeneric<>();
		list.insertHead("start");
		list.insertTail("finish");
		list.insertAt(2, "middle");
		list.print();
		assertEquals("finish", list.removeTail());
		assertEquals("middle", list.getTail());
		assertEquals("start middle", list.toString());
		list.size();
		assertEquals("middle", list.removeTail());
		assertEquals("start", list.toString());
		list.size();
		assertEquals("start", list.removeTail());
		assertEquals("", list.toString());
		list.size();
		assertEquals(true, list.isEmpty());
		list.insertHead("start");
		list.insertTail("finish");
		list.insertAt(2, "middle");
		list.insertHead("start2");
		list.insertTail("finish2");
		list.insertAt(2, "second");
		assertEquals("start", list.removeAt(3));
		assertEquals("finish2", list.remove("finish2"));
		assertEquals("start2", list.remove("start2"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			list.insertAt(-1, "3");
		});
		assertEquals("middle", list.remove("middle"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			list.remove("nonexistent string");
		});
		
		
	}
	
	
	@Test
	void testDoublyLinkedList() {
		DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
		list2.insertHead("head");
		list2.insertTail("tail");
		list2.insertAt(2, "middle");
		list2.insertAt(2, "middle2");
		list2.insertAt(3, "third");
		list2.insertAt(4, "fourth");
		System.out.println("Doubly Linked List Print and Print Backwards\n");
		list2.print();
		list2.printBackwards();
		System.out.println("\nChecking size, removing 3rd index");
		System.out.println(list2.size());
		list2.removeAt(3);
		System.out.println(list2.size());
		list2.removeAt(3);
		System.out.println(list2.size());
		System.out.println();
		System.out.println("Printing forwards and backwards");
		list2.print();
		list2.printBackwards();
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			list2.insertAt(49, "fail");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			list2.remove("not here");	
		});
		assertEquals("head", list2.remove("head"));
		System.out.println("removed head");
		list2.print();
		//assertEquals("tail", list2.removeTail());
		list2.validate();
		list2.removeTail();
		list2.print();
		list2.validate();
		System.out.println(list2.getHead());
		System.out.println(list2.getTail());
		
		list2.removeHead();
		list2.removeTail();
		System.out.println(list2.size());
		System.out.println(list2.isEmpty());
		list2.validate();
		
		
	}
	
	@Test
	void testBinarySearchTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(26);
		tree.insert(16);
		tree.insert(54);
		assertEquals(6, tree.getSize());
		assertEquals(false, tree.isEmpty());
		assertEquals(true, tree.contains(40));
		assertEquals(false, tree.contains(161));
		tree.print();
		System.out.println(tree.height());
	}
*/
	/*
	@Test
	void testMinHeap() {
		Heap minHeap = new MinHeap();
		Random random = new Random();
		int prev = 0;
		int sum = 0;
		for(int i = 0; i < 100; i ++) {
			int val = random.nextInt(100) + 1;
			minHeap.insert(val);
			System.out.println(val);
			sum += val;
			//minHeap.print();
		}
		
		for(int i = 1; i < 8; i ++) {
			minHeap.insert(i);
			System.out.println(i);
			sum += i;
		}
		
		System.out.println("Sum: " + sum);
		System.out.println();
		System.out.println("Heap: ");
		minHeap.print();
		System.out.println("Size: " + minHeap.getSize());
		System.out.println("Popping: ");
		
		int sum2 = 0;
		for(int i = 0; i < 100; i ++) {
			int num = minHeap.pop();
			sum2 += num;
			//minHeap.print();
			if(i > 0) {
				if(prev > num) {
					System.out.println("Error: " + i + " " + prev + " " + num);
				}
			}
			
			prev = num;
			System.out.println(num + " ");
		}
		System.out.println("Sum2: " + sum2);
		System.out.println();
		System.out.println("Heap after: ");
		minHeap.print();
		System.out.println("Size: " + minHeap.getSize());
		
	}*/
	/*
	@Test
	void testMaxHeap() {
		Heap maxHeap = new MaxHeap();
		Random random = new Random();
		int prev = Integer.MAX_VALUE;
		int sum = 0;
		/*for(int i = 0; i < 100; i ++) {
			int val = random.nextInt(100) + 1;
			maxHeap.insert(val);
			System.out.println(val);
			sum += val;
		}
		
		
		for(int i = 1; i < 100; i ++) {
			maxHeap.insert(i);
			System.out.println(i);
			sum += i;
			maxHeap.peak();
		}
		System.out.println("Sum: " + sum);
		System.out.println();
		System.out.println("Heap: ");
		maxHeap.print();
		System.out.println("Size: " + maxHeap.getSize());
		System.out.println("Popping: ");
		
		int sum2 = 0;
		for(int i = 1; i < 100; i ++) {
			int num = maxHeap.pop();
			sum2 += num;
			maxHeap.peak();
			if(i > 0) {
				if(num > prev) {
					System.out.println("Error: " + i + " " + prev + " " + num);
				}
			}
			
			prev = num;
			System.out.print(num + " ");
		}
		System.out.println("Sum2: " + sum2);
		System.out.println();
		System.out.println("Heap after: ");
		maxHeap.print();
		System.out.println("Size: " + maxHeap.getSize());
	}
	*/
	
	/*
	@Test
	void testDynamicArray() {
		DynamicArray list = new DynamicArray();
		ArrayList list2 = new ArrayList();
		Random random = new Random();
		for(int i = 0; i < 10; i ++) {
			int num = random.nextInt(50);
			list.add(num);
			list2.add(num);
		}
		
		list.print();
		assertEquals(10, list.size());
		System.out.println(list.contains(20));
		//list.delIndex(3);
		list.print();
		//assertEquals(9, list.size());
		//list.clear();
		list.print();
		System.out.println(list.size());
		//list.sort();
		//list.print();
		Iterator<Integer> it = list.iterator();
		for(int i = 0; i < list2.size(); i++) {
			assertEquals(it.hasNext(), true);
			int val = it.next();
			assertEquals(val, list2.get(i));
		}
		assertEquals(list.size(), list2.size());
		list.sort();
		list.print();
		System.out.println(list.indexOf(4));
		System.out.println(list.lastIndexOf(4));
		System.out.println(list.get(5));
		assertEquals(false, list.isEmpty());
		list.delIndex(0);
		list.print();
		list.delIndex(8);
		list.print();
	}
	*/
	
	/*
	@Test
	void testHashTable() {
		HashTable list = new HashTable();
		int[] array = new int[10000];
		Random random = new Random();
		long x = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			array[i] = random.nextInt(100000);
			list.insert(array[i]);
		}
		//System.out.println(list.contains(22));
		//list.delete(22);
		//list.insert(24);
		//assertEquals(true, list.contains(24));
		//assertEquals(true, list.delete(24));
		//assertEquals(false, list.contains(24));
		for(int i = 0; i < 10000; i++) {
			list.contains(array[i]);
		}
		//System.out.println(list.contains(23));
		long y = System.nanoTime();
		System.out.println("Hash Table: " + (y - x));
		//System.out.println(Long.MAX_VALUE);
		//System.out.println(Integer.MAX_VALUE);
	}
	
	@Test
	void testDynamicArray() {
		long x = System.nanoTime();
		DynamicArray list = new DynamicArray();
		Random random = new Random();
		int[] array = new int[10000];
		for(int i = 0; i < 10000; i++) {
			array[i] = random.nextInt(100000);
			list.add(array[i]);
		}
		for(int i = 0; i < 10000; i++) {
			list.contains(array[i]);
		}
		//System.out.println(list.contains(23));
		long y = System.nanoTime();
		System.out.println("Dynamic Array: " + (y - x));
		
	}
	*/
	/*
	public int[] array() {
		int[] array = new int[10000];
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			array[i] = random.nextInt(100000);
		}
		return array;
	}
	
	@Test
	void testTiming() {
		HashTable table = new HashTable();
		DynamicArray array = new DynamicArray();
		int[] list = array();
		
		for(int i = 0; i < 10000; i++) {
			table.insert(list[i]);
		}
		long x = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			table.contains(list[i]);
		}
		long y= System.nanoTime();
		System.out.println("Hash: " + (y - x));
		
		
		for(int i = 0; i < 10000; i++) {
			array.add(list[i]);
		}
		x = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			array.contains(list[i]);
		}
		y = System.nanoTime();
		System.out.println("Dynamic: " + (y - x));
	}
	*/
	/*
	@Test
	void testHashTableChain() {
		HashTableChain table = new HashTableChain();
		Random random = new Random();
		int[] array = new int[1000];
		for(int i = 0; i < 1000; i++) {
			array[i] = random.nextInt(1000);
		}
		for(int i = 0; i < 1000; i++) {
			table.insert(array[i]);
		}
		
		for(int i = 0; i < 1000; i++) {
			assertEquals(true, table.contains(array[i]));
		}
		for(int i = 0; i < 1000; i ++) {
			table.delete(array[i]);
		}
		for(int i = 0; i < 1000; i ++) {
			assertEquals(false, table.contains(array[i]));
		}
	}
	*/
	
	@Test
	void testGraph() {
		Graph graph = new Graph();
		graph.addVertex("V1");
		graph.addVertex("V2");
		graph.addVertex("V3");
		graph.addVertex("V4");
		graph.addVertex("V5");
		graph.addEdge(3, "V1", "V2");
		graph.addEdge(2, "V1", "V3");
		graph.addEdge(5, "V2", "V3");
		graph.addEdge(6, "V4", "V3");
		graph.addEdge(1, "V5", "V2");
		assertEquals(12, graph.minimum());
		
		Graph graph2 = new Graph();
		graph2.addVertex("A");
		graph2.addVertex("B");
		graph2.addVertex("C");
		graph2.addVertex("D");
		
		graph2.addEdge(2, "A", "B");
		//graph2.addEdge(4, "A", "B");
		//graph2.addEdge(5, "B", "A");
		graph2.addEdge(3, "C", "B");
		graph2.addEdge(1, "C", "D");
		graph2.addEdge(7, "D", "A");
		assertEquals(6, graph2.minimum());
		
		graph2.printShortestPath("A", "D");
		graph2.printPath("A", "D");
	}
}
