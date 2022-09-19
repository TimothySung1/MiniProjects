
public class BinarySearchTree <T extends Comparable<T>>{
	private TreeNode<T> root;
	private int size;
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	public boolean insert(T num) {
		if(root == null) {
			root = new TreeNode<T>(num);	
		}
		else {
			TreeNode<T> cur = root;
			while(cur != null) {
				int cmp = num.compareTo(cur.val);
				if(cmp < 0 ) {
					if(cur.left == null) {
						cur.left = new TreeNode<T>(num);
						break;
					}
					else {
						cur = cur.left;
					}
				}
				else if (cmp > 0){
					if(cur.right == null) {
						cur.right = new TreeNode<T>(num);
						break;
					}
					else {
						cur = cur.right;
					}
				}
				else {
					return false;
				}
			}
		}
		size ++;
		return true;
	}
	
	public boolean contains(T num) {
		TreeNode<T> cur = root;
		while(cur != null) {
			int cmp = num.compareTo(cur.val);
			if(cmp < 0) {
				cur = cur.left;
				
			}
			else if(cmp > 0) {
					cur = cur.right;
				}
			else {
				return true;
			}
		}
	return false;
	}
	
	/*public String toString() {
		
	}
	*/
	
	public void print() {
		printHelper(root);
		System.out.println();
	}
	
	private void printHelper(TreeNode node) {
		if(node != null) {
			printHelper(node.left);
			System.out.print(node.val + " ");
			printHelper(node.right);
		}
	}
	
	public int height() {
		return heightHelper(root);
	}
	
	private int heightHelper(TreeNode node) {
		if(node != null) {
			return Math.max(heightHelper(node.right), heightHelper(node.left)) + 1;
		}
		else {
			return 0;
		}
		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
