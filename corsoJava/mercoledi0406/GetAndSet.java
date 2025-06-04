package mercoledi0406;

public class GetAndSet {
    
    public static class Person {
        private String nome;    // campi private incapsulamento
        private int eta;

        // Costruttore Pubblico
        public Person(String nome, int eta){
            this.nome = nome;
            this.eta = eta;
        }

        // Metodi Set and Getters per ritornare e modificare le variabili private
        public String getName(){
            return nome;
        }
        
        public void setName(String newName){
            this.nome = newName;
        }

         public int getEta(){
            return eta;
        }
        
        public void setEta(int newEta){
            this.eta = newEta;
        }

        // Metodo privato utilizzato dalla classe
        private boolean verificaMaggiorenne(){
            return this.eta >= 18;
        }

        // Metodo pubblico che fa useo del metodo privato
        public void stampaStatus(){
            if(verificaMaggiorenne()){
                System.out.println(this.nome + " è maggiorenne.");
            } else { System.out.println(this.nome + "non è maggiorenne.");}
        }
    }

    public static void main(String[] args) {

        Person myPersona = new Person("Pippo", 25);
        myPersona.setName("Michi"); // Settiamo il valore name = "Michi"
        System.out.println(myPersona.getName());
        myPersona.stampaStatus();

    }

}
