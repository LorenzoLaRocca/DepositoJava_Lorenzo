package martedi27;
/* Esercizio: Simulazione di un Distributore Automatico
Scrivi un programma Java che simuli il funzionamento di un distributore automatico di
bevande. L'utente inizia con un certo credito iniziale (ad esempio, 10€).
Il programma mostra un menu con le seguenti opzioni:
1. Caffè - 1.50€
2. Cappuccino - 2.00€
3. Tè - 1.00€
4. Acqua - 0.50€
5. Uscire
L'utente può selezionare una bevanda e il costo viene scalato dal credito disponibile.
Se il credito non è sufficiente, il programma deve avvisare l'utente e chiedere una
nuova scelta.
L'utente può continuare a comprare bevande finché non sceglie di uscire o esaurisce il
credito.
Alla fine, il programma stampa il credito rimanente e un messaggio di chiusura. */

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sei assonnato e non ci vedi più dalla fame? Inserisci una monetina e compra qualcosa da me!");

        double money = 0;
        double cost = 0;

        while (money < 1 || money > 20) {
            System.out.println("Caccia i soldi: ");
            money = scanner.nextDouble();
            if (money < 1 || money > 20) {
                System.out.println("Stai calmo, ho il resto fino a 20 soldi massimi, oppure non hai inserito niente. Dai Riprova.");
            }
        }

        Scanner scanner1 = new Scanner(System.in);  

        while(money > 0){
            System.out.println("Menu: 1. Caffè - 1.50€\r\n" + // 
                                "2. Cappuccino - 2.00€\r\n" + //
                                "3. Tè - 1.00€\r\n" + //
                                "4. Acqua - 0.50€\r\n" + //
                                "5. Uscire" );

            System.out.println("Pigia il numero del prodotto che preferisci: ");
           
            int choice = scanner1.nextInt();
           
            if (choice < 1 || choice > 5){
                System.out.println("Scelta non valida riprovare");
            }
            
            switch (choice) {
               case 1:
                    cost = 1.50d;
                    break;
               case 2:
                    cost = 2.00d;
                    break;
               case 3:
                    cost = 1.00d;
                    break;
               case 4:
                    cost = 0.50d;
               case 5:
                    System.out.println("Uscita. Erogazione resto di: " + money + "€");
                    scanner.close();
                    scanner1.close();
                    return;
            } // fine switch case

            if(money > cost){
               money = money - cost;
            } else if (money == cost){
               System.out.println("Prodotto Rilasciato. Credito Esaurito. Uscita");
                    scanner.close();
                    scanner1.close();
                    return;
            } else if (money < cost){
               System.out.println("Credito Insufficiente. Fai una nuova scelta o esci dalla macchinetta povero!");
            }

            System.out.println("Hai ancora saldo a disposizione per una nuova scelta: " + money + "€");
          }
            
        scanner.close();
        scanner1.close();
    }  
}
