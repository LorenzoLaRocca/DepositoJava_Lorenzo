package giovedi0506;

import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animale> animali;

    // Costruttore della classe Zoo
    public Zoo(){
        animali = new ArrayList();
    }

    public static class Animale {
        private String nome;
        private int eta;

        public Animale(String nome, int eta){
            this.nome = nome;
            this.eta = eta;
        }

        // metodi sett and get
        
        public String getNome(){
            return nome;
        }

        public int getEta(){
            return eta;
        }

        public void setNome(String nuovoNome){
            this.nome = nuovoNome;
        }

        public void setEta(int nuovoEta){
            this.eta = nuovoEta;
        }

        public void faiVerso(){
            System.out.println("UE UE fozza napoli!");
        }
    } // fine classe Animale

    public class Gatto extends Animale {
        
        // Costruttore
        public Gatto(String nome, int eta) {
            super(nome, eta);
        }

        @Override   // Override del metodo faiVerso delle classe padre, con il verso giusto o quasi
        public void faiVerso(){
            System.out.println("meow meow pezz i mmè!");
        }

    } // fin classe gatto

    public class Cane extends Animale {

        // Costruttore
        public Cane (String nome, int eta){
            super(nome, eta);
        }

        @Override // Override del metodo faiVerso delle classe padre, con il verso giusto o quasi
        public void faiVerso(){
            System.out.println("Bau Bau sono tony il mafioso");
        }
    } // fin classe cane

    public class Scimmia extends Animale {

        // Costruttore
        public Scimma (String nome, int eta){
            super(nome, eta);
        }

        @Override // Override del metodo faiVerso delle classe padre, con il verso giusto o quasi
        public void faiVerso(){
            System.out.println("Bau Bau sono tony il mafioso");
        }
    } // fin classe scimmia
}
