
public class Stack<T> {
	private SinglyLinkedGeneric<T> stack;
	public Stack() {
		stack = new SinglyLinkedGeneric<>();
	}
	
	public void push(T val) {
		stack.insertHead(val);
	}
	public T pop() {
		return stack.removeHead();
	}
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	public T peek() {
		return stack.getHead();
	}
	
	public void print() {
		stack.print();
	}
}
