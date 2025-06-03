package martedi0306;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 *  Esercizio 1: Funzione Base
    Scrivi un metodo che calcola la somma di due numeri e restituisce il risultato.

    Esercizio 3: Ricorsione - Somma dei Numeri Naturali
    Scrivi una funzione ricorsiva che calcola la somma dei primi n numeri naturali.
    📌 Esempio:
    sommaNaturali(5) → 5 + 4 + 3 + 2 + 1 = 15

    Esercizio 4: Passaggio per Valore & Passaggio per Riferimento
    Crea un metodo che modifica una variabile primitiva.
    Crea un altro metodo che modifica un array.
    Testa e spiega la differenza tra i due comportamenti

 */

public class EsercizioGenerale {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);   // type int scanner for menu input
        Random random = new Random();
        int a = random.nextInt(100)+ 1; // random number between 0 and 100
        int b = random.nextInt(100)+ 1;
        
        while(true){    // infinite loop for the program
            System.out.println("Benvenuto! Scegli la funzione che preferisci: 1. Somma di 2 numeri 2. Somma dei primi n numeri naturali 3. Passaggio per valore/riferimento 4. Uscita");
        

        int choice = scanner.nextInt();

        switch(choice){
            case 1:
            int somma = somma(a, b);
            System.out.println("La somma è = " + somma);
            break;

            case 2:
                System.out.println("Inserisci un numero N: ");
                int n = scanner.nextInt();
                int sommaNaturaliRisultato = sommaNaturali(n);
                System.out.println("La somma dei primi " + n + " numeri naturali è = " + sommaNaturaliRisultato);
            break;

            case 3:
                System.out.println("Passaggio per valore.");
                System.out.println("Inserisci il numero originale: ");
                int numeroOriginale = scanner.nextInt();
                System.out.println("Numero originale: " + numeroOriginale);
                modificaVariabilePrimitiva(numeroOriginale);
                System.out.println("Stampa del valore dopo la modifica: "+ numeroOriginale);
                System.out.println("Il valore non è stato modificato poichè il numero è stato passato per valore.");
                
                System.out.println("Passaggio array per riferimento");
                int[] arrayOriginale = {1, 2, 3};
                System.out.println("Stampa array originale");
                for (int arr : arrayOriginale) { // Per ogni 'numero' nell'array 'numeri'
                 System.out.println(arr);
                }
                modificaArray(arrayOriginale);
                System.out.println("Stampa array dopo la modifica");
                for (int arr : arrayOriginale) { // Per ogni 'numero' nell'array 'numeri'
                System.out.println(arr);
                
            }
            break;

            case 4:
            scanner.close();
        
            System.out.println("Arrivederci");
            return;
        }

        
        }
    }    


    public static int somma(int a, int b){
        System.out.println("Faccio la somma di 2 numeri random dove a = " + a + " e b = " + b);
        return a + b;
    }

    public static int sommaNaturali(int n){

        if (n == 0){
            return 0;
        } else {
            return n + sommaNaturali(n - 1);        // callback of the same function with the decreased number
        }
    }

    public static void modificaVariabilePrimitiva(int numeroOriginale){
         Scanner scanner = new Scanner(System.in); 
        System.out.println("Inserisci un nuovo numero: ");
        numeroOriginale = scanner.nextInt();
    }

      public static void modificaArray(int[] arr) {
        System.out.println("Modifico il primo elemento dell'array");
        if (arr.length > 0) {
            arr[0] = 100; // first element is changed
        }
    }

}