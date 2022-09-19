
public class Queue<T> {
	private SinglyLinkedGeneric<T> queue;
	public Queue() {
		queue = new SinglyLinkedGeneric<>();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	public void enqueue(T val) {
		queue.insertTail(val);
	}
	public T dequeue() {
		return queue.removeHead();
	}
	public T peek() {
		return queue.getHead();
	}
	
	public void print() {
		queue.print();
	}

}
