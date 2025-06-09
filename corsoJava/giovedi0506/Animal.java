package giovedi0506;

public static class Animal {
    public void animalSound(){
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal {
    public void animalSound(){
        System.out.println("The dog says: bow wow");
    }
}

static Main {
    public static void main(String[] args) {
        Animal myAnimal = newAnimal();
        Animal mypig = newPig();
        Animal myDog = newDog();

        myAnimal.animalSound();
        mypig.animalSound();
        myDog.animalSound();

    }
}
