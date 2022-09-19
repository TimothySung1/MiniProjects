package huffman;

import java.util.BitSet;

public class AsciiBits {
	private int ascii;
	private int frequency;
	private AsciiBits right;
	private AsciiBits left;
	private byte[] bytes;
	public AsciiBits(int ascii, int frequency) {
		this.ascii = ascii;
		this.frequency = frequency;
		this.right = null;
		this.left = null;
	}
	
	public AsciiBits(int ascii, int frequency, byte[] bytes) {
		this.ascii = ascii;
		this.frequency = frequency;
		this.bytes = bytes;
		this.right = null;
		this.left = null;
		
	}
	
	public byte[] getBytes() {
		return this.bytes;
	}
	
	public void setBits(byte[] bytes) {
		this.bytes = bytes;
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
	
	public void addRight(AsciiBits character) {
		this.right = character;
	}
	
	public void addLeft(AsciiBits character) {
		this.left = character;
	}
	
	public AsciiBits getRight() {
		return this.right;
	}
	
	public AsciiBits getLeft() {
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
