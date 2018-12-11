package ExUpg2;

import java.util.Scanner;

public class Account {

    private String fName;
    private String lName;
    private String persID;
    private int numberOfMonths;


    public void setFName(String fName) {
        this.fName = fName;
    }


    public void setLName(String lName) {
        this.lName = lName;
    }


    public void setpersID(String persID) {
        this.persID = persID;
    }


    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }


    public String getpersID() {
        return persID;
    }


    // Controls that the personal ID number is of correct length.
    public static String regID_formCheck(String persID) {
        // Converts the string to a charArray (to count the number of digits)
        char[] xytemp = persID.toCharArray();

        // If the input meets the following requirements for form, the dash will be removed.
        if (xytemp.length == 12) {
        }

        else {
            persID = "Error";
        }

        return persID;
    }


    // Controls the personal ID number according to the Luhn-algorithm.
    public static String regID_calculationCheck(String persID) {
        int sumLoop = 0;
        char[] xy = persID.toCharArray(); //convert String to char array to allow computation of individual digits.

        // Multiply every other number by 2 (starting with the very first number) and add each to a sum variable.
        // If the product consists of two numbers, add them together.
        for (int x = 2; x < 12; x = x + 2) { // If the number is uneven this is performed.
            int number = xy[x] - '0';
            if (number * 2 >= 10) { // If the number multiplied by two has more than one digit, these should be added together.
                int product = number * 2;
                String productAsString = Integer.toString(product);
                char[] mini = productAsString.toCharArray();
                int firstNumber = mini[0] - '0';
                int secondNumber = mini[1] - '0';
                int summan = firstNumber + secondNumber;
                sumLoop = sumLoop + summan;
            }
            else { // else, don't add the numbers normally to the sum.
                sumLoop = sumLoop + number * 2;
            }
        }

        // Add every other number to a sum variable (starting with the second number)
        for (int x = 3; x < 12; x = x + 2) {  // If the number is even this is performed.
            int number = xy[x] - '0';
            sumLoop = sumLoop + number;
        }

        if (sumLoop % 10 == 0) // if the sum of the above process can be divided by 10, the ID number is correct.
            return persID;
        else { // else return "Error", which triggers further actions in the main block of code.
            return "Error";
        }
    }


    // Calculates the cost of membership, depending on months input.
    public int costCalculation() {
        Scanner input = new Scanner(System.in);


        int monthlyPrice = 0;
        int totalPrice;
        int membership = 100;
        int numberOfMonths;
        String answer;
        boolean continueLoop;


        do {
            do {
                System.out.println("For how many months do you want to sign a membership?");
                numberOfMonths = input.nextInt();

                if (numberOfMonths < 1) {
                    System.out.println("Error, length must be at least 1 month.");
                    continueLoop = true;
                } else if (numberOfMonths >= 1 && numberOfMonths <= 2) {
                    monthlyPrice = 400;
                    continueLoop = false;
                } else {
                    continueLoop = false;
                    if (numberOfMonths <= 6) {
                        monthlyPrice = 350;
                    } else {
                        if (numberOfMonths < 12) {
                            monthlyPrice = 300;
                        } else {
                            monthlyPrice = 250;
                        }

                    }
                }
            } while(continueLoop == true);
            totalPrice = membership + monthlyPrice * numberOfMonths;

            System.out.printf("\nThe membership fee is %d SEK. " +
                            "\nYour monthly fee is %d SEK." +
                            "\nOver a period of %d months you will pay %d SEK in total.\n",
                    membership, monthlyPrice, numberOfMonths, totalPrice);
            System.out.println("Do you confirm this selection? (y/n)");
            answer = input.next();
        } while(!(answer.equals("y")));
        // ask if confirmed, otherwise return.

        return numberOfMonths;
    }


    // Used to get input from user and save this (name, persID, membership length).
    public void createAccount() {

        Account account = new Account();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        fName = input.next();


        System.out.println("Enter your last name: ");
        lName = input.next();

        do {
            do {
                System.out.println("Enter your personal ID number on the form yyyymmddxxxx:");
                persID = input.next();
                persID = Account.regID_formCheck(persID);

            } while (persID.equals("Error")); // if the return from regID_formCheck is "Error", continue loop.

            persID = Account.regID_calculationCheck(persID);

            if (persID.equals("Error"))
                System.out.println("Invalid personal ID number.");

        } while (persID.equals("Error")); // if the return from regID_calculationCheck is "Error", continue loop.

        int numberOfMonths = account.costCalculation();

        account.setFName(fName);
        account.setLName(lName);
        account.setpersID(persID);
        account.setNumberOfMonths(numberOfMonths);

        GymWakeUp_Main.accounts.add(persID); //adds the persID to the arrayList for personal ID numbers.
    }
}



