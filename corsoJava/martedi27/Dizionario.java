package martedi27;

import java.util.HashMap;
import java.util.Scanner;

/*Scrivete un programma che chiede una stringa all’utente e
restituisce un HashMap rappresentante la "frequenza di
comparsa" di ciascun carattere componente la stringa.
Esempio:
Stringa "ababcc",
Risultato
{"a": 2, "b": 2, "c": 2} */

public class Dizionario {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola: ");

        String word = scanner.nextLine();

        HashMap<Character, Integer> frequency = new HashMap<>();

        int count = 0;

        for (char c : word.toCharArray()) {
            if (count == 0) {       // vuol dire che vediamo per la prima volta quel carattere
                frequency.put(c, 1); 
            } else {
                frequency.put(c, count + 1); 
            }
        }

        System.out.println("Frequenza dei caratteri:");
        System.out.println(frequency);

        scanner.close();
    }
}
