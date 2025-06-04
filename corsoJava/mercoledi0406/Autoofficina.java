package mercoledi0406;

import java.util.ArrayList;
import java.util.Scanner;

public class Autoofficina {
    
    public static class Auto {
        String targa;   // attributi di classe
        String modello;

        Auto(String targa, String modello){ // costruttore parametrizzato
            this.targa = targa;
            this.modello = modello;
        }

    }   // fine classe Auto

    public static class Officina {
        ArrayList<Auto> AutoList = new ArrayList<>();   // arraylist nella quale conserveremo le auto dell'officina

        void aggiungiAuto(){    // metodo che aggiunge una sola macchina in maniera hardcoded
            Auto nuovaAuto = new Auto("DJ345DB", "Fiat Panda");
            AutoList.add(nuovaAuto);
        }

        void displayAuto(){
             if (AutoList.isEmpty()) {  // se la lista è vuota mi ritorna solo la stampa di errore
            System.out.println("Nessuna auto presente in officina.");
            return;
             }
            System.out.println("Elenco delle auto in officina:");
            for (Auto auto : AutoList) {
                System.out.println("Targa: " + auto.targa + ", Modello: " + auto.modello);
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Officina officina = new Officina();


        System.out.print("Benvenuto! ");
        while (true) {
            System.out.println("Scegli la funzione che preferisci: 1. Aggiungi Auto 2. Stampa a lista delle auto 3. Uscita ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    officina.aggiungiAuto();    // call del metodo
                    break;
            
                case 2:
                    officina.displayAuto();     // call metodo
                    break;
                case 3:
                    System.out.println("Arrivederci!"); 
                    scanner.close();
                    return;
            }
        }

    }

    
}
