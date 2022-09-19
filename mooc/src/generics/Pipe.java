package generics;

import java.util.ArrayList;

public class Pipe<T> {
	ArrayList<T> stuff;
	public Pipe() {
		this.stuff = new ArrayList<T>();
	}
	
	public void putIntoPipe(T value) {
		this.stuff.add(value);
	}
	
	public T takeFromPipe() {
		if (this.stuff.size() == 0) {
			return null;
		}
		T temp = this.stuff.get(0);
		this.stuff.remove(0);
		return temp;
	}
	
	public boolean isInPipe() {
		if (this.stuff.size() > 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipe<Integer> numberPipe = new Pipe<>();
		numberPipe.putIntoPipe(1);
		numberPipe.putIntoPipe(2);
		numberPipe.putIntoPipe(3);

		int sum = 0;
		while(numberPipe.isInPipe()) {
		    sum = sum + numberPipe.takeFromPipe();
		}
		System.out.println(sum);
		System.out.println(numberPipe.takeFromPipe());
	}

}
