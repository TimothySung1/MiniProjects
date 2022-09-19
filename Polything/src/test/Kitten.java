package test;

public class Kitten {
	private String name = "";
	public Kitten(String name) {
		name = name;
	}
	public String toString() {
		return "Kitten: " + name;
	}
	public boolean equals(Object other) {
		if (this == other) return true;
		if (null == other) return false;
		if (!(other instanceof Kitten)) return false;
		Kitten that = (Kitten) other;
		return this.name.equals(that.name);
	}
}