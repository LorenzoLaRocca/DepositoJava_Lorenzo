import java.util.Scanner; // Import the Scanner class

public class Esercizio1 {     // this exercise is an example of using the Scanner class and 2 scanner objects for string and number/boolean input
    public static void main(String[] args) {

        // Creazione oggetti Scanner
        Scanner myObjString = new Scanner(System.in); // Create a Scanner object for string input
        Scanner myObjNumb = new Scanner(System.in); // create a Scanner object for number input

        // Read user input from String input

        System.out.println("Enter username"); 
        String userName = myObjString.nextLine(); // Read user inputv for string
        System.out.println("Username is: " + userName); // Output user input


        // Read user input from Number and Boolean input

        System.out.println("\nEnter your age");   // read user input for integer
        int age = myObjNumb.nextInt();
        System.out.println("Your age is: " + age); 

        System.out.println("\nEnter your height"); // read user input for float
        float height = myObjNumb.nextFloat();
        System.out.println("Your height is: " + height); 

        System.out.println("\nEnter the pigreco"); // read user input for double
        double piGreco = myObjNumb.nextDouble(); 
        System.out.println("The pigreco is: " + piGreco); 

        System.out.println("\nEnter a byte number"); // read user input for byte
        byte byteNumber = myObjNumb.nextByte();
        System.out.println("The byte number is: " + byteNumber); 

        System.out.println("\nEnter a short number"); // read user input for short
        short shortNumber = myObjNumb.nextShort();  
        System.out.println("The short number is: " + shortNumber);

        System.out.println("\nEnter a long number"); // read user input for long
        long longNumber = myObjNumb.nextLong();
        System.out.println("The long number is: " + longNumber);

        System.out.println("\nEnter a boolean value"); // read user input for boolean
        boolean boolValue = myObjNumb.nextBoolean();
        System.out.println("The boolean value is: " + boolValue); 


    /*  Curiosità: per motivi di robustezza e sicurezza non è possibile leggere un char direttamente con lo scanner nextLine() 
       
        System.out.println("Enter a char"); // read user input for char
        char charValue = myObjString.nextLine(); // Read user input for char
        System.out.println("Your char is: " + charValue); // Output user input

    */

        // chiuso a mano perchè mi davano fastidio i warning

        myObjString.close(); // Close the scanner
        myObjNumb.close(); // Close the scanner     
    }
}
