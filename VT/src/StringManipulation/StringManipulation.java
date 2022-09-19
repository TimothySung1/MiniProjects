package StringManipulation;

import java.util.Scanner;

public class StringManipulation {
	
	public static final String START_STRING = "abc def";
		/**
		* Prints the provided ‘errorMessage‘, then reminds the
		* user what all the commands are and how to use them.
		* You do not need to edit this function.
		*/
	public static void printHelp(String errorMessage)
	{
		System.err.println(errorMessage);
		System.err.println("Usage - enter one of the following Commands:");
		System.err.println();
		System.err.println("searchText [text]: prints the index of [text] in "
		+ "the String, leaves it unchanged.");
		System.err.println("removeText [text] - deletes all occurences of "
		+ "[text] in the String.");
		System.err.println("addText [i] [text] - first argument is an integer "
		+ "between 0 and and the length of the string; "
		+ "adds [text] at that location in the string.");
		System.err.println("reverseText [no argument] - makes the string into "
		+ "its mirror image.");
		System.err.println("reverseEachWord [no argument] - like reverseText "
		+ "but applies to each command word individually.");
		System.err.println("printString [no argument] - prints the current "
		+ "value of the string.");
		System.err.println("enterNewString [text] - overwites whatever the "
		+ "string was with [text] instead.");
		System.err.println("quit [no argument] - exits the program.");
		System.err.println("");
	}
	/**
	* Implements the "printString" command. This command doesn’t change
	* theString, so we just return what it was.
	*/
	public static String printString(String oldString, String[] commandWords)
	{
		System.out.println(oldString);
		return oldString;
	}
	/**
	* A useful function, combines all of the words in ‘words‘ starting from
	* ‘index‘. You do not need to edit this function.
	*/
	private static String combineWordsFrom(String[] words, int index)
	{
		String newString = "";
		for(int i = index; i < words.length; i+=1){
			if(i > index)
			{
				newString += " ";
			}
			newString += words[i];
		}
		return newString;
	}
	public static String searchText(String oldString, String[] commandWords)
	{
		// You should search the string "oldString" for the text found in "
		//commandWords" starting from index 1 to the end of the string array
		// 1. First check if the length of commandWords is less than 2. If it is, then
		//print an error using printHelp and return null.
		// 2. Get the text you need to search oldString for. Use combineWordsFrom(
		//commandWords,1) to get the appropriate text.
		// 3. Print out the index where the text is found in oldString (or -1 if not
		//found). Use the String function indexOf for this.
		// 4. Return null (since searchText does not change the current string).
		if (commandWords.length < 2) {
			printHelp("Command words less than 2");
			return null;
		}
		String text = combineWordsFrom(commandWords, 1);
		int index = oldString.indexOf(text);
		System.out.println(index);
		return null;
	}
	public static String removeText(String oldString, String[] commandWords)
	{
		// You should remove from "oldString" all instances of the text found in
		//"commandWords" starting from index 1 to the end of the string array
		// 1. First check if the length of commandWords is less than 2. If it is, then
		//print an error using printHelp and return null.
		// 2. Get the text you need to remove from oldString. Use combineWordsFrom(
		//commandWords,1) to get the appropriate text.
		// 3. Remove the text from oldString using the String function replaceAll.
		// 4. Return the String that is returned from the replaceAll function.
		if (commandWords.length < 2) {
			printHelp("Command words less than 2");
			return null;
		}
		
		String text = combineWordsFrom(commandWords, 1);
		oldString = oldString.replaceAll(text, "");
		return oldString;
	}
	public static String addText(String oldString, String[] commandWords)
	{
		// You should add text to "oldString" at a specific index
		// 1. First check if the length of commandWords is less than 3. If it is, then
		//print an error using printHelp and return null.
		// 2. Get the text you need to add to oldString. Use combineWordsFrom(
		//commandWords,2) to get the appropriate text.
		// 3. Get the index using "Integer.parseInt(commandWords[1])".
		// 4. Check if the index is in the correct range (greater than 0, and less
		//than or equal to oldString’s length). If not, print an error using
		//printHelp and return null.
		// 5. Return oldString.substring(parameters) + text + oldString.substring(
		//parameters) using the correct parameters for substring.
		if (commandWords.length < 2) {
			printHelp("Command words less than 2");
			return null;
		}
		
		String text = combineWordsFrom(commandWords, 2);
		int index = Integer.parseInt(commandWords[1]);
		if (index < 1 || index > oldString.length()) {
			printHelp("Invalid index");
			return null;
		}
		String newText = oldString.substring(0, index) + text + oldString.substring(index, oldString.length());
		///System.out.println(newText);
		return newText;
	}
	private static String reverseString(String s)
	{
		// Make the utility function reverseString which reverses a single string
		// 1. Create a new StringBuilder object, and initialize it with "s"
		// 2. Call reverse() on the StringBuilder object, then toString()
		// 3. Return the resulting String from step 2
		// Note: An alternative way of doing this is to traverse the string in reverse
		//using a for loop and the function charAt, and to build the string in
		//reverse character by character
		StringBuilder builder = new StringBuilder(s);
		String newText = builder.reverse().toString();
		//System.out.println(newText);
		return newText;
	}
	public static String reverseText(String oldString, String[] commandWords)
	{
		// This function is already completed, as long as reverseString is correctly
		//implemented.
		// Note: It was a design choice to not error out if arguments were erroneously
		//included.
		
		return reverseString(oldString);
	}
	public static String reverseEachWord(String oldString, String[] commandWords)
	{
		// Reverse each individual word in oldString using the reverseString
		//function which you filled in
		// 1. Call split(" ") on oldString (split up the string on space), and store
		//the result in a String array
		// 2. Create a new empty string called result (i.e., String result = "")
		// 3. Create a for loop and iterate over each element of the String array from
		//step 1
		// 4. Within the loop, if the index is greater than 0, add a blank space to
		//result (i.e., result += " ")
		// 5. Within the loop, add the reversed version of the array String to result
		//(i.e., result += reverseString(array[i]))
		// 6. Return result
		// Note: It was a design choice to not error out if arguments were erroneously
		//included.
		
		String[] array = oldString.split(" ");
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				result += " ";
			}
			result += reverseString(array[i]);
		}
		return result;
	}
	/**
	* Implements the "enterNewString" command. You probably want to
	* create a similar function for each string command. Note that
	* ‘oldString‘ is ignored by this particular command/function.
	*/
	public static String enterNewString(String oldString, String[] commandWords)
	{
		// This command needs an argument after the command; if it’s missing
		// that’s an error.
		if (commandWords.length < 2)
		{
			printHelp("enterNewString - requires an argument");
			return null;
		}
		return combineWordsFrom(commandWords, 1);
	}
	/**
	* This method should return the result of applying the string command
	* represented by ‘commandWords‘, or else null (if the command was not
	* recognized or the wrong arguments were supplied). When returning
	* null, an appropriate error message should first be printed (use
	* printHelp()).
	*/
	public static String handleStringCommand(String oldString, String[] commandWords)
	{
		if ("searchText".equals(commandWords[0]))
		{
			return searchText(oldString, commandWords);
		}
		else if ("removeText".equals(commandWords[0]))
		{
			return removeText(oldString, commandWords);
		}
		else if ("addText".equals(commandWords[0]))
		{
			return addText(oldString, commandWords);
		}
		else if ("reverseText".equals(commandWords[0]))
		{
			return reverseText(oldString, commandWords);
		}
		else if ("reverseEachWord".equals(commandWords[0]))
		{
			return reverseEachWord(oldString, commandWords);
		}
		else if ("printString".equals(commandWords[0]))
		{
			return printString(oldString, commandWords);
		}
		else if ("enterNewString".equals(commandWords[0]))
		{
			return enterNewString(oldString, commandWords);
		}
		else
		{
			printHelp("Unknown command: "+commandWords[0]);
			return null;
		}
	}
	public static void main(String args[])
	{
		String theString = START_STRING;
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		do
		{
			System.out.print("Enter Command: ");
			String line = s.nextLine();
			String[] commandWords = line.split(" ");
			// Handle "quit" specially.
			if ("quit".equals(commandWords[0]))
			{
				run = false;
			}
			else
			{
				// Everything besides quit should be a command that alters
				// ‘theString‘.
				String newString = handleStringCommand(theString, commandWords);
				if (newString != null)
				{
					theString = newString;
				}
			}
		} while(run == true);
	}

}
