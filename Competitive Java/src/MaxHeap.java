
public class MaxHeap extends Heap{

	@Override
	protected int compare(int num1, int num2) {
		return num2 - num1;
	}
	
	protected int getCorrectChild(int parentPos) {
		if(parentPos * 2 <= getSize() && parentPos * 2 + 1 <= getSize()) {
			if(array[getLeftChild(parentPos)] > array[getRightChild(parentPos)]) {
				return getLeftChild(parentPos);
			}
			else {
				return getRightChild(parentPos);
			}
		}
		if(parentPos * 2 <= getSize() && parentPos * 2 + 1 > getSize()) {
			return getLeftChild(parentPos);
		}
		else {
			return -1;
		}
	}
}
