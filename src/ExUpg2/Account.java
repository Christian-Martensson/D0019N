package ExUpg2;
import java.util.Scanner;

public class Account {

    private String fName;
    private String lName;
    private String persNr;
    private int numberOfMonths;

    public Account(String fName, String lName, String persNr, int numberOfMonths) {
        this.fName = fName;
        this.lName = lName;
        this.persNr = persNr;
        this.numberOfMonths = numberOfMonths;
    }


    public void setName(String fName, String lName) {

        this.fName = fName;
        this.lName = lName;
    }

    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    public void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");



    }

}

