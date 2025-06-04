package mercoledi0406;

import java.util.ArrayList;
import java.util.Scanner;

// SET EDITARE I METODI DI INSERIMENTO

public class CompagniaAerea {
    
    public static class Aereo {
        // attributi private della classe
        private String modello;
        private int numeroPosti;
        private String codice;

        // Costruttore 
        public Aereo (String modello, int numeroPosti, String codice){
            this.modello = modello;
            this.numeroPosti = numeroPosti;
            this.codice = codice;
        }

        // Metodi set and get

        public String getModello(){
            return modello;
        }

        public void setModello(String nuovoModello){
            this.modello = nuovoModello;
        }

        public int getNumeroPosti(){
            return numeroPosti;
        }

        public void setNumeroPosti(int nuovoNumeroPosti){
            this.numeroPosti =  nuovoNumeroPosti;
        }

        public String getCodice(){
            return codice;
        }

    }   // fine classe Aereo

    public static class Pilota {
        // attributi private della classe
        private String nome;
        private String numeroBrevetto;
        private int oreVolo;

        // Costruttore
        public Pilota(String nome, String numeroBrevetto, int oreVolo){
            this.nome = nome;
            this.numeroBrevetto = numeroBrevetto;
            this.oreVolo = oreVolo;
        }

        // Metodi Set and Get

        public String getNome(){
            return nome;
        }

        public String getNumeroBrevetto(){
            return numeroBrevetto;
        }

        public int getOreVolo(){
            return oreVolo;
        }

        public void setNome(String nuovoNome){
            this.nome = nuovoNome;
        }

        public void setNumeroBrevetto(String nuovoNumeroBrevetto){
            this.numeroBrevetto = nuovoNumeroBrevetto;
        }

        public void setOreVolo(int nuovoOreVolo){
            this.oreVolo = nuovoOreVolo;
        }

    } // fine classe Pilota

    public static class Compagnia {
        // attributi private della classe
        private String nome;

        static ArrayList<Aereo> Flotta = new ArrayList<>(); // array list per conservave i vari tipi di aereo
        static ArrayList<Pilota> Piloti = new ArrayList<>(); // array list per conservare i vari piloti

        // 
        public void aggiungiAereo(Aereo aereo){
            Flotta.add(aereo);
        }

        public void aggiungiPilota(Pilota pilota){
            Piloti.add(pilota);
        }

        // Metodo che stampa tutte le informazioni disponibili
        public void displayInformazioni() { // stampo tutte le informazioni della Compagnia aerea
            System.out.println("=== Informazioni Compagnia: VolaATerra for Europe ===");        // da aggiungere in un costruttore standard
            System.out.println("=== Flotta Aerei ===");
            if (Flotta.isEmpty()) {     // check se c'è almeno un elemento nella lista
                System.out.println("Nessun aereo presente.");
            } else {
                for (Aereo aereo : Flotta) {
                    System.out.println("Modello: " + aereo.getModello());   // richiamo dei metodi pubblici ger per ottnere modello, numero posti e codice
                    System.out.println("Numero posti: " + aereo.getNumeroPosti());
                    System.out.println("Codice: " + aereo.getCodice());
                    System.out.println("---------------------");
                }
            }
    
            System.out.println("=== Piloti ===");   
            if (Piloti.isEmpty()) {     // check se c'è almeno un elemento nella lista
                System.out.println("Nessun pilota presente.");
            } else {
                for (Pilota pilota : Piloti) {  // richiamo dei metodi pubblici ger per ottnere nome, numero brevetto e ore di volo
                    System.out.println("Nome: " + pilota.getNome());
                    System.out.println("Numero brevetto: " + pilota.getNumeroBrevetto());
                    System.out.println("Ore di volo: " + pilota.getOreVolo());
                    System.out.println("---------------------");
                }
            }
        }
    } // fine classe Compagnia


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // per input da tastiera
        CompagniaAerea.Compagnia compagnia = new CompagniaAerea.Compagnia();    // istanziamente della compagnia aerea

        System.out.println("Benvenuto!");

        while(true){    // ciclo infinito che mi permette di loopare il menu
            System.out.println("Scegli una funzione: 1. Aggiungi Aereo 2. Aggiungi Pilota 3. Stampa Compagnia 4. Uscita");

            int choice = scanner.nextInt();

            switch(choice){
                 case 1:
                    CompagniaAerea.Aereo aereo = new CompagniaAerea.Aereo("Airbus", 150, "A320");   // aggiunta informazioni hardcoded
                    CompagniaAerea.Aereo aereo1 = new CompagniaAerea.Aereo("Flixbus", 100, "NaN");
                    compagnia.aggiungiAereo(aereo); // metodi richiamati dalla classe Compagnia per aggiungere le informazione all'arraylist di tipo AEREO
                    compagnia.aggiungiAereo(aereo1);
                    System.out.println("Aereo aggiunto!");
                    break;

                case 2:
                    CompagniaAerea.Pilota pilota = new CompagniaAerea.Pilota("Lorello", "HAHA1", 2000); // aggiunta informazioni hardcoded
                    CompagniaAerea.Pilota pilota1 = new CompagniaAerea.Pilota("Tobia", "TB", 200);
                    compagnia.aggiungiPilota(pilota); // metodi richiamati dalla classe Compagnia per aggiungere le informazione all'arraylist di tipo Pilota
                    compagnia.aggiungiPilota(pilota1);
                    System.out.println("Pilota aggiunto!");
                    break;

                case 3:
                    compagnia.displayInformazioni();    // metodo richiamato dalla classe Compagnia per stampare la compagnia Aerea
                    break;

                case 4:
                    System.out.println("Uscita. Arrivederci!");
                    scanner.close();
                    return;
            }
        }

    }

}
