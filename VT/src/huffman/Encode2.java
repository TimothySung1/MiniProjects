package huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Encode2 {
	public static MinHeap asciiCharacters = new MinHeap();
	public static String[] asciiCodes = new String[256];
	//counts the frequency of letters in a text file, adds character to asciiCharacters
	public static void count(Scanner scanner) {
		//System.out.println("count");
		Ascii[] characters = new Ascii[256];
		for (int i = 0; i < 256; i++) {
			characters[i] = new Ascii(i, 0);
		}
		
		while(scanner.hasNextLine()) {
			String stringLine = scanner.nextLine();
			if (scanner.hasNextLine()) {
				stringLine = stringLine + "\n";
			}
			char[] line = stringLine.toCharArray();
			for (char character : line) {
				System.out.println(character);
				characters[(int)character].incFrequency();
				System.out.println(characters[character]);
			}
			
		}
		
		for (Ascii character : characters) {
			//System.out.println(character);
			if (character.getFrequency() > 0) {
				//System.out.println(character);
				asciiCharacters.insert(character);
			}
			
		}
		//System.out.println("end of count");
	}
	
	//makes huffman tree
	public static void makeHuffmanTree() {
		while (asciiCharacters.getSize() > 1) {
			Ascii c1 = asciiCharacters.remove();
			Ascii c2 = asciiCharacters.remove();
			Ascii both = new Ascii(' ', c1.getFrequency() + c2.getFrequency());
			if (c1.getFrequency() > c2.getFrequency()) {
				both.addLeft(c2);
				both.addRight(c1);
			}
			else {
				both.addRight(c2);;
				both.addLeft(c1);
			}
			asciiCharacters.insert(both);
		}
		
		System.out.println("Starting tree: ");
		printTree(asciiCharacters.get(0));
		
	}
	
	//gets the binary code for each ascii character depending on frequency, adding it to asciiCodes array.
	public static void getAsciiCodes(StringBuilder builder, Ascii node) {
		
		
		//check leafnode
		if (node.hasLeft() || node.hasRight()) {
			//go left first, then right.
			if (node.hasLeft()) {
				getAsciiCodes(builder.append("0"), node.getLeft());
				builder.deleteCharAt(builder.length() - 1);
			}
			if (node.hasRight()) {
				builder.append("1");
				getAsciiCodes(builder, node.getRight());
				builder.deleteCharAt(builder.length() - 1);
			}
		}
		else {
			asciiCodes[node.getAscii()] = builder.toString();
		}
		
		
	}
	
	public static void printAsciiCodes() {
		for (int i = 0; i < 256; i++) {
			System.out.println("Ascii: " + i + " Code: " + asciiCodes[i]);
		}
	}
	
	/*
	public static void recreateHuffmanTree() {
		MinHeap tree = new MinHeap();
		for (int i = 0; i < 256; i++) {
			if (asciiCodes[i] != null) {
				int index = 1;
				char[] code = asciiCodes[i].toCharArray();
				for (int j = 0; j < code.length; j++) {
					if (code[j] == '0') {
						if (tree.hasLeftChild(index)) {
							index = tree.getLeftChild(index);
						}
					}
					else {
						if (tree.hasRightChild(index)) {
							index = tree.getRightChild(index);
						}
					}
				}
			}
		}
	}
	*/
	
	public static void encode(Scanner scanner) throws IOException {
		File file = new File("code.txt");
		FileWriter writer = new FileWriter(file);
		for (int i = 0; i < 256; i++) {
			writer.write(asciiCodes[i] + "\n");
		}
		
		int size = 0;
		ArrayList<Character> list = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if (scanner.hasNextLine()) {
				line += "\n";
			}
			char[] characters = line.toCharArray();
			
			for (char character : characters) {
				size++;
				list.add(character);
				//System.out.print(character);
			}
			
			
		}
		/*
		for (char character : list) {
			System.out.println(character + ": " + asciiCodes[character]);
		}
		*/
		writer.write(size + "\n");
		byte b = 0;
		
		String code = "";
		for (char character : list) {
			//get the string code of 0s and 1s
			//System.out.println(character + ": " + asciiCodes[character]);
			code += asciiCodes[character];
			//get character "bit" into an actual bit into byte b.
		}
		int counter = 0;
		System.out.println("Encoding...");
		ArrayList<Byte> bytesList = new ArrayList<>();
		for (char ch : code.toCharArray()) {
			//System.out.println(ch);
			b = (byte) (b << 1);
			if (ch == '1') {
				b = (byte) (b | 1);
			}
			counter++;
			if (counter == 8) {
				writer.write(b);
				bytesList.add(b);
				System.out.println("Byte: " + b);
				b = 0;
				counter = 0;
			}
		}
		if (counter > 0) {
			b = (byte) (b << (8 - counter));
			writer.write(b);
			bytesList.add(b);
			System.out.println("End: " + b);
		}
		byte[] bytes = new byte[bytesList.size()];
		for (int i = 0; i < bytesList.size(); i++) {
			bytes[i] = bytesList.get(i);
		}
		File bytesFile = new File("byte.txt");
		FileOutputStream stream = new FileOutputStream(bytesFile);
		stream.write(bytes);
		writer.close();
	}
	
	//decodes from file with just 0s and 1s
	public static void decode(Scanner scanner) throws IOException{
		System.out.println("decoding...");
		//ascii contains the "bits" for each index (ascii value), null means not used.
		String[] ascii = new String[256];
		
		Ascii root = new Ascii(256, 0);
		
		//set ascii per info in code.txt
		for (int i = 0; i < 256; i++) {
			ascii[i] = scanner.nextLine();
		}
		//System.out.println(ascii[115]);
		int size = Integer.parseInt(scanner.nextLine());
		System.out.println("size: " + size);
		//recreate tree
		for (int i = 0; i < 256; i++) {
			if (!ascii[i].equals("null")) {
				//get the code for each used ascii
				char[] code = ascii[i].toCharArray();
				Ascii curnode = root;
				for (int j = 0; j < code.length; j++) {
					//if it's the first bit
					if (j == 0) {
						
						if (code[j] == '0') {
							if (root.hasLeft()) {
								curnode = root.getLeft();
							}
							else {
								//if only one bit
								if (code.length == 1) {
									root.addLeft(new Ascii(i, 0, ascii[i]));
								}
								else {
									root.addLeft(new Ascii(' ', 0));
									curnode = root.getLeft();
								}
								
							}
						}
						//if bit == 1
						else {
							if (root.hasRight()) {
								curnode = root.getRight();
							}
							else {
								//if only one bit
								if (code.length == 1) {
									root.addRight(new Ascii(i, 0, ascii[i]));
									
								}
								else {
									root.addRight(new Ascii(' ', 0));
									curnode = root.getRight();
								}
							}
						}
					}
					//if not first bit
					else {
						if (code[j] == '0') {
							if (curnode.hasLeft()) {
								curnode = curnode.getLeft();
								
							}
							else {
								//if last bit
								if (j == code.length - 1) {
									curnode.addLeft(new Ascii(i, 0, ascii[i]));
								}
								else {
									curnode.addLeft(new Ascii(' ', 0));
									curnode = curnode.getLeft();
								}
								
							}
						}
						//if bit == 1;
						else {
							if (curnode.hasRight()) {
								curnode = curnode.getRight();
								
							}
							else {
								//if last bit
								if (j == code.length - 1) {
									
									curnode.addRight(new Ascii(i, 0, ascii[i]));
								}
								else {
									curnode.addRight(new Ascii(' ', 0));
									curnode = curnode.getRight();
								}
								
							}
						}
					}
					
					
					
				}
			}
		}
		//code is the char array of the not decoded code text at the bottom of code.txt
		//char[] code = scanner.nextLine().toCharArray();
		
		System.out.println("Decode tree: ");
		printTree(root);
		//start decode
		int charsDecoded = 0;
		Ascii curnode = root;
		
		String decodedText = "";
		
		String binary = "";
		System.out.println("Decoding code");
		
		File fileBytes = new File("byte.txt");
		FileInputStream stream = new FileInputStream(fileBytes);
		//Scanner scannerBytes = new Scanner(fileBytes);
		
		byte[] bytes = stream.readAllBytes();
		for (byte b : bytes) {
			System.out.println("Byte: " + b);
			String bin = Integer.toBinaryString(b);
			if (bin.length() > 8) {
				bin = bin.substring(bin.length() - 8, bin.length());
			}
			
			while (bin.length() < 8) {
				bin = "0" + bin;
			}
			System.out.println("Bits: " + bin + "\n");
			binary += bin;
		}
		/*
		while (scannerBytes.hasNextByte()) {
			System.out.println("has byte");
			byte byt = scannerBytes.nextByte();
			binary += String.valueOf(byt);
		}
		*/
		//byte ex = scanner.nextByte();
		//System.out.println(scanner.nextByte());
		//System.out.println(scanner.nextLine());
		/*
		for (char character : code) {
			System.out.println(character);
			String b = Integer.toBinaryString(character);
			while (b.length() < 8) {
				b = "0" + b;
			}
			binary += b;
			System.out.println(b);
		}
		*/
		System.out.println(binary);
		char[] bits = binary.toCharArray();
		String decodedBits = "";
		for (char bit : bits) {
			if (bit == '0') {
				curnode = curnode.getLeft();
				if (curnode.getLeft() == null && curnode.getRight() == null) {
					System.out.println((char) curnode.getAscii());
					System.out.println("ascii: " + curnode.getAscii());
					System.out.println("bits: " + curnode.getBits());
					decodedBits += curnode.getBits() + " ";
					decodedText += (char) curnode.getAscii();
					charsDecoded++;
					curnode = root;
				}
			}
			else {
				curnode = curnode.getRight();
				if (curnode.getLeft() == null && curnode.getRight() == null) {
					System.out.println((char) curnode.getAscii());
					System.out.println("ascii: " + curnode.getAscii());
					System.out.println("bits: " + curnode.getBits());
					decodedText += (char) curnode.getAscii();
					decodedBits += curnode.getBits() + " ";
					charsDecoded++;
					curnode = root;
				}
			}
			if (charsDecoded == size) {
				break;
			}
		}
		System.out.println(decodedText);
		System.out.println(decodedBits);
	}
	
	private static void printTree(Ascii node) {
		if (node == null) {
			return;
		}
		if (node.hasLeft() == false && node.hasRight() == false) {
			System.out.println("Ascii: " + node.getAscii());
			System.out.println("Bit: " + node.getBits());
			return;
		}
		if (node.hasLeft()) {
			System.out.println("left");
			printTree(node.getLeft());
		}
		if (node.hasRight()) {
			System.out.println("right");
			printTree(node.getRight());
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		File file = new File("text.txt");
		Scanner scanner = new Scanner(file);
		count(scanner);
		makeHuffmanTree();
		//System.out.println(asciiCharacters.getSize());
		String code = "";
		StringBuilder builder = new StringBuilder(code);
		Ascii root = asciiCharacters.getRoot();
		getAsciiCodes(builder, root);
		//printAsciiCodes();
		Scanner scanner2 = new Scanner(file);
		encode(scanner2);
		
		File codefile = new File("code.txt");
		Scanner codescanner = new Scanner(codefile);
		decode(codescanner);
		
	}
}
