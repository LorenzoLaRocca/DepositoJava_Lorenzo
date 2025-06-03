package martedi0306;

public class ProvaClassi1 {
  
    static class Libro {
       
        String titolo;
        String autore;
        int prezzo;

        static int codice_numerico_autoincrementante;

        Libro(String titolo, String autore, int prezzo) {
            this.titolo = titolo;
            this.autore = autore;
            this.prezzo = prezzo;
            codice_numerico_autoincrementante++;
        }

        void mostraInfo() {
            System.out.println("Titolo: " + titolo + "Autore: " + autore + "Prezzo: " + prezzo);
        }
    }

    public static void main(String[] args) {
;
        Libro libro1 = new Libro("Libro Generico 1 ", " autore generico 1 ", 10);
        Libro libro2 = new Libro("Libro generico 2 ", " autore gnerico 2 ", 20);

        libro1.mostraInfo();
        libro2.mostraInfo();
    }
}