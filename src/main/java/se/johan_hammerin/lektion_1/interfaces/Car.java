package se.johan_hammerin.lektion_1.interfaces;

public class Car implements Movable {

    //Method
    @Override
    public void move() {
        System.out.println("Bilen rör sig framåt.");
    }
}
