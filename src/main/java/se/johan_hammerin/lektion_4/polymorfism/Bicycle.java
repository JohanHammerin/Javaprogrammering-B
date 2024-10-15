package se.johan_hammerin.lektion_4.polymorfism;

public class Bicycle implements Vehicle {

    //Method
    @Override
    public void move() {
        System.out.println("Bicycle is moving");
    }
}
