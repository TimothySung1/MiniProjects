
public abstract class Heap{
	private int maxSize;
	private int size;
	protected int[] array;
	public Heap() {
		maxSize = 100;
		size = 0;
		array = new int[maxSize + 1];
	}
	
	protected abstract int compare(int num1, int num2);
	
	public int getSize() {
		return size;
	}
	
	public boolean insert(int num) {
		if(size + 1 > maxSize) {
			return false;
		}
		else {
			array[size + 1] = num;
			size++;
			int cur = size;
			while(true) {
				if(cur == 1) {
					break;
				}
				if(compare(array[cur], array[getParent(cur)]) < 0) {
					System.out.println("Swapping: " + array[cur] + " " + array[getParent(cur)]);
					swap(cur, getParent(cur));
					cur = getParent(cur);
				}
				else {
					break;
				}
			}
			return true;
		}
	}
	
	public boolean isEmpty() {
		if(size != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void peak() {
		if(size == 0) {
			System.out.println("No value");
		}
		else {
			System.out.println("Root: " + array[1]);	
		}
		
	}
	public void print() {
	 for (int i = 1; i <= size; i++) { 
		 
            System.out.print(" PARENT : " + array[i] );
            if(i * 2 <= size) {
            	System.out.print(" LEFT CHILD : " + array[2 * i]); 
            }
            else {
            	System.out.print(" LEFT CHILD : Null"); 
            }
            if(i * 2 + 1 <= size) {
            System.out.print(" RIGHT CHILD :" + array[2 * i + 1]);
            }
            else {
            	System.out.print(" RIGHT CHILD : Null");
            }
            System.out.println(); 
        } 
	}
	
	public void print2() {
		print2Helper(1);
	}
	
	public void print2Helper(int i) {
		if(i > size) {
			return;
		}
		print2Helper(getLeftChild(i));
		System.out.println(array[i]);
		print2Helper(getRightChild(i));
	}
	
	private void swap(int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
	
	private int getParent(int childPos) {
		return childPos / 2;
	}
	
	protected int getLeftChild(int parentPos) {
		return parentPos * 2;
	}
	
	protected int getRightChild(int parentPos) {
		return parentPos * 2 + 1;
	}
	
	protected abstract int getCorrectChild(int parentPos);
	
	private boolean hasChild(int parentPos) {
		if(parentPos * 2 > size && parentPos * 2 + 1 > size) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int pop() { 
		if(size == 0) {
			throw new IllegalArgumentException();
		}
		int val = array[1];
		array[1] = array[size];
		size --;
		int cur = 1;
		while(true) {
			int correctChild = getCorrectChild(cur);
			if(correctChild != -1 && compare(array[cur], array[correctChild]) > 0) {
				System.out.println("Swapping " + array[cur] + " " + array[correctChild]);
				swap(cur, correctChild);
				cur = correctChild;
			}
			else {
				break;
			}
		}
		return val;
	}
	
}
