package martedi27;

import java.util.Scanner;

/*Scrivete un gioco in cui il giocatore 1 inserisce un
numero da 1 a 100 e il giocatore2 ha 5 tentativi per
indovinare il numero.
Il programma fornisce suggerimenti (troppo alto,
troppo basso), termina quando l'utente indovina
correttamente, quando i tentativi finiscono

 */
public class Esercizio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int guesses = 5;
        int guess = 0;
        

        while (num < 1 || num > 100){
            System.out.println("Giocatore 1 inserisci un numero tra 1 e 100");
            num = scanner.nextInt();
            if (num < 1 || num > 100) {
                System.out.println("Numero non valido reinserire!");
            }
        }

        System.out.println("Giocatore 2 prova a indovinare il numero hai " + guesses + " tentativi:");

        while(guesses > 0){     

            System.out.println("Tentativo numero " + guesses);

             if(guesses == 1){
                System.out.println("Ultimo tentativo!");
                guess = scanner.nextInt();

                if(guess == num){
                    System.out.println("Hai indovinato! il numero era " + guess);
                    break;
                } else { 
                    System.err.println("Numero errato! Hai esaurito i tentativi!");
                    break;
                }
            }

            guess = scanner.nextInt();
            guesses--;

            if(guess == num){
                System.out.println("Hai indovinato! il numero era " + guess);
            } else if (guess < num){
                System.out.println("Il numero è troppo basso. Riprova");
            } else if (guess > num){
                System.out.println("Il numero è troppo alto. Riprova");
            }

        }
        scanner.close();
    }
}
