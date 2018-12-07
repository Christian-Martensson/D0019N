package ExUpg2;

import java.util.Scanner;
import java.util.Arrays;


/* TO DO
 * Allow personal ID with and without dash
 * Allow invalid input to be repeated right away (do while)
 * Kontrollera tillåtna siffror för månad och dag (ungefärligt)
 * Create some form of log-in, using password?
 * Create methods for handling input of first name, last name and personal id.
 * Prints the name and personal ID of the person logged in.
 * */


/* Notes
* Inga static - använd objekt istället.
*
*
*
* */


public class GymWakeUp_Main {

    public static void main(String[] args) {

        getMenu();
    }

    public static void getMenu() {
        Scanner input = new Scanner(System.in);
        Account account1 = new Account();
        boolean continueLoop = true;
        do {
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
                    String persNr;
                    System.out.println("Enter your first name: ");
                    String fName = input.next();


                    System.out.println("Enter your last name: ");
                    String lName = input.next();
                    account1.setName(fName, lName);

                    do {
                        do {
                            System.out.println("Enter your personal ID number on the form yyyymmdd-xxxx:");
                            persNr = input.next();
                            persNr = Account.regID_formCheck(persNr);

                        } while (persNr.equals("Error"));

                        persNr = Account.regID_calculationCheck(persNr);
                        if (persNr.equals("Error"))
                            System.out.println("Invalid personal ID number.");

                    } while (persNr.equals("Error"));


                    int numberOfMonths = account1.costCalculation();

                    account1.setPersNr(persNr);
                    account1.setName(fName, lName);


                    //Account account1 = new Account(fName, lName, persNr, numberOfMonths);

                    System.out.println("Your account has been registered.\n");
                    break;
                                    }
                case 2: {
                    if (account1.getPersNr() == null) {
                        System.out.println("You must become a member before logging in!");
                        break;
                    }
                    else {
                        System.out.println("To log in, enter your personal ID number on the form yyyymmdd-xxxx: ");
                        String inputPersNr = input.next();
                        String truePersNr = account1.getPersNr();
                        account1.logIn(truePersNr, inputPersNr);
                        System.out.println("You are now logged in %d");
                        break;
                    }

                }
                case 3: {
                    if (account1.getPersNr() == null) {
                        System.out.println("You must become a member before logging in!");
                        break;
                    }

                    else {
                        System.out.println("Choose from the following classes using numbers 1-3: \n1. Spinning \n2. Aerobics \n3. Yoga ");
                        byte classChoice = input.nextByte();
                        //add method that selects the correct object for chosen activity.

                        bookSpot();

                        //System.out.println("Choose one of the spots (a1, a2 ... c2, c3): ");
                        //String spotChoice = input.next();
                        //add method that reserves spot for chosen activity (through an array)

                        break;
                    }
                }
                case 4: {
                    System.exit(0);
                    break;
                }
            }
        } while(continueLoop);
    }



    public static void bookSpot() {


        String[] platser = {"1a" ,"1b", "1c", "2a", "2b", "2c", "3a", "3b", "3c"};
        String[] upptagnaPlatser = {"1a", "3c"};

        System.out.println("Skriv in platsen du vill boka");
        Scanner input = new Scanner(System.in);
        String valdPlats = input.next();


        if(Arrays.asList(upptagnaPlatser).contains(valdPlats)){

            System.out.println("Sorry platsen ar upptagen, forsok igen");

        }


        else if(Arrays.asList(platser).contains(valdPlats)) {

            System.out.println("Grattis du ar bokad!");

        }

        else {

            System.out.println("Du har valt en ogiltig plats forsok igen");

        }



    }

}





        //ArrayList<Integer> arrli = new ArrayList<Integer>(n);

        /*
        1. Menu is presented to the user.
        2. The user selects "book a class"
        3. The system prints the classes to choose from (1-3)
            - Other input is not allowed, reprompt
        4. The user selects a class.
        5. The system prints the spots to choose from.
            - Other input is not allowed, reprompt
        6. The user selects the spot.
            - if taken, user is prompted to choose another spot.
        */




    // public boolean validChoice (int firstIndex, int secondIndex)







