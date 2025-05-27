package martedi27;

import java.util.ArrayList;
import java.util.Scanner;

/*
Scrivete un programma che chiede all'utente una
parola e restituisce solo le vocali e l’indice della
vocale all’interno della parola. 
*/

public class Vocali {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola: ");

        String wordToAdd = scanner.nextLine().toLowerCase();  // parola da aggiungere all'array of list

        ArrayList<String> word = new ArrayList<>();

        for (int i = 0; i < wordToAdd.length(); i++){
             word.add(String.valueOf(wordToAdd.charAt(i)));
        }

        for (int i=0; i<word.size(); i++){
            char a = word.get(i).charAt(0);
            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'){
            System.out.println("vocale: " + word.get(i) + " at index: " + i);
            }
        }
        scanner.close();
    }
}
