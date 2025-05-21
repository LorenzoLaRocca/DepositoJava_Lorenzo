package mercoledi21;

import java.util.Scanner;

/*
    create un programma che richiede all’utente tre numeri e ci
    restituisce se ci sono 2
    numeri uguali o il numero più grande dei tre
 */

public class Esercizio3 {
    
    public static void main(String[] args) {
         Scanner myObjInt = new Scanner(System.in); 
         int x, y, z, max = 0;

        System.out.println("Welcome, insert the first number:");
        x = myObjInt.nextInt();
        System.out.println("Welcome, insert the second number:");
        y = myObjInt.nextInt();

        if (x > y) {
            max = x;
        } else {
            max = y;
        }

        System.out.println("Welcome, insert the third number:");
        z = myObjInt.nextInt(); 

        if (max < z) {
            max = z;
        }

        if (x == y || x == z || y == z) {
            System.out.println("There are at least two equal numbers");
        } else {
           System.out.println("There are no equal numbers, ands the max is: " + max);
        }
     
         myObjInt.close(); // Close the scanner

    }
}
