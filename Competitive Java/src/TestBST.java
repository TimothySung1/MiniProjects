
public class TestBST {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree();
		bst.insert(34);
		bst.insert(4);
		bst.insert(74);
		bst.insert(20);
		bst.insert(59);
		bst.insert(98);
		bst.insert(71);
		bst.insert(33);
		bst.insert(11);
		bst.insert(67);
		bst.print();
		System.out.println(bst.contains(20));
		System.out.println(bst.contains(2));
	}
}
