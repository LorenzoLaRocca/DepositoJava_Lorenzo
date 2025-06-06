package venerdi0606.EsercizioEsercito;

public class Main {
    public static void main(String[] args) {
        Comandante c1 = new Comandante("Luigi Cadorna", 200, 0);
        Comandante c2 = new Comandante("Otto Von Bismark", 200, 0);


        c1.setEsercito(Battaglia.generaEsercitoNemico(c1.getBudget()));
        c2.setEsercito(Battaglia.generaEsercitoNemico(c2.getBudget()));
        Battaglia.eseguiBattaglia(c1, c2);
    }
}
