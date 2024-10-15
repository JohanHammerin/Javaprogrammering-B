package se.johan_hammerin.lektion_4.polymorfism;

public class Car implements Vehicle {

    //Methods
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
