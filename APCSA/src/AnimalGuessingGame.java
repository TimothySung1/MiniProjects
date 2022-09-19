import java.util.Scanner;

public class AnimalGuessingGame {
  public static void main(String[] args) {
    System.out.println("\n\nLet's play 20 questions. Choose an animal and I will try to guess it!");
    Scanner scan = new Scanner(System.in);
  
    System.out.println("Is it a mammal (y/n)?");
    String answer = scan.nextLine();
    if (answer.equals("y")) {
      System.out.println("Is it a pet (y/n)?");
      answer = scan.nextLine();
      if (answer.equals("y")) {
        System.out.println("Does it bark (y/n)?");
        String ans2 = scan.next();
        if (ans2.equals("y")){
          System.out.println("I guess a dog! Click on run to play again.");
        }
        else{
          System.out.println("Does it meow (y/n)?");
          String ans5 = scan.next();
          if (ans5.equals("y")){
            System.out.println("I guess a cat! Click on run to play again.");
          }
          else{
            System.out.println("I guess a hamster! Click on run to play again.");
          }
        }
       }
       else {
         System.out.println("Is it a predator (y/n)?");
         String ans3 = scan.next();
         if (ans3.equals("y")){
           System.out.println("I guess a tiger! Click on run to play again.");
         }
         else{
           System.out.println("I guess an elephant! Click on run to play again.");   
       }
       }
    }
    else { // not a mammal
      System.out.println("Does it fly (y/n)?");
      String ans4 = scan.next();
      if (ans4.equals("y")){
        System.out.println("Is it nocturnal (y/n)?");
        String ans8 = scan.next();
        if (ans8.equals("y")){
          System.out.println("I guess an owl! Click on run to play again.");
        }
        else{
          System.out.println("I guess a bird! Click on run to play again.");
        }
      }
      
      
      else{
        System.out.println("Is it a reptile (y/n)?");
        String ans6 = scan.next();
        if (ans6.equals("y")){
          System.out.println("Is it a predator (y/n)?");
          String ans7 = scan.next();
          if (ans7.equals("y")){
            System.out.println("I guess an alligator! Click on run to play again.");
          }
          else{
            System.out.println("I guess a turtle! Click on run to play again.");
          }
        }
        else{
          System.out.println("I guess a frog! Click on run to play again.");
        }
      }
    }
  }
}