package venerdi0606.EsercizioEsercito;

abstract class Soldato implements Combattente{
    protected String nome;
    protected int salute;
    protected int forzaAttacco;
    protected int costo;

    public Soldato(String nome, int salute, int forzaAttacco){
        this.nome = nome;
        this.salute = salute;
        this.forzaAttacco = forzaAttacco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalute(int salute) {
        this.salute = salute;
    }

    public void setForzaAttacco(int forzaAttacco) {
        this.forzaAttacco = forzaAttacco;
    }

    public int attacca(){
        return 0;
    }
   
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    @Override
    public void riceviDanno(int danno){
        salute -= danno;
    System.out.println(nome + " ha ricevuto " + danno + " danni. Salute rimanente: " + salute);
    }
    
    public boolean èVivo(){
        return salute > 0;
    }
    public String getDescrizione(){
        return "Descrizione vuota";
    } // per output di battaglia

    public int getForzaAttacco(){
        return forzaAttacco;
    }

    public int getSalute(){
        return salute;
    }
}
