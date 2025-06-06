package venerdi0606.esempioAbstract;

public class Main {
    public static void main(String[] args) {

        MetodoPagamento carta = new CartaDiCredito(10, 30);
        MetodoPagamento paypal = new Paypal(5, 20);

        System.out.println("Pagamento con Carta di Credito: ");
        carta.verificaImporto();
        carta.paga();

        System.out.println("Pagamento con Paypal: ");
        paypal.verificaImporto();
        paypal.paga();
    }
}
