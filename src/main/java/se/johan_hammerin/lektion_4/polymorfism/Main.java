package se.johan_hammerin.lektion_4.polymorfism;

public class Main {
    public static void main(String[] args) {

        //Övning 1
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        car.move();
        bicycle.move();
    }
}
