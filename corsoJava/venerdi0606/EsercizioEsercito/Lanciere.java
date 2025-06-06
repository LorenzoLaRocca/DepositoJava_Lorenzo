package venerdi0606.EsercizioEsercito;

public class Lanciere extends Soldato{
      public Lanciere(String nome, int salute, int forzaAttacco){
        super(nome, salute, forzaAttacco);
        this.costo = 5;
    }

    @Override
    public int getCosto(){
        return costo;
    }

    @Override
    public int attacca(){
        return forzaAttacco;
    }

    @Override 
    public boolean èVivo(){
        return true;
    }
}
