package mercoledi21;

import java.util.Scanner;

/*
 * Esercizio
    Scrivi un programma Java che calcoli il preventivo per un'assicurazione auto in base ai
    seguenti criteri:
    1.Età del conducente:
    ⚬ Meno di 18 anni → "Non sei idoneo per l'assicurazione"
    ⚬ 18 - 25 anni → Applica una maggiorazione del 20% sul prezzo base
    ⚬ 26 - 50 anni → Nessuna maggiorazione
    ⚬ Più di 50 anni → Sconto del 10%
    2.Anni di esperienza alla guida:
    ⚬ Meno di 2 anni → Applica una maggiorazione del 30% sul prezzo base
    ⚬ 2 o più anni → Nessuna maggiorazione
    3.Numero di incidenti negli ultimi 5 anni:
    ⚬ 0 incidenti → Nessun aumento
    ⚬ 1 incidente → Aumento del 15%
    ⚬ 2 o più incidenti → Aumento del 30%
    ⚬ Più di 4 incidenti → "Non sei idoneo per l'assicurazione"
    4.Scelta del pacchetto assicurativo:
    ⚬ Base: Prezzo standard
    ⚬ Intermedio: +20%
    ⚬ Premium: +50%
    Prezzo base dell'assicurazione: 500€
 */

public class Insurance {
    public static void main(String[] args) {

        Scanner myObjInt = new Scanner(System.in);

        double prezzoBase = 500;
         
        System.out.print("Benvenuto, Inserisci l'età: ");
        int age = myObjInt.nextInt();
       
        if (age < 18) {
            System.out.println("Non sei idoneo per l'assicurazione");
            myObjInt.close();
            System.exit(0);
        }

        System.out.println("Anni di esperienza alla guida: ");
        int yearsOfExperience = myObjInt.nextInt(); 
        
        if (yearsOfExperience < 2) {
            prezzoBase += prezzoBase * 0.30; 
        } else if (yearsOfExperience >= 2) {
            prezzoBase += 0; 
        }

        if(age >= 18 && age <= 25) {
            prezzoBase += prezzoBase * 0.20; 
        } else if (age > 50) {
            prezzoBase -= prezzoBase * 0.10; 
        }

        System.out.println("Numero di incidenti negli ultimi 5 anni: ");
        int numberOfAccidents = myObjInt.nextInt();

        switch (numberOfAccidents) {
            case 0:
                break; // No increase
            case 1:
                prezzoBase += prezzoBase * 0.15; 
                break;
            case 2:
                prezzoBase += prezzoBase * 0.30; 
                break;
            case 3:
                prezzoBase += prezzoBase * 0.30; 
                break;
            case 4:
                prezzoBase += prezzoBase * 0.30; 
                break;
            default: 
            System.out.println("Non sei idoneo per l'assicurazione");
            myObjInt.close();
            System.exit(0);
        }

        System.out.println("Scegli il pacchetto assicurativo 1.Base 2.Intermedio 3.Premium) Inserisci il numero: ");
        
        String insurancePackage = myObjInt.next();

        switch (insurancePackage) {
            case "1":
                prezzoBase += 0; 
                break;
            case "2":
                prezzoBase += prezzoBase * 0.20; 
                break;
            case "3":
                prezzoBase += prezzoBase * 0.50; 
                break;
        }
        
        System.out.println("Il prezzo finale dell'assicurazione è: " + prezzoBase + "€");
        myObjInt.close(); // Close the scanner
    }
}
