package iteratorpractice;

import java.util.Iterator;

public class ExampleCollection<T> implements Iterable<T> {
	
	private class ExampleIterator<T> implements Iterator<T> {
		private int cursor = 0;
		public boolean hasNext() {
			return cursor <= size;
		}
		
		public T next() {
			T next = (T) get(cursor++);
			return next;
		}
		
	}
	
	protected int size;
	protected T[] array;
	
	public T get(int i) {
		T thing = array[i];
		return thing;
	}
	
	public Iterator<T> iterator(){
		return new ExampleIterator<T>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
