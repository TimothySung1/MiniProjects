
public class MinHeap extends Heap{

	@Override
	protected int compare(int num1, int num2) {
		return num1 - num2;
	}
	
	protected int getCorrectChild(int parentPos) {
		if(parentPos * 2 <= getSize() && parentPos * 2 + 1 <= getSize()) {
			System.out.println("Left child: " + getLeftChild(parentPos) + "Right child: " + getRightChild(parentPos));
			if(array[getLeftChild(parentPos)] < array[getRightChild(parentPos)]) {
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
