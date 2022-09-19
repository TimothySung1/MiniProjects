import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Practice1 extends Practice implements Comparable<Practice1> {

	public static int counter = 0;

	private String name;

	public Practice1(int count) {
		super(count);
	}

	public Practice1(int count, String name) {
		super(count);
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name = name;
		counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return counter + " " + getCount() + " " + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Practice1 other = (Practice1) obj;
		if (getCount() != other.getCount())
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Practice1 o) {
		int cmp = getCount() - o.getCount();
		if (cmp != 0) {
			return cmp;
		}
		return name.compareTo(o.getName());
	}

	public static void main(String[] args) {
		try {
			//Practice pmother = new Practice(4);
			List<Practice1> list = new ArrayList<>();
			System.out.println(counter);
			Practice1 p1 = new Practice1(0, "Timothy");
			list.add(p1);
			p1.setCount(p1.getCount() + 1);
			System.out.println(p1);
			Practice1 p2 = new Practice1(2, "Sung");
			list.add(p2);
			System.out.println(p2);
			Practice1 p3 = new Practice1(0, "example");
			list.add(p3);
			Collections.sort(list);
			System.out.println("Practice 1 instances");
			int instance = 1;
			for (Practice1 px : list) {
				System.out.println("\t" + instance + " " + px);
				instance++;
			}

			System.out.println("Practice 1 instances");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("\t" + (i + 1) + " " + list.get(i));
			}

			System.out.println("Practice 1 instances");
			Iterator<Practice1> it = list.iterator();
			instance = 1;
			while (it.hasNext()) {
				Practice1 py = it.next();
				System.out.println("\t" + instance + " " + py);
				instance++;
			}
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Program Completed");
	}
}
