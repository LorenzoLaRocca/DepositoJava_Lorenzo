package venerdi0606.EsercizioEsercito;

public class Arciere extends Soldato{
    
    public Arciere(String nome, int salute, int forzaAttacco){
        super(nome, salute, forzaAttacco);
        this.costo = 8;
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
