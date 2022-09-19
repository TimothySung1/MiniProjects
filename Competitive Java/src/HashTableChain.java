import java.util.ArrayList;

public class HashTableChain {
	public static final int DEFAULT_SIZE = 13000;
	private int size;
	private ArrayList<Integer>[] array;

	public HashTableChain() {
		size = 0;
		array = (ArrayList<Integer>[]) new ArrayList<?>[DEFAULT_SIZE];
	}
	
	public int hash(int val) {
		//System.out.println(array);
		//System.out.println(array.length);
		//System.out.println(val);
		int index = val % array.length;
		return index;
	}

	public void resize() {
		ArrayList<Integer>[] temp = array;
		array = new ArrayList[array.length * 2];
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				for(int j = 0; j < temp[i].size(); j++) {
					if(temp[i].get(j) != null) {
						insert(temp[i].get(j));
					}
				}
			}
		}
	}
	
	public void insert(int val) {
		int index = hash(val);
		if (array[index] == null){
			array[index] = new ArrayList<Integer>();
		}
		array[index].add(val);
		size++;
		if (size >= array.length * .75) {
			resize();
		}
	}
	
	public boolean delete(int val) {
		//System.out.println(size);
		int index = hash(val);
		Integer num = new Integer(val);
		if (array[index] != null) {
			boolean del = array[index].remove(num);
			if(del) {
				size--;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		//System.out.println(array[index]);
		//System.out.println(index);
		
		//System.out.println(size);
		//System.out.println(array[index]);
		
	}

	public boolean contains(int val) {
		int index = hash(val);
		int loop = 0;
		//System.out.println(array);
		//System.out.println(index);
		//System.out.println(val);
		//System.out.println(array[index]);
		while (true) {
			//array[index] != val || array[index] == null
			if (array[index] == null) {
				return false;
			}
			if (array[index].contains(val)) {
				break;
			}
			index++;
			if (index == array.length) {
				index = 0;
			}
			if (loop == array.length) {
				return false;
			}
			loop++;
			//System.out.println("array: " + array);
			//System.out.println("index: " + index);
			//System.out.println("val: "  + val);
			//System.out.println("array[index]: " + array[index]);
		}
		//System.out.println(array);
		//System.out.println(index);
		//System.out.println(val);
		//System.out.println(array[index]);
		return true;
	}
	
}
