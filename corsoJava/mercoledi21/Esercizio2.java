package mercoledi21;

/*
 * create un programma che richiede all’utente l’età, se ha la patente e se ha bevuto e in base alle
    risposte ci dice se può guidare.

 */

 import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {

        Scanner myObjString = new Scanner(System.in); // Create a Scanner object for string input
       
        boolean isDrivingLicense = false;
        boolean isDrunk = false;;
        System.out.println("Welcome, insert your age:");
        int userAge = myObjString.nextInt(); 

        myObjString.nextLine();

        System.out.println("Do you have a driving license? (yes/no):");
        String drivingLicense = myObjString.nextLine();

        if(drivingLicense.equals("yes")) {
            isDrivingLicense = true; 
        } else if (drivingLicense.equals("no")) {
            isDrivingLicense = false; 
        } else {
            System.out.println("Invalid input, please enter 'yes' or 'no'");
        }

        System.out.println("Have you drunk? (yes/no):");
        String drunk = myObjString.nextLine();

        if(drunk.equals("yes")) {
            isDrunk = true; // variable to store if the user has a driving license
        } else if (drunk.equals("no")) {
            isDrunk = false; 
        } else {
            System.out.println("Invalid input, please enter 'yes' or 'no'");
        }

        if(userAge >= 18 && isDrivingLicense == true && isDrunk == false){
            System.out.println("You can drive");
        } else if (userAge < 18) {
            System.out.println("You are too young to drive");
        } else if (isDrivingLicense == false) {
            System.out.println("You don't have a driving license");
        } else if (isDrunk == true) {
            System.out.println("You are drunk, you can't drive");
        } else {
            System.out.println("You can't drive");
        }  

        myObjString.close(); // Close the scanner

    }
}