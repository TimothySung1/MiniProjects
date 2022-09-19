import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray implements Iterable{
	public static final int DEFAULT_CAPACITY = 13000;
	private int[] array;
	private int size;
	private boolean shrink;
	DynamicArray(){
		array = new int[DEFAULT_CAPACITY];
		size = 0;
		shrink = true;
	}
	
	DynamicArray(int capacity) {
		array = new int[capacity];
		size = 0;
		shrink = false;
		
	}
	public void print() {
		System.out.print("Array: ");
		for(int i = 0; i < size; i ++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void add(int num) {
		resize();
		array[size] = num;
		size ++;
	}
	
	public void delVal(int num) {
		int location = 0;
		for(int i = 0; i < size; i ++) {
			if(array[i] == num) {
				location = i;
			}
		}
		for(int i = location; i < size - 1; i++) {
			array[location] = array[location + 1];
		}
		size --;
		resize();
	}
	
	public boolean contains(int num) {
		for(int i = 0; i < size; i ++) {
			if(array[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	private void resize() {
		int newSize = array.length;
		if(size == array.length) {
			newSize = size * 2;
		}
		
		else if(size * 2 <= array.length && shrink) {
			newSize = size / 2;
			if (newSize < DEFAULT_CAPACITY) {
				newSize = DEFAULT_CAPACITY;
			}
		}
		if(newSize == array.length) {
			return;
		}
		int[] array2 = new int[newSize];
		for (int i = 0; i < size; i ++) {
			array2[i] = array[i];
		}
		array = array2;
	}
	
	public void clear() {
		//remove all elements
		array = new int[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public int get(int i) {
		//get value at particular index
		return array[i];
	}
	
	public int indexOf(int num) {
		//give index of first occurrence
		for(int i = 0; i < size; i++) {
			if(array[i] == num) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int lastIndexOf(int num) {
		for(int i = size - 1; i >= 0; i--) {
			if(array[i] == num) {
				return i;
			}
		}
		return -1;
	}
		
	public void delIndex(int i) {
		for(int j = i; j < size; j++) {
			array[j] = array[j + 1];
		}
		resize();
		size --;
	}
	
	public void sort() {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < size - 1; i++) {
				if (array[i] > array[i + 1]) {
					int num = array[i];
					array[i] = array[i + 1];
					array[i + 1] = num;
					sorted = false;
				}
			}
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new DynamicArrayIterator();
	}

	class DynamicArrayIterator implements Iterator<Integer>{
		int index;
		public DynamicArrayIterator(){
			index = 0;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (index == size) {
				return false;
			}
			return true;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if(index == size) {
				throw new NoSuchElementException();
			}
			index ++;
			Integer num = Integer.valueOf(array[index - 1]);
			return num;
		}
		
	}
	
}
