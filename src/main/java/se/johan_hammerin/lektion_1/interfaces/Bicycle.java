package se.johan_hammerin.lektion_1.interfaces;

public class Bicycle implements Movable {

    //Method
    @Override
    public void move() {
        System.out.println("Cykeln rör sig framåt.");
    }
}
