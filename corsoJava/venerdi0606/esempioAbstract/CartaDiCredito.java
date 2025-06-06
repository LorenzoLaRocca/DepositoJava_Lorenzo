package venerdi0606.esempioAbstract;

public class CartaDiCredito extends MetodoPagamento {
    
    public CartaDiCredito(double importo, double credito){
        super(importo, credito);
    }

    @Override
    public void verificaImporto(){
        super.verificaImporto();
        //System.out.println("Importo da pagare: X euro");
    }

    @Override
    public void paga(){
        System.out.println("Accesso alla carta di credito");
        credito = credito - importo;
        System.out.println("Pagamento con carta di credito effettuato. Nuovo credito: " + credito);
    }
}
