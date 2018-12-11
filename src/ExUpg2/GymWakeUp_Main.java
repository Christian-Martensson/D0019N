package ExUpg2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class GymWakeUp_Main {
    // global Arraylist containing personal ID numbers.
    public static ArrayList<String> accounts = new ArrayList<String>();

    // global ArrayLists for the bookClass method (keeps track of which spots are occupied).
    public static ArrayList<String> occupiedSpinning = new ArrayList<String>();
    public static ArrayList<String> occupiedAerobics = new ArrayList<String>();
    public static ArrayList<String> occupiedYoga = new ArrayList<String>();

    // Further ArrayList used in the bookClass method. Used to reduce redundancy of code.
    public static ArrayList kurs = null;

    // variable used in the bookClass method to choose
    public static byte classChoice;


    // ------------------------------------------------------------------------------------------------
    // Program starts here
    // ------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        getMenu();

    } // End of main


    public static void getMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueLoop = true;
        boolean loggedIn = false;

        do {
            System.out.println("\nChoose one of the following options " +
                    "by using the numbers 1-4.");
            System.out.println("1.  Become a member");
            System.out.println("2.  Log in");
            System.out.println("3.  Book activity");
            System.out.println("4.  Quit");

            int selectMenu = input.nextInt();

            switch (selectMenu) {
                case 1: { // Become a member

                    // Calls the method that collect first name, last name, personal ID number and membership status.
                    new Account().createAccount();

                    System.out.println("Your account has been registered.");
                    break;
                }

                case 2: { // Log in
                    System.out.println("To log in, please enter your personal ID number on the form yyyymmddxxxx: ");
                    String persID = input.next();

                    if (!(accounts.contains(persID))) { // if the personal ID input by user is not in the list of persNr
                        System.out.println("You must become a member before logging in!");
                        break;
                    }
                    else {
                        loggedIn = true; //variable to grant access to case 3: "Book activity"
                        System.out.println("You are logged in!");
                        break;
                    }

                }

                case 3: { // Book activity
                    if (!loggedIn) {
                        System.out.println("Please log in before booking.");
                        break;
                    }

                    else {
                        System.out.println("Choose from the following classes using numbers 1-3: \n1. Spinning \n2. Aerobics \n3. Yoga ");
                        classChoice = input.nextByte();

                        // control: only numbers 1, 2 and 3 are valid.
                        if (!((classChoice >= 1) && classChoice <= 3)) {
                            System.out.println("Invalid input.");
                            break;
                        }
                        else {
                            bookSpot(classChoice);
                        }

                        break;
                    }
                }

                case 4: { // Quit
                    continueLoop = false;
                    break;
                }
            }
        } while(continueLoop);
    } // End of method getMenu


    public static void bookSpot(byte classChoice) {

        // switch method used to reduce redundancy of code. Without it it would be necessary to write 3 times as much code.
        switch (classChoice) {
            case 1:  kurs = occupiedSpinning;
                break;
            case 2:  kurs = occupiedAerobics;
                break;
            case 3:  kurs = occupiedYoga;
                break;
        }
        boolean continueLoop = true;

        // These are the only allowed spots to choose from.
        String[] spots = {"1a" ,"1b", "1c", "2a", "2b", "2c", "3a", "3b", "3c"};

        printRoom();


        do {
            System.out.println("Choose which spot you would like to book (1a, 2a... 3c). Enter q to quit.");
            System.out.println("The following spots are already occupied: " + kurs);
            Scanner input = new Scanner(System.in);
            String chosenSpot = input.next();

            if (kurs.contains(chosenSpot)) { // checks if the chosen spot is already in the corresponding arraylist.
                System.out.println("This spot is occupied, please try again.");
            }

            //if the spot is free, add the spot to the arrayList of occupied spots, according to which class was chosen earlier.
            else if (Arrays.asList(spots).contains(chosenSpot)) {
                if (classChoice == 1) {
                    occupiedSpinning.add(chosenSpot);
                } else if (classChoice == 2) {
                    occupiedAerobics.add(chosenSpot);
                } else if (classChoice == 3) {
                    occupiedYoga.add(chosenSpot);
                }

                System.out.println("You are now booked on the following spot: " + chosenSpot + ".");
                continueLoop = false;
            }
            else if (chosenSpot.equals("q")) { // allows the user to exit loop without booking
                continueLoop = false;
            }
            else {
                System.out.println("You have chosen an invalid spot, please try again.");
            }
        } while(continueLoop); //loop continues until a valid spot is chosen.


    } // End of method bookSpot


    // Prints a visual representation of the room
    public static void printRoom() {

        System.out.println("---------------");
        System.out.printf ("| 1a | 1b | 1c |\n");
        System.out.println("---------------");
        System.out.printf ("| 2a | 2b | 2c |\n");
        System.out.println("---------------");
        System.out.printf ("| 3a | 3b | 3c |\n");
        System.out.println("---------------");

    } // End of method printRoom


} // End of class
