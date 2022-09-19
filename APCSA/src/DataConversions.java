public class DataConversions {
  public static void main(String[] args){
    //assignment conversions
	//the int integer is given an integer value of 14. Then, value is assigned to the integer value, which is converted to a double.
	int integer = 14;
    double value;
    value = integer;
    System.out.println(value);
    
    //arithmetic conversions
    //the double result is assigned to the int converted, which is multiplied by the double 2.0, and is thus converted to a double.
    double result;
    int converted = 24;
    result = converted * 2.0;
    System.out.println(result);
    
    //casting
    //The int number and double anotherNumber are added, but anotherNumber is casted to int, so it becomes 3, resulting in a sum of 15.
    int number = 12;
    double anotherNumber = 3.3;
    int sum = number + (int) anotherNumber;
    System.out.println(sum);
    
    //the int number from before is divided by the int number2. number is casted to double 12.0, so the quotient is the double 12.0 / 7.
    int number2 = 7;
    double quotient = (double) number / number2;
    System.out.println(quotient);
    
  }
}