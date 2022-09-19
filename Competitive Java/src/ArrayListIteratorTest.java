import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteratorTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("something");
		list.add("second string");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it.next();
		
	}
	
	
}
