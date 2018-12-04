package ExUpg2;
import java.util.Scanner;

public class Account {

    private String fName;
    private String lName;
    private String persNr;
    private int numberOfMonths;

    /*public Account() { //String fName, String lName, String persNr, int numberOfMonths) {
        this.fName = fName;
        this.lName = lName;
        this.persNr = persNr;
        this.numberOfMonths = numberOfMonths;
    }          */


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
        //String persNrCheck = account1.getPersNr;
        // Hur kommer jag åt objektet????

    }

    /*public void logIn() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your personal ID number on the form yyyymmdd-xxxx: ");
        String persNr = input.next();
        persNr = Account.regID_formCheck(persNr);
        //System.out.println(GymWakeUp_Main.account1.getPersNr());
        //String persNrCheck = account1.getPersNr;
        // Hur kommer jag åt objektet????

    }*/

    public void setName(String fName, String lName) {

        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getPersNr() {
        return persNr;
    }

    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    public void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");

    }

    public static String regID_formCheck(String persNrTemp) {
        boolean check = true;
        String persNr = "";

        // Input for personal ID number. Specifically on this form to avoid problems with people of 100 or older age.

            // Converts the string to a charArray
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

}

