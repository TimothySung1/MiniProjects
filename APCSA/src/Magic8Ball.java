import java.util.Scanner;  // added to allow keyboard input
class Magic8Ball {
  public static void main(String[] args) {
     // Tell the user to enter a question
     Scanner scan = new Scanner(System.in);
     System.out.println("Welcome to the Magic 8 Ball!");
     System.out.print("Enter your question and I will answer it: ");
     String question = scan.nextLine();
     
     System.out.println("In response to your question:  " + question);
     // Get a random number from 1 to 8
     int number = (int) (Math.random() * 8 + 1);
     // Use if statements to print out 1 of 8 responses
     if (number == 1){
       System.out.println("You should go for it");
     }
     
     if (number == 2){
       System.out.println("I would reconsider your options");
     }
     
     if (number == 3){
       System.out.println("Yes");
     }
     
     if (number == 4){
       System.out.println("No");
     }
     
     if (number == 5){
       System.out.println("Without a doubt");
     }
     
     if (number == 6){
       System.out.println("You should shake again");
     }
     
     if (number == 7){
       System.out.println("You should wait it out");
     }
     
     if (number == 8){
       System.out.println("Do it now or soon");
     }
     
     
  }
}