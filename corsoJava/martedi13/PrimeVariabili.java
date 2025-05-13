public class PrimeVariabili {
    public static void main(String[] args) { 

        int provaNumero = 12; // inizializzo una variabile di tipo intero
        System.out.println(provaNumero); // stampo il valore della variabile provaNumero

        String provaTesto = "br br patapim"; // inizializzo una variabile di tipo stringa
        System.out.println(provaTesto); // stampo il valore della variabile provaTesto

        boolean provaBool = true; // inizializzo una variabile di tipo booleano
        System.out.println(provaBool); // stampo il valore della variabile provaBool


        boolean provaBool2;// dichiaro una variabile di tipo booleano ma non la inizializzo
        provaBool2 = false; // la inizializzo in un secondo momento
        provaBool2 = true; // cambio valore
        System.out.println(provaBool2); // stampo il valore della variabile provaBool2

        
        final int provaNumero2 = 12; // inizializzo una costante di tipo intero
        // provaNumero2  = 13; // genera errore! non posso cambiare il valore di una costante
        System.out.println(provaNumero2); // stampo il valore della variabile provaNumero
        
        String testo = "Mondo";
        System.out.println("ciao " + testo); // concateno la stringa "ciao" con il valore della variabile testo

        String firstPart = "Ciao ";
        String lastPart = "Mondo";
        String fullPart = firstPart + lastPart; // concateno le due stringhe
        System.out.println(fullPart); // stampo la stringa concatenata

        // Prove di tipi di dichiarazione e inizializzazione per gli interi

        int x = 5;  // inizializzazione di una variabile di tipo intero semplice
        int y = 6;
        System.out.println(x + y); // somma di due variabili intere

        int a = 5, b = 6, c = 50; // inizializzo tre variabili intere a cascata
        System.out.println(a + b + c); // somma di tre variabili intere

        int d, e, f; // dichiaro tre variabili intere
        d = e = f = 50; // inizializzazione a cascata
        System.out.println(d+e+f); 

        // Prove di un tiopo double
        double myDouble = 31.12d; // inizializzo una variabile di tipo double
        System.out.println(myDouble); // stampo il valore della variabile myDouble
    }
}
