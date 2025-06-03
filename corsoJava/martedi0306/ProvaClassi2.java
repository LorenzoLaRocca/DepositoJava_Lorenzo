package martedi0306;

import java.util.Scanner;

public class ProvaClassi2 {
    
    static class Persona{
        String nome;
        int anni;
        String citta;

        Persona(String nome, int anni){
            this.nome = "Sconosciuto";
            this.anni = 0;
            citta = "Napoli";
        }

        void mostraInfo(){
            System.out.println("Nome: " + nome + "anniu: " + anni + "Città: " + citta);

        }
    }

    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire il nome della prima persona: ");
        String nome1 = scanner.nextLine();
        System.out.print("Inserire l'età della prima persona: ");
        int anni1 = scanner.nextInt();
        scanner.nextLine(); // clear the newline

        Persona persona1 = new Persona(nome1, anni1);

        System.out.print("Inserire il nome della seconda persona: ");
        String nome2 = scanner.nextLine();
        System.out.print("Inserire l'età della seconda persona: ");
        int anni2 = scanner.nextInt();

        Persona persona2 = new Persona(nome2, anni2);

        System.out.println("\nInformazioni inserite:");
        persona1.mostraInfo();
        persona2.mostraInfo();
    }
}
