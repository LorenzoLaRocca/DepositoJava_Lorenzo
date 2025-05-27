package martedi27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class NomiStudenti {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        String studentName;

        // Inserimento nomi
        while (true) {
            System.out.println("Inserisci il nome di uno studente: ");
            studentName = scanner.nextLine();
            if (studentName.equals("fine")) break;
            names.add(studentName);
        }

        System.out.println("L'utente ha inserito " + names.size() + " studenti.");

        // Ordinamento alfabetico
        Collections.sort(names);
        System.out.println("Stampa in ordine alfabetico:");
        for (String name : names) {
            System.out.println(name);
        }

        while (true) {
            System.out.println("Inserisci il nome dello studente da eliminare: ");
            studentName = scanner.nextLine();

            if (studentName.equals("fine")) {
                System.out.println("Fine eliminazione");
                break;
            }

            if (names.remove(studentName)) {
                System.out.println("Hai rimosso lo studente " + studentName);
            } else {
                System.out.println("Studente non trovato.");
            }
        }

        // Stampa finale
        System.out.println("Stampa degli studenti rimanenti:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
