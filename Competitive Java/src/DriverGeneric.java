
public class DriverGeneric {
	public static void main(String[] args) {
		SinglyLinkedGeneric<String> list = new SinglyLinkedGeneric<>();
		
		list.insertHead("10");
		list.print();
		list.insertAt(1, "Hello");
		list.print();
		list.insertAt(2, "ldsk");
		list.print();
		list.insertAt(3, "");
		list.print();
		list.insertAt(4, " ");
		list.print();
		list.insertAt(5, "example");
		list.print();
		list.insertTail("end");
		list.print();
		list.insertAt(8, "end2");
		list.print();
		list.removeAt(4);
		list.print();
		list.removeAt(4);
		list.print();
		list.remove("Hello");
		list.print();
		try{
			list.remove("ld");
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
