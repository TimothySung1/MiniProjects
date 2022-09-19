//****************************************************************
// StringPractice.java                  String practice, Chapter 2
// for use in String 1 practice
//  Author:  Pam Whitlock               Date: Sept 5, 2017
//
// Practice String methods on page 78
//****************************************************************

public class StringPractice
{
  public static void main(String [] args)
  {
   //Declaring and instantiating String objects.  Instantiate means to create the object & give it a value
      //One way of creating a String object
      String firstName = new String ("Mickey");
    
      //Shortcut notation of creating a String object
      String lastName = "Mouse";
      
      //Example of concatenation and intention revealing output
      System.out.println("The first name is:  " + firstName);
      System.out.println("The last name is:  " + lastName);
      
//    In this lab, you are going to create String objects (either format of instantiation is ok) and practice calling 
//      some of the String methods on page 78.  Create output that shows what you have done.  You can use the sample code
//      on page 79 as a model.  Write your code under the appropriate comment section below.
      
      //Declare and instantiate four String objects.  Output their values in such a way that I know what the variable represents
      String myFirstName = "Timothy";
      String myLastName = "Sung";
      String verb = "sits";
      String setting = "house";
      System.out.println("myFirstName: " + myFirstName);
      System.out.println("myLastName: " + myLastName);
      System.out.println("verb: " + verb);
      System.out.println("setting: " + setting);
      System.out.println("Sentence: ");
      System.out.println(myFirstName + " " + myLastName + " " + verb + " in a " + setting);
           
      //add three blank lines to format output      
      System.out.println("\n\n");
      //Call the length method on one of your String objects and output intention revealing results.  Put your code below
      int firstLength = myFirstName.length();
      System.out.println("The length of my first name is: " + firstLength);
      
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the charAt method on one of your String objects and output intention revealing results.  Put your code below
      char letter4 = myLastName.charAt(3);
      System.out.println("The 4th letter (index 3) in my last name is: " + letter4);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the concat method on one of your String objects and output intention revealing results.  Put your code below
      String settingConcat = setting.concat(" nearby");
      System.out.println("The setting with 'nearby' added to it is: " + settingConcat);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the indexOf method one of your String objects and output intention revealing results.  Do this twice...
      //once for something that you know exists in your String and once for something that does not
      //exist in your String.Put your code below
      int hInSetting = setting.indexOf("h");
      int xInSetting = setting.indexOf("x");
      System.out.println("The 'h' in " + setting + " is at index " + hInSetting);
      System.out.println("The 'x' in " + setting + " is at index " + xInSetting);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the charAt method on one of your String objects and output intention revealing results.  Put your code below
      char letter3 = verb.charAt(2);
      System.out.println("The 3rd letter (index 2) in the verb is: " + letter3);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the replace method on one of your String objects and output intention revealing results.  Put your code below
      
      String settingHtoJ = myFirstName.replace('h','j');
      System.out.println("The setting with 'j' instead of 'h' is: " + settingHtoJ);
      
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the toLowerCase method on one of your String objects and output intention revealing results.  Put your code below
      
      String lowerFirst = myFirstName.toLowerCase();
      System.out.println("My first name with all lower case letters is: " + lowerFirst);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the toUpperCase method on one of your String objects and output intention revealing results.  Put your code below
      
      String upperLast = myLastName.toUpperCase();
      System.out.println("My last name with all upper case letters is: " + upperLast);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the substring method that has one parameter on one of your String objects and output intention revealing results.  Put your code below
      
      String subVerb = verb.substring(2);
      System.out.println("The verb starting at the 3rd letter (index 2) is: " + subVerb);
      
      //add three blank lines to format output
      System.out.println("\n\n");
      //call the substring method  that has two parameters on one of your String objects and output intention revealing results.  Put your code below
      
      String subSetting = setting.substring(2, 5);
      System.out.println("The part of the setting from letters 3 - 5 (index 2 - 5, 5 exclusive) is: " + subSetting);
      
  }
}