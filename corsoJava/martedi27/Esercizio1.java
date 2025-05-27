package martedi27;

import java.util.Scanner;

/*
 * Chiedete in imput all'utente un numero compreso tra 1 e 10 e stampate la sua tabellina
 */

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner myObjInt = new Scanner(System.in);
        System.out.print("Inserisci un numero compreso tra 1 e 10: ");
        int num = myObjInt.nextInt();
        
        if (num < 1 || num > 10) {
            System.out.println("Il numero deve essere compreso tra 1 e 10.");
            myObjInt.close();
            return;
        }

        System.out.println("Tabellina realizzata con il ciclo for:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }

        System.out.println("Tabellina realizzata con il ciclo while:");
        int i = 0;
        while (i <= 10) {
            System.out.println(num + " * " + i + " = " + (num * i));
            i++;
        }
        
        myObjInt.close();
    }
    
}
