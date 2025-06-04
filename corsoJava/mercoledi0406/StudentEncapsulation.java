package mercoledi0406;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEncapsulation {

    public static class Student {

        static ArrayList<Student> StudentList = new ArrayList<>();

        private String nome;
        private int voto;
        private static int id = 0;  // fissato a zero, ma autoincrementante secondo il costruttore

        // Costruttore 
        public Student (String nome, int voto){
            this.nome = nome;
            this.voto = voto;
            id++;   // Incremento alla creazuione di un nuovo oggetto
            StudentList.add(this);
        }

        // Metodi set and get per ritornare e modificare le variabili private

        public String getName(){
            return nome;
        }

        public int getVoto(){
            return voto;
        }

        public void setVoto(int nuovoVoto){
            this.voto = nuovoVoto;
        }

        static void displayStudent(){
             if (StudentList.isEmpty()) {
                System.out.println("Nessun studente presente.");
                return;
            }
            System.out.println("Elenco degli studenti:");
            for (Student student : StudentList) {
                System.out.println("Nome: " + student.nome + ", Voto: " + student.voto);
            }
        }

        
        // Metodo per cercare studente per nome
        public static Student cercaPerNome(String nome) {
            for (Student student : StudentList) {
                if (student.getName().equals(nome)) {
                    return student;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner per input da tastiera
        Scanner scannerString = new Scanner(System.in);
      
        new Student("Lorello", 10);
        new Student("Tonno", 5);

        System.out.print("Benvenuto! ");
        
        while (true) {
            System.out.println("Scegli la funzione che preferisci: 1. Cambio Voto 2. Ricerca Studente 3. Stampa lista degli studenti 4. Uscita ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inserisci il nome dello studente: ");
                    String nomeStudente = scannerString.nextLine();
                    Student s1 = Student.cercaPerNome(nomeStudente);
                    if (s1 != null) {
                        System.out.print("Inserisci il nuovo voto: ");
                        int nuovoVoto = scanner.nextInt();
                        scanner.nextLine();
                        s1.setVoto(nuovoVoto);
                        System.out.println("Voto aggiornato!");
                    } else {
                        System.out.println("Studente non trovato.");
                    }
                    break;
            
                case 2:
                System.out.print("Inserisci il nome dello studente: ");
                    nomeStudente = scannerString.nextLine();
                    s1 = Student.cercaPerNome(nomeStudente);
                    if (s1 != null) {
                        System.out.println("Studente trovato!");
                    } else {
                        System.out.println("Studente non trovato.");
                    }
                    break;
                case 3:
                    Student.displayStudent();
                    break;
                case 4:
                    System.out.println("Arrivederci!"); 
                    scanner.close();
                    return;
            }
        }
    }
}
