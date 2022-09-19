
public class Recursion {
	
	public static void main(String[] args) {
		/*int[] array = new int[10];
		for(int i = 1; i <= 10; i++) {
			array[i - 1] = i;
		}
		recur(array, 0);
		*/
		System.out.println(backwardsString("This is a sentence"));
	}
	
	public static void recur(int[] array, int i) {
		if(i < 0 || i >= array.length) {
			return;
		}
		
		System.out.println(array[i]);
		recur(array, i + 1);
		System.out.println(array[i]);
	}
	
	public static String backwardsString(String string) {
		//System.out.println(string);
		if(string == null) {
			return null;
		}
		if(string == "") {
			return "";
		}
		if(string.length() == 1) {
			return string;
		}
		
		return string.substring(string.length() - 1, string.length()) + backwardsString(string.substring(0, string.length() - 1));
		
	}
}
