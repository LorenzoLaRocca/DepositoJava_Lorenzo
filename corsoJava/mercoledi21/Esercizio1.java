package mercoledi21;

/*
 * Create uno script che richiede all’utente Nome, anno di
nascita e giorno della settimana (a numero) e stampa in
maniere formattata oltre al nome, l’età e i giorni che mancano
al prossimo weekend (sabato):
Esempio
’Il tuo nome è Tommaso, hai 38 anni e mancano 3 giorni al
weekend’

the program is required to be simple so not gonna use anything fancy
 */

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner myObjString = new Scanner(System.in); // Create a Scanner object for string input
        Scanner myObjNumb = new Scanner(System.in); // create a Scanner object for number input
        int week = 6; // number of days in a week
        int daysUntilWeekend = 0;

        System.out.println("Benvenuto! Inserisci il tuo nome:");
        String userName = myObjString.nextLine(); // Read user input for string
        System.out.println("Inserisci il tuo anno di nascita:");
        int birthYear = myObjNumb.nextInt(); // Read user input for birth year
        System.out.println("Inserisci il giorno delle settimana in formato numerico (1..7):");
        int dayOfWeek = myObjNumb.nextInt(); // Read user input for day of the week

        if (dayOfWeek >= 1 && dayOfWeek <= 6 ) {
           daysUntilWeekend =  week - dayOfWeek; // variable to store the number of days until the weekend
        } else if (dayOfWeek == 7) { 
            daysUntilWeekend = 6; 
        } 
        
        System.out.println("Il tuo nome è " + userName + ", hai " + (2025 - birthYear) + " anni e mancano " + (daysUntilWeekend) + " giorni al prossimo weekend"); // Output user input
        
        // I closed the scanner manually because the warnings were bothering me

        myObjString.close(); // Close the scanner
        myObjNumb.close(); // Close the scanner  

    }
}
