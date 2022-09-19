
public class Driver {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.insertHead(10);
		list.print();
		list.insertAt(1, 3);
		list.print();
		list.insertAt(2, 6);
		list.print();
		list.insertAt(3, 49);
		list.print();
		list.insertAt(4, 23049);
		list.print();
		list.insertAt(5, 67);
		list.print();
		list.insertTail(23);
		list.print();
		list.insertAt(8, 20);
		list.print();
		list.removeAt(4);
		list.print();
		list.removeAt(4);
		list.print();
		list.remove(10);
		list.print();
		try{
			list.remove(4);
		} catch(IllegalArgumentException ex) {
			System.out.println("Exception was caught.");
		}
		
		list.print();
		
		
		System.out.println(list.getTail());
		System.out.println(list.getHead());
		System.out.println(list.getVal(3));
		System.out.println(list);
		list.printBackwards();
	}
}
