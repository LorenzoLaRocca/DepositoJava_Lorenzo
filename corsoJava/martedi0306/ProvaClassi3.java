package martedi0306;

import java.util.ArrayList;
import java.util.Scanner;

public class ProvaClassi3 {
    
    static class Dipendente {
        String nome;    // variabili di istanza
        int stipendio;
        int dipartimento;

        Dipendente(String nome, int stipendio, int dipartimento){       // costruttore con parametri
        this.nome = nome;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
        }

    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        ArrayList<Dipendente> dipendenteList = new ArrayList<>();       // array list per memorizzare i dati dei dipendendi

        /*dipendenteList.add(new Dipendente("Lorello", 100000, 1));       // metodo .add per aggiungere i dati all'array list
        dipendenteList.add(new Dipendente("Mario", 1500, 2));
        dipendenteList.add(new Dipendente("Gino", 20000, 0));

        for (Dipendente dipendente: dipendenteList){        // stampa dei valori dell'array list
            System.out.println("nome: " + dipendente.nome + " stipendio: euro" + dipendente.stipendio + " numero dipartimento: " + dipendente.dipartimento );
        }
            */

        while(true){

            
            System.out.println("Benvenuto! Scegli la funzione che preferisci: 1. Inserimento Dipendenti 2. Stampa Lista 3. Eliminazione Dipendente 4. Uscita");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    while(true){
                        System.out.println("Inserisci il nome: ");
                        String nome = scanner2.nextLine();
                        System.out.println("Inserisci lo stipendio: ");
                        int stipendio = scanner.nextInt();
                        System.out.println("Inserisci il numero di dipartimento: ");
                        int dipartimento = scanner.nextInt();

                        dipendenteList.add(new Dipendente(nome, stipendio, dipartimento));

                        System.out.println("Vuoi inserire un altro dipendente? 1 per si, 0 per no");
                        int yesOrNo = scanner.nextInt();
                        if (yesOrNo == 0){
                            break;
                        }
                    }
                    break;
            
                case 2:
                    for (Dipendente dipendente: dipendenteList){        // stampa dei valori dell'array list
                    System.out.println("nome: " + dipendente.nome + " stipendio: euro" + dipendente.stipendio + " numero dipartimento: " + dipendente.dipartimento );
                    }           
                    break;
                
                case 3:

                    break;

                case 4:
                scanner.close();

                System.out.println("Arrivederci!");
                return;
            }

        }

    }

}
