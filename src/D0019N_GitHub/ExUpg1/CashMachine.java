package D0019N_GitHub.ExUpg1;

import java.util.Scanner;

public class CashMachine {
    public static void main(String[] args) {

        // Creates a new scanner object
        Scanner input = new Scanner(System.in);

        // Define the variables and their datatypes
        int cost;
        int paid;
        int change;

        // User inputs the cost of the purchase
        System.out.println("Enter the cost of the purchase: ");
        cost = input.nextInt();

        // User inputs amount paid
        System.out.println("Enter amount payed: ");
        paid = input.nextInt();

        // the variable "change" is defined as the cost minus amount paid
        change = paid - cost;

        // Control: amount payed must be higher than the cost of the product.
        if (cost > paid)
            System.out.println("Error: cost exceeds payment.");

            // Control: the cost of a product can't be negative or below zero.
        else if (cost <= 0)
            System.out.println("Error: cost is negative.");

            // Prints information about the data input, such as the cost of the purchase,
            // amount payed, change to be returned and the text "banknotes to be returned".
        else {
            System.out.println("Cost of the purchase: " + cost + "kr.");
            System.out.println("Amount payed: " + paid + "kr.");
            System.out.println("Change to be returned: " + change + "kr.");
            System.out.print("Banknotes to be returned: ");

            /* This section sends the variable "change" to the method getBanknotes
            and returns a value which is assigned to the variable "z".
            Variable z is then used in using the method another time, this time
            with value of the change reduced (if a value was found in the first run of the method).
            */
            int z;
            z = getBanknotes(change, 1000);
            z = getBanknotes(z, 500);
            z = getBanknotes(z, 200);
            z = getBanknotes(z, 100);
            z = getBanknotes(z, 50);
            z = getBanknotes(z, 20);
            z = getBanknotes(z, 10);
            z = getBanknotes(z, 5);
            z = getBanknotes(z, 2);
            getBanknotes(z, 1);
        } // End of else
    } // End of main



    /*

    The method prints the "change" to be returned,
    split into as big banknotes as possible.

    The method takes two arguments:
    the (remaining) change and the size of the banknote.
    The method is


    If the change (stored in temp) is larger than 1000, then this
    for-loop removes 1000 from the temp variables until the remaining change
    is less than 1000. When the remaining change is less than 1000, the same
    process is repeated in the next for loop, with the difference being that
    the target sum is updated (to 500, 200, 100, 50, 20, 10, 5, 2 and 1.
    */

    public static int getBanknotes(int change, int x) {
        for (change = change; change >= x; change = change - x) {
            System.out.print(x + ":- ");
        }
        return change;
    } //End of method getBanknotes

} // End of program
