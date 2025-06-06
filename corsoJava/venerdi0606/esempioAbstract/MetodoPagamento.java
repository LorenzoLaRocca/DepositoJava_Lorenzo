package venerdi0606.esempioAbstract;

abstract class MetodoPagamento {
    double credito;
    double importo;

    public MetodoPagamento (double importo, double credito){
        this.importo = importo;
        this.credito = credito;
    }

    public void verificaImporto(){
        System.out.println("Importo da pagare: " + importo + " euro");
    }

    protected abstract void paga();
}
