package martedi0306;

import java.util.Scanner;

import martedi0306.ProvaClassi3.Dipendente;

/*
    Definire una Classe BankAccount e
    Implementare Deposito & Prelievo
    Crea una classe BankAccount con:
    String accountHolderName (Nome del titolare dell'account)
    double balance (Saldo)
    Metodo void deposit(double amount) per effettuare un deposito
    Metodo void withdraw(double amount) per effettuare un
    prelievo
    Metodo void displayBalance() per mostrare il saldo attuale
    Assicurati che il prelievo non consenta un saldo negativo.

    Bonus Creare la classe utente. Sei registrato?
 */

public class EsercizioBanca {

    public static class BankAccount{        // definizione della classe BankAccount
        String accountHolderName;
        double balance;

        BankAccount(String accountHolderName, double balance){      // costruttore standard
            this.accountHolderName = accountHolderName;
            this.balance = balance; 
        }
        
    }

    public static void main(String[] args) {

        
        Scanner scannerInt = new Scanner(System.in);        // Scanner per la scelta dei menu'
        Scanner scannerDouble = new Scanner(System.in);     // Scanner per la scelta della somma da depositare/prelevare
        BankAccount account1 = new BankAccount("Lorello", 1050.0);      // istanca account hardcoded
        
        
        while(true){        // ciclo infinito del programma in modo da fare più operazioni

            System.out.println("Benvenuto! Scegli l'operazione da fare: 1. Deposito 2. Prelievo 3. Vista Saldo 4. Uscita");

            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    double amount;
                    System.out.println("Inserisci la cifra depositare: ");
                    amount = scannerDouble.nextDouble();
                    deposit(account1, amount);    // richiamo del metodo deposito
                    break;
                case 2:
                    System.out.println("Inserisci la cifra ritirare: ");
                    amount = scannerDouble.nextDouble();
                    withdraw(account1, amount);     // richiamo del metodo per il prelievo
                    break;

                case 3:
                    displayBalance(account1);       // callback metodo per visualizzare il saldo
                    break;

                case 4:
                    System.out.println("Arrivederci!");
                    return;
            }
        }

    }

    public static void deposit(BankAccount account, double amount){
        if(amount>0){
            account.balance += amount;
            System.out.println("Saldo attuale: " + account.balance);
        } else System.out.println("Importo uguale a 0. Riprovare.");
    }

     public static void withdraw(BankAccount account, double amount){
        if(account.balance<amount){
            System.out.println("Non hai abbastanza credito");
        } else account.balance -= amount;
        
        System.out.println("Saldo attuale: " + account.balance);
    }
    
    public static void displayBalance(BankAccount account){
        System.out.println("Saldo attuale: " + account.balance);
    }
}
