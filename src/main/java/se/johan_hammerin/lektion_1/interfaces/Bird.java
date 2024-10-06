package se.johan_hammerin.lektion_1.interfaces;

public class Bird implements Flyable, Soundable {
    //Methods
    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " flyger!");
    }

    @Override
    public void makeSound() {
        System.out.println("Fågeln kvittrar.");
    }
}
