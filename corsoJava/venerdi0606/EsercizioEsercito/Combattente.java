package venerdi0606.EsercizioEsercito;

public interface Combattente {
    int attacca();
    void riceviDanno(int danno);
    boolean èVivo();
    int getCosto();
    String getDescrizione(); // per output di battaglia
} 
    

