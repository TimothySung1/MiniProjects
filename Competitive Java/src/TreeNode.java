
public class TreeNode<T extends Comparable<T>> {
	protected T val;
	protected TreeNode<T> left;
	protected TreeNode<T> right;	
	
	public TreeNode(T val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
}
