package venerdi0606.EsercizioEsercito;

public class Cavaliere extends Soldato {
    
    public Cavaliere(String nome, int salute, int forzaAttacco){
        super(nome, salute, forzaAttacco);
        this.costo = 20;
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
