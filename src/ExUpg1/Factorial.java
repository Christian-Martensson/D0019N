// @author christianmartensson

package ExUpg1;

//import of the scanner class, used later for input from user.
import java.util.Scanner; 


public class Factorial {
    public static void main(String[] args) {

        // A new Scanner object is created for use in this class.
        Scanner input = new Scanner(System.in);
        
        // Variables are initialized
        long number; // number to be input by the user (the degree of faculty)
        long sum = 1; // the sum of the faculty
        
        // Program asks for input, which can then be input using the scanner.
        System.out.println("Type a number for which the faculty"
                + " should be printed: ");
        number = input.nextInt();
        
        // if input is less than 0, print an error value.
        if (number < 0)
            System.out.println("Error, the number is less than 0.");
        
        // if input is 0, print this
        else if (number == 0)
            System.out.println("!0 = 1");
        
        // else (number > 0), run a for-loop that prints the faculty in the form 
        // of multiplication (3! = 1 * 2 * 3)
        else
            System.out.print(number + "! = ");
        
            for (int i = 1; i <= number; i++) {

                // for the last number, an "*" is not printed after the number
                if (i == number) {
                    System.out.print(i);
                }
                else {
                    System.out.print(i + " * ");
                }

                // calculates the sum of the faculty, after multiplication.
                sum = sum * i;

            }
        // prints the sum.
        if (number >= 1)
        System.out.println(" = " + sum);

    }
}
