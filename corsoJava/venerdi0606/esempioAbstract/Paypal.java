package venerdi0606.esempioAbstract;

public class Paypal extends CartaDiCredito {

    public Paypal(double importo, double credito){
        super(importo, credito);
    } 

    @Override
    public void verificaImporto(){
        super.verificaImporto();        // così stampo anche l'importo personalizzato
        // System.out.println("Importo da pagare: X euro");
    }

    @Override
    public void paga(){
        System.out.println("Accesso a Paypal");
        credito = credito - importo;
        System.out.println("Pagamento effettuato. Nuovo credito: " + credito);
    }

}
