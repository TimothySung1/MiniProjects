
public class HashTable {
	public static final int DEFAULT_SIZE = 13000;
	private int size;
	private Integer[] array;

	public HashTable() {
		size = 0;
		array = new Integer[DEFAULT_SIZE];
	}
	
	public int hash(int val) {
		//System.out.println(array);
		//System.out.println(array.length);
		//System.out.println(val);
		int index = val % array.length;
		return index;
	}

	public void resize() {
		Integer[] temp = array;
		array = new Integer[array.length * 2];
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				insert(temp[i]);
			}
		}
	}
	
	public void insert(int val) {
		int index = hash(val);
		while (array[index] != null) {
			index++;
			if (index == array.length) {
				index = 0;
			}
		}
		array[index] = val;
		size++;
		if (size >= array.length * .75) {
			resize();
		}
	}
	
	public boolean delete(int val) {
		//System.out.println(size);
		int index = hash(val);
		while (array[index] != val) {
			if(array[index] == null) {
				return false;
			}
			index++;
			if (index == array.length) {
				index = 0;
			}
		}
		//System.out.println(array[index]);
		//System.out.println(index);
		array[index] = -1;
		size--;
		//System.out.println(size);
		//System.out.println(array[index]);
		return true;
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
			if (array[index] == val) {
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
