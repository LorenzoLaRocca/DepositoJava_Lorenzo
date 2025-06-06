package venerdi0606.EsercizioEsercito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battaglia {
    
    public static List<Soldato> generaEsercitoNemico(int budget){
        List<Soldato> esercitoNemico = new ArrayList<>();
        int costoMinimo = 5;
        
        Random random = new Random();

        while(budget >= costoMinimo){
            int scelta = random.nextInt(3);
            Soldato soldato;

            switch (scelta) {
                case 0:
                    soldato = new Lanciere("Lanciere", 10, 4);
                    break;
                case 1:
                    soldato = new Arciere("Arciere", 5, 6);
                    break;
                case 2:
                    soldato = new Cavaliere("Berlusconi", 15, 10);
                    break;
                default: throw new IllegalStateException("Soldato sconosciuto");
            }
            
            int costoParziale = soldato.getCosto();
            esercitoNemico.add(soldato);
            budget -= costoParziale;

        }
        
        return esercitoNemico;
    }

    public static boolean eseguiBattaglia(Comandante c1, Comandante c2){
        List<Soldato> esercito1 = c1.getEsercito();
        List<Soldato> esercito2 = c2.getEsercito();

        int count = 0;
        while (!esercito1.isEmpty() && !esercito2.isEmpty()) {
            c1.combatti(esercito2, count);
            count++;
            c2.combatti(esercito1, count);
            count++;
        }

        if (esercito1.isEmpty()) {
            System.out.println(c2.getNome() + " ha vinto la battaglia!");
            return false;
        } else {
            System.out.println(c1.getNome() + " ha vinto la battaglia!");
            return true;
        }
    }
    
}
