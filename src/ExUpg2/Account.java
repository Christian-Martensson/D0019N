package ExUpg2;
import java.util.Scanner;

public class Account {

    private String fName;
    // Ta bort lName från programmet
    private String lName;
    private String persNr;
    private int numberOfMonths;

    /*
    public Account() { //String fName, String lName, String persNr, int numberOfMonths) {
        this.fName = fName;
        this.lName = lName;
        this.persNr = persNr;
        this.numberOfMonths = numberOfMonths;
    }
    */





    public void setName(String fName, String lName) {

        this.fName = fName;
        this.lName = lName;
    }


    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }

    public String getPersNr() {
        return persNr;
    }

    //Sets personal ID number
    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    //Checks the form on the personal ID number (it needs to be 13 characters long and the 9th character must be "-").
    public static String regID_formCheck(String persNrTemp) {
        String persNr;
        // Converts the string to a charArray (to remove specific digits)
        char[] xytemp = persNrTemp.toCharArray();

        // If the input meets the following requirements for form, the dash will be removed.
        if (xytemp.length == 13 && xytemp[8] == '-') {
            persNr = persNrTemp.replace("-", "");
        }

        else {
            persNr = "Error";
        }

        return persNr;
    }

    //Checks the code according to the Luhn-algorithm.
    public static String regID_calculationCheck(String persNr) {
        int sumLoop = 0;
        char[] xy = persNr.toCharArray();

        // Multiply every other number by 2 (starting with the very first number) and add each to a sum variable.
        // If the product consists of two numbers, add them together.
        for (int x = 2; x < 12; x = x + 2) {
            int number = xy[x] - '0';
            if (number * 2 >= 10) {
                int product = number * 2;
                String productAsString = Integer.toString(product);
                char[] mini = productAsString.toCharArray();
                int firstNumber = mini[0] - '0';
                int secondNumber = mini[1] - '0';
                int summan = firstNumber + secondNumber;
                sumLoop = sumLoop + summan;
            }
            else {
                sumLoop = sumLoop + number * 2;
            }
        }

        // Add every other number to a sum variable (starting with the second number)
        for (int x = 3; x < 12; x = x + 2) {
            int number = xy[x] - '0';
            sumLoop = sumLoop + number;
        }


        //Temporary control
        //System.out.println("Summan: " + sumLoop);
        //System.out.println("Summan, inklusive kontrollsiffran: " + allt);

        if (sumLoop % 10 == 0)
            return persNr;
        else {
            return "Error";
        }
    }

    //Calculates the cost of membership, depending on months input.
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

    public String logIn(String truePersNr, String inputPersNr) {
        System.out.println();

        inputPersNr = Account.regID_formCheck(inputPersNr);
        if (truePersNr.equals(inputPersNr)) {
            System.out.println("You are logged in!");
            return(truePersNr);
        }
        else {
            System.out.println("Can't be found in the system.");
            return("Error");
        }
    }

    public void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");

    }
}



