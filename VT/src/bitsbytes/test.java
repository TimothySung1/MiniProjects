package bitsbytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//write byte to a file
		File file = new File("test.txt");
		FileOutputStream stream = new FileOutputStream(file);
		byte[] bytes = new byte[6];
		byte b = 0;
		for (int i = 0; i < 5; i++) {
			bytes[i] = b;
			b ++;
		}
		bytes[5] = -17;
		for (byte by : bytes) {
			System.out.println(by);
		}
		stream.write(bytes);
		stream.close();
		FileInputStream input = new FileInputStream(file);
		byte[] bytes2 = input.readAllBytes();
		for (byte by : bytes2) {
			System.out.println(by);
			System.out.println(Integer.toBinaryString(by));
		}
		if (bytes2.equals(bytes)) {
			System.out.println("Equal");
		}
		input.close();
	}

}
