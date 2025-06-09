package giovedi0506;

class Persona {
    public void saluta(){
        System.out.println("La Persona saluta. Che brava persona");
    }
}

class Pirata extends Persona {
    @Override
    public void saluta() {
        System.out.println("Arrrrr!");
    }
}

public class MainA {
    
    public static void main(String[] args) {

        System.out.println("Ora saluta la classe persona 1: ");
        Persona persona1 = new Persona();
        persona1.saluta();
        System.out.println("Ora saluta la classe persona 2: ");
        Persona persona2 = new Persona();
        persona2.saluta();

        Pirata pirata = new Pirata();
        System.out.print("Ora saluta un pirata: ");
        pirata.saluta(); 

    }
}
