package huffman;

public class Ascii {
	private int ascii;
	private int frequency;
	private Ascii right;
	private Ascii left;
	private String bits;
	public Ascii(int ascii, int frequency) {
		this.ascii = ascii;
		this.frequency = frequency;
		this.right = null;
		this.left = null;
	}
	
	public Ascii(int ascii, int frequency, String bits) {
		this.ascii = ascii;
		this.frequency = frequency;
		this.bits = bits;
		this.right = null;
		this.left = null;
	}
	
	public String getBits() {
		return this.bits;
	}
	
	public void setBits(String bits) {
		this.bits = bits;
	}
	
	public void setAscii(int ascii) {
		this.ascii = ascii;
	}
	
	public int getAscii() {
		return this.ascii;
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public void incFrequency() {
		this.frequency++;
	}
	
	public void addRight(Ascii character) {
		this.right = character;
	}
	
	public void addLeft(Ascii character) {
		this.left = character;
	}
	
	public Ascii getRight() {
		return this.right;
	}
	
	public Ascii getLeft() {
		return this.left;
	}
	
	public boolean hasLeft() {
		return (this.left != null);
	}
	
	public boolean hasRight() {
		return (this.right != null);
	}
	
	public String toString() {
		return "Ascii: + " + this.ascii + " Frequency: " + this.frequency;
	}
}
