package mercoledi0406;

import java.util.ArrayList;
import java.util.List;

/*
 * Esercizio Incapsulamento
 Creare una classi Piatto Speciale che ha ingredienti di tipo PRIVATE
 e ingredienti pubblic ( es: un panino normale o di sesamo  ) e un
 prezzo specifico per ognuno di loro (  es ingr1 = 2 euro  ) + una base
 di fisso (  prezzo = 1 euro )
 Creare poi una classe menu che permetta in loop di ordinare il
 piatto speciale selezionando tra una lista gli ingredienti public e
 facendo inserire a mano gli ingredienti PRIVATE dopo aver
 stampato una lista dei possibili casi ( solo quelli devono essere
 accettati  ) a quel punto calcolare il totale e riportare all'inizio
 */

public class EsercizioIncapsulamento {  // DA FINIRE 
    
    public static class PiattoSpeciale {
        private List<String> carne = new ArrayList<>();
        public List<String> pane = new ArrayList<>();
        private double base = 1.0; // prezzo base

        public void aggiungiIngredientePrivate(String ingrediente){
            System.out.println("Scegli il tipo di carne tra maiale e hamburger.");
            if(ingrediente.equals("maiale") || ingrediente.equals("hamburger")){
                aggiungiIngredientePrivate.add(ingrediente);
            }
        }

        public void aggiungiIngredientePublic(String ingrediente){
            System.out.println("Pane a piacere. Per favore non pane di cazzo");
            aggiungiIngredientePublic.add(ingrediente);
        }

        public double calcolaPrezzo(){

        }

    }

    public static class Menu {
        ArrayList<Menu> MenuList = new MenuList<>();

        void aggiungiOrdine () {

        }
    }

    public static void main(String[] args) {
        
    }

}
