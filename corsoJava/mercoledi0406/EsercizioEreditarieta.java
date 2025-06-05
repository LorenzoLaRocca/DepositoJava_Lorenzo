package mercoledi0406;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Ristorante {
    static List<String> piatti = new ArrayList<>();
    static List<Integer> valutazioni = new ArrayList<>();

    public static void stampaMenu() {
        System.out.println("Piatti attuali nel ristorante:");
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println((i + 1) + ". " + piatti.get(i) + " - Voto: " + 
                (valutazioni.size() > i ? valutazioni.get(i) : "Nessuna valutazione"));
        }
    }

    public static void aggiungiPiatto(String piatto) {
        piatti.add(piatto);
        System.out.println("Piatto aggiunto: " + piatto);
    }

    public static void aggiungiValutazione(int indice, int voto) {
        while (valutazioni.size() < piatti.size()) {
            valutazioni.add(0); // default 0
        }
        valutazioni.set(indice, voto);
        System.out.println("Valutazione aggiornata!");
    }
}

class Utente {
    protected String nome;
    protected String email;
    protected float soldi;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.soldi = new Random().nextFloat() * 100;
    }

    public void stampaDati() {
        System.out.printf("Nome: %s\nEmail: %s\nCredito: %.2f€\n", nome, email, soldi);
    }

    public void interagisci() {
        System.out.println("Accesso normale. Nessun privilegio.");
    }
}

class Chef extends Utente {
    public Chef(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void interagisci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome del nuovo piatto: ");
        String piatto = scanner.nextLine();
        Ristorante.aggiungiPiatto(piatto);
    }
}

class Critico extends Utente {
    public Critico(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void interagisci() {
        Scanner scanner = new Scanner(System.in);
        Ristorante.stampaMenu();
        if (Ristorante.piatti.isEmpty()) {
            System.out.println("Nessun piatto da valutare.");
            return;
        }
        System.out.print("Scegli il numero del piatto da valutare: ");
        int scelta = scanner.nextInt() - 1;
        if (scelta >= 0 && scelta < Ristorante.piatti.size()) {
            System.out.print("Inserisci un voto da 1 a 10: ");
            int voto = scanner.nextInt();
            Ristorante.aggiungiValutazione(scelta, voto);
        } else {
            System.out.println("Scelta non valida.");
        }
    }
}

public class EsercizioEreditarieta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utente utente = null;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crea nuovo utente");
            System.out.println("2. Stampa dati utente");
            System.out.println("3. Interagisci con profilo");
            System.out.println("4. Mostra piatti e valutazioni");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.print("Inserisci il nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = scanner.nextLine();

                    System.out.print("Vuoi essere (N)ormale, (C)hef o (R)itico? ");
                    String ruolo = scanner.nextLine().toUpperCase();

                    switch (ruolo) {
                        case "C":
                            utente = new Chef(nome, email);
                            break;
                        case "R":
                            utente = new Critico(nome, email);
                            break;
                        default:
                            utente = new Utente(nome, email);
                            break;
                    }
                    System.out.println("Utente creato!");
                    break;

                case "2":
                    if (utente != null) {
                        utente.stampaDati();
                    } else {
                        System.out.println("Nessun utente creato.");
                    }
                    break;

                case "3":
                    if (utente != null) {
                        utente.interagisci();
                    } else {
                        System.out.println("Crea prima un utente.");
                    }
                    break;

                case "4":
                    Ristorante.stampaMenu();
                    break;

                case "5":
                    System.out.println("Uscita dal programma. Arrivederci!");
                    return;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}
