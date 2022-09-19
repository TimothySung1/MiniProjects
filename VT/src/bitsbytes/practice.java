package bitsbytes;

import java.util.BitSet;

public class practice {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet set = new BitSet(11);
		set.set(0, true);
		set.set(1, false);
		set.set(1, false);
		set.set(2, true);
		set.size();
		System.out.println(set);
		byte[] bits = set.toByteArray();
		for (byte b : bits) {
			System.out.println(b);
		}
	}

}
