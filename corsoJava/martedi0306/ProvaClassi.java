package martedi0306;

public class ProvaClassi {
    // static class Auto {
    // String marca;
    // int anno;
    // double prezzo;

    // void mostraInfo() {
    // System.out.println(marca + " - " + anno + " - " + prezzo + " euro");
    // }
    // }

    // static class Studente {
    // String nome;
    // static int totaleStudenti = 0;

    // Studente(String nome) {
    // this.nome = nome;
    // totaleStudenti++;
    // }
    // }

    static class Libro {
        // Attributi dell'istanza: titolo, autore e prezzo del libro
        String titolo;
        String autore;
        float prezzo;

        // Attributo statico che tiene traccia del numero totale di libri creati
        static int codice_numerico_autoincrementante;

        // Costruttore della classe, inizializza i dati del libro e incrementa il
        // contatore statico ogni volta che viene creato un nuovo libro
        Libro(String titolo, String autore, float prezzo) {
            this.titolo = titolo;
            this.autore = autore;
            this.prezzo = prezzo;
            codice_numerico_autoincrementante++;
        }

        // Metodo per stampare i dettagli del libro su console
        void stampaDettagli() {
            System.out.println("Titolo: " + titolo + "\nAutore: " + autore + "\nPrezzo: " + prezzo + "\n");
        }
    }

    public static void main(String[] args) {
        // Auto miaAuto = new Auto();
        // miaAuto.marca = "Tesla";
        // miaAuto.anno = 2023;
        // miaAuto.prezzo = 59999.99;

        // miaAuto.mostraInfo();

        // Studente io = new Studente("Riccardo");
        // System.out.println("Nome: " + io.nome);
        // System.out.println("Numero studenti: " + io.totaleStudenti);

        Libro lib1 = new Libro("Bibbia", "Tanta gente", 20);
        Libro lib2 = new Libro("Divina Commedia", "Dante Alighieri", 15);

        lib1.stampaDettagli();
        lib2.stampaDettagli();
    }
}