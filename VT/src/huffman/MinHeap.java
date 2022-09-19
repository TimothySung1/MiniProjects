package huffman;

public class MinHeap {
	private Ascii[] characters;
	private int size;
	
	public MinHeap() {
		this.characters = new Ascii[257];
		size = 0;
	}
	
	public void insert(Ascii character) {
		int index = size + 1;
		characters[index] = character;
		if (size == 0) {
			size++;
			return;
		}
		while (index > 1 && characters[index].getFrequency() < characters[getParent(index)].getFrequency()) {
			swap(index, getParent(index));
			index = getParent(index);
		}
		size++;
	}
	
	private void swap(int index1, int index2) {
		Ascii c1 = characters[index1];
		characters[index1] = characters[index2];
		characters[index2] = c1;
	}
	
	public int getParent(int index) {
		return index / 2;
	}
	
	public int getLeftChild(int index) {
		return index * 2;
	}
	
	public int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	public boolean hasChild(int index) {
		return !(characters[index * 2] == null && characters[index * 2 + 1] == null);
	}
	
	public boolean hasLeftChild(int index) {
		return !(characters[index * 2] == null);
	}
	
	public boolean hasRightChild(int index) {
		return !(characters[index * 2 + 1] == null);
	}
	
	public Ascii get(int i) {
		return characters[1];
	}
	
	public Ascii getRoot() {
		return characters[1];
	}
	
	public Ascii remove() {
		Ascii character = characters[1];
		characters[1] = null;
		swap(1, size);
		size--;
		
		int index = 1;
		
		while (hasChild(index)) {
			if (hasLeftChild(index) && hasRightChild(index)) {
				if (characters[getLeftChild(index)].getFrequency() > characters[getRightChild(index)].getFrequency() && characters[getRightChild(index)].getFrequency() < characters[index].getFrequency()) {
					swap(index, getRightChild(index));
					index = getRightChild(index);
				}
				else {
					if (characters[getLeftChild(index)].getFrequency() < characters[index].getFrequency()) {
						swap(index, getLeftChild(index));
						index = getLeftChild(index);
					}
					else {
						break;
					}
				}
			}
			else {
				if (hasRightChild(index) && characters[getRightChild(index)].getFrequency() < characters[index].getFrequency()) {
					swap(index, getRightChild(index));
					index = getRightChild(index);
				}
				else if (characters[getLeftChild(index)].getFrequency() < characters[index].getFrequency()){
					swap(index, getLeftChild(index));
					index = getLeftChild(index);
				}
				else {
					break;
				}
			}
		}
		
		return character;
	}
	
	public int getSize() {
		return this.size;
	}
	
}
