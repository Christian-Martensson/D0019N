package ExUpg2;

import java.util.Scanner;

/* TO DO
 * Allow personal ID with and without dash
 * Allow invalid input to be repeated right away (do while)
 * Kontrollera tillåtna siffror för månad och dag (ungefärligt)
 * Create some form of log-in, using password?
 * Create methods for handling input of first name, last name and personal id.
 * */


public class GymWakeUp_Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose one of the following options " +
                "by using the numbers 1-4.");
        System.out.println("1.  Become a member");
        System.out.println("2.  Log in");
        System.out.println("3.  Book a spot on an activity");
        System.out.println("4.  Quit");

        int selectMenu;
        selectMenu = input.nextInt();
        switch (selectMenu) {
            case 1: {
                // Names
                System.out.println("Enter your first name: ");
                String fName = input.next();

                System.out.println("Enter your last name: ");
                String eName = input.next();


                String persNr = regID_formCheck();
                persNr = regID_calculationCheck(persNr);

                if (persNr.equals("Error")) {
                    System.out.println("Invalid personal ID number.");
                    break;
                }
                else {
                    int numberOfMonths = costCalculation();

                    Account account1 = new Account(fName, eName, persNr, numberOfMonths);


                    System.out.println("Your account has been registered.");
                }


                break;
            }
            case 2: {

                break;
            }
            case 3: {

                break;
            }
            case 4: {
                break;
            }
        }




    }


    public static String regID_formCheck() {
        boolean check = true;
        String persNr = "";
        String persNrTemp;
        Scanner input = new Scanner(System.in);

        // Input for personal ID number. Specifically on this form to avoid problems with people of 100 or older age.
        System.out.println("Enter your personal ID number on the form yyyymmdd-xxxx:");
        do {
            // Assigns input to variable persNrTemp
            persNrTemp = input.next();
            // Converts the string to a charArray
            char[] xytemp = persNrTemp.toCharArray();

            // If the input meets the following requirements for form, the dash will be removed.
            if (xytemp.length == 13&& xytemp[8] == '-') {
                persNr = persNrTemp.replace("-", "");
                check = false;
            }
            else if(persNrTemp.equals("q")) {
                break;
            }
            else {
                System.out.println("Please enter your personal ID in the following form: yyyymmdd-xxxx");
            }
        } while (check);

        return persNr;
    }



    public static String regID_calculationCheck(String persNr) {
        int sumLoop = 0;
        char[] xy = persNr.toCharArray();
        int sistaSiffran = xy[11] - '0';
        int allt;


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
        for (int x = 3; x < 11; x = x + 2) {
            int number = xy[x] - '0';
            sumLoop = sumLoop + number;
        }

        allt = sumLoop + sistaSiffran;

        //Temporär kontroll
        //System.out.println("Summan: " + sumLoop);
        //System.out.println("Summan, inklusive kontrollsiffran: " + allt);

        if (allt % 10 == 0)
            return persNr;
        else {
            return "Error";
        }
    }




    // public boolean validChoice (int firstIndex, int secondIndex)

    private static int costCalculation() {
        Scanner input = new Scanner(System.in);


        int monthlyPrice = 0;
        int totalPrice;
        int membership = 100;
        int numberOfMonths;
        String answer;


        do {
            System.out.println("For how many months do you want to sign a membership?");
            numberOfMonths = input.nextInt();

            if (numberOfMonths <= 0) {
                System.out.println("Error, number must be bigger than 0.");
            } else if (numberOfMonths >= 1 && numberOfMonths <= 2) {
                monthlyPrice = 400;
            } else {
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



    private void bookaclass (String placement){
          /*
        String[][] room = new String[3][3];
        for (int i=0, i<3, i++) {
            for (int j=0, j<3, j++) {
                room[i][j] = " ";
            }

        }
        */
    }

    /*
    public static void getMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose one of the following options " +
                "by using the numbers 1-4.");
        System.out.println("1.  Become a member");
        System.out.println("2.  Log in");
        System.out.println("3.  Book a spot on an activity");
        System.out.println("4.  Quit");

        int selectMenu;
        selectMenu = input.nextInt();
        switch(selectMenu) {
            case 1:{
                System.out.println("Enter your first name: ");
                String fName = input.next();
                System.out.println("Enter your last name: ");
                String eName = input.next();
                Account.setName(fName, eName);
                //IF true, set the personal ID number.
                String persNr = regID_formCheck();
                regID_calculationCheck(persNr);

            }
        }
    } */

}




