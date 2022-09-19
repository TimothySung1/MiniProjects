package equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Foo {
	
	private int id;
	private boolean io;
	
	public Foo(int id, boolean io) {
		this.id = id;
		this.io = io;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean getIO() {
		return this.io;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || !(o instanceof Foo)) return false;
		Foo other = (Foo) o;
		return this.id == other.id && this.io == other.io;
		//return this.id == other.getID() && this.io == other.getIO();
	}
	
	/*
	@Override
	public int hashCode() {
		return this.id / (io ? 2 : 1);
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo thing = new Foo(3, true);
		Foo thing2 = new Foo(3, true);
		Foo thing3 = new Foo(4, false);
		List<Foo> foolist = new ArrayList<>();
		foolist.add(thing);
		foolist.add(thing2);
		foolist.add(thing3);
		System.out.println(thing.equals(thing2));
		//returns true because lists and non hash collections only use equals
		System.out.println(foolist.contains(new Foo(3, true)));
		Set<Foo> fooset = new HashSet<>(foolist);
		//this returns false because no hashcode() implementation, would return true if uncomment hashcode method
		System.out.println(fooset.size());
		System.out.println(fooset.contains(new Foo(3, true)));
	}

}
