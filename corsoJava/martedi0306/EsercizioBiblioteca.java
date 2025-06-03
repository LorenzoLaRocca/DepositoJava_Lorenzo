package martedi0306;

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * Sfida Avanzata: Sistema di Gestione della Biblioteca
 Requisiti Base:
 1⃣
 Creare una Classe Book con:
 String title (Titolo del libro)
 String author (Autore del libro)
 boolean isAvailable (Disponibilità del libro)
 Metodo void displayBookInfo() → Mostra le informazioni del libro.
 2⃣
 Creare una Classe Library con:
 ArrayList<Book> books → Una lista dinamica di libri.
 Metodo void addBook(Book book) → Aggiunge un libro alla biblioteca.
 Metodo void displayBooks() → Mostra tutti i libri presenti nella biblioteca.
 Metodo void borrowBook(String title) → Permette di prendere in prestito un libro
 (solo se disponibile).
 3⃣
 Implementare il Programma Principale per:
 Aggiungere libri alla biblioteca.
 Mostrare tutti i libri disponibili.
 Permettere agli utenti di prendere in prestito un libro.
 */


public class EsercizioBiblioteca {

    public static class Book{   // definizione classe book
        String title;   // titolo del libro
        String author;  // Autore del libro
        boolean isAvailable;    // variabile che ci permette di capire se il libro è disponibile

        Book(String title, String author, boolean isAvailable){ // costruttore
            this.title = title;
            this.author = author;
            this.isAvailable = isAvailable;
        }

        void displayBookInfo(){ // Metodo 
            System.out.println("Titolo: " + title + "Autore: " + author + "Disponibilità " + isAvailable);  
        }
    } // fine classe

    public static class Library{
        ArrayList<Book> books = new ArrayList<>(){{         // hardcoded libri iniziali
            add(new Book("Il Signore dei Lorelli", " Tolkien ", true));
            add(new Book("Lo Hobbit", " Tolkien ", false));
            add(new Book("El Riporter", " Un Pelato ", true));
        }};

        void displayBooks(){            // metodo stampa di tutti i libri
            for (Book book : books) {   // ciclo sulla classe Book
                book.displayBookInfo();
            }
        }

        void addBook(Book book) {   // metodo per aggiungere il libro alla libreria
        books.add(book);
        } //da implementare con input

        void borrowBook(String title){
            for(Book book : books){         // ciclo sulla classe Book
                if(book.title.equals(title)){       // controllo se il titolo da input è uguale a quello nell'array list
                    if(book.isAvailable){       // controllo se il libro è disponibile
                        book.isAvailable = false;   // modifico semplicemente la variabile isAvailable per rendere il libro non disponibile
                        System.out.println("Hai preso in prestito: " + book.title);
                    } else {                       // se non è disponibile stampiamo il risultato
                         System.out.println("Il libro " + book.title + " non è disponibile."); 
                    }
                    return;
                }
            }
            System.out.println("Libro non trovato: " + title);  // stampa di fallimento del controllo presenza libro nella classe Book
        }
    

    }   // fine classe Library

    public static void main(String[] args) {

        Library myLibrary = new Library();
        Scanner scannerInt = new Scanner(System.in);    // Scanner per la scelta dei menu'
        Scanner scannerString = new Scanner(System.in);

        
        while (true) {
            System.out.println("Benvenuto! Scegli L'operazione da fare: 1. Aggiungere un libro 2. Stampa dei libri disponibli 3. Prendere in prestito un libro 4. Uscita");
            int choice = scannerInt.nextInt();  // inputer per la scelta del menù
            switch (choice) {
                case 1:
                    myLibrary.addBook(new Book("Belli ", " Brutto ", true));    // ho fatto un inserimento non da input ma hardcoded per fare prima, posso modificarlo in seguito
                    break;
                case 2:
                    myLibrary.displayBooks();   // call del metodo di stampa dei libri nella classe Book
                    break;
                case 3:
                    System.out.print("\nInserisci il titolo del libro che vuoi prendere in prestito: ");
                    String libroDaPrestare = scannerString.nextLine();
                    myLibrary.borrowBook(libroDaPrestare);  // call del metodo di prestito nella classe Library
                    break;
                case 4:
                    System.out.println("Arrivederci!");
                    return; // seplice uscita dal loop di programma
            }
        }
    }
    
}
