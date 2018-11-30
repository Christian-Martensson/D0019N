package D0019N_GitHub.ExUpg2;
import java.util.Scanner;

/* TO DO
* Allow personal ID with and without dash
* Allow invalid input to be repeated right away (do while)
*
*
*
* */


public class GymWakeUp_Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GymWakeUp_Main instance = new GymWakeUp_Main();

        instance.getMenu();

        //instance.RegID();

        //instance.CostCalculation();
        //instance.getMenu();
        //System.out.println("Ange ditt personnnummer: ");
        //String persNr = input.next();
        //instance.checkID(persNr);


        /*
        String[][] room = new String[3][3];
        for (int i=0, i<3, i++) {
            for (int j=0, j<3, j++) {
                room[i][j] = " ";
            }

        }
        */
    }

    public static String regID() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your personal ID number:");
        String persNrTemp = input.next();
        char[] xytemp = persNrTemp.toCharArray();

        int sumLoop = 0;

        if (xytemp.length !=11 || !(xytemp[6] == '-' || xytemp[6] == '+' )){
            System.out.println("You need to enter the personal ID number on the form: yymmdd-xxxx");
        }


        else {
            String persNr = persNrTemp.replace("-", "");
            char[] xy = persNr.toCharArray();
            // Kontrollera tillåtna siffror för måndag och dag (ungefärligt)
            // If uneven,
            for (int x = 0; x < 10; x = x + 2) {
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


            for (int x = 1; x < 9; x = x + 2) {

                int number = xy[x] - '0';
                sumLoop = sumLoop + number;
            }

            int sistaSiffran = xy[9] - '0';
            int allt = sumLoop + sistaSiffran;
            System.out.println("Summan: " + sumLoop);
            System.out.println("Summan, inklusive kontrollsiffran: " + allt);


        }
        return persNrTemp;
    }

    public void checkID(String persNr) {
        System.out.println(persNr);
    }

    // public boolean validChoice (int firstIndex, int secondIndex)

    private void CostCalculation() {
        Scanner input = new Scanner(System.in);

        System.out.println("For how many months do you want to sign?");


        int m = input.nextInt();
        int monthlyPrice = 0;
        int totalPrice;
        int membership = 100;

        if (m <= 0) {
            System.out.println("Error, number must be bigger than 0.");
        }
        else if (m >= 1 && m <= 2) {
            monthlyPrice = 400;
        }
        else {
            if (m <= 6) {
                monthlyPrice = 350;
            }

            else {
                if (m < 12) {
                    monthlyPrice = 300;
                }
                else {
                    monthlyPrice = 250;
                    }

            }
        }

        totalPrice = monthlyPrice * m;

        System.out.printf("\nThe membership fee is %d. " +
                "\nYour monthly fee is %d crowns." +
                "\nOver a period of %d months you will pay %d crowns in total.",
                membership, monthlyPrice, m, totalPrice);
    }

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
                String regID = regID();
                System.out.println(regID);


            }
        }
    }
    private void becomeMember() {

    }
}




