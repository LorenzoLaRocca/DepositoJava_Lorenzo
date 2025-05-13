import java.util.Scanner; // Import the Scanner class

public class EsempioScanner {      // questo è un esempio di utilizzo della classe Scanner che prende una stringa in input da tastiera
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username"); 

        String userName = myObj.nextLine(); // Read user input
        System.out.println("Username is: " + userName); // Output user input
        myObj.close(); // Close the scanner
    
    }
}
