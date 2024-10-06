package se.johan_hammerin.lektion_1.interfaces;

public class Motorcycle implements Soundable, Movable {

    //Methods
    @Override
    public void makeSound() {
        System.out.println("Motorcykeln gör ljud: Vroom!");
    }

    @Override
    public void move() {
        System.out.println("Motorcykeln rörde sig framåt.");
    }
}
