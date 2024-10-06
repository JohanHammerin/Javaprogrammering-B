package se.johan_hammerin.lektion_1.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Motorcycle motorcycle = new Motorcycle();
        Bird bird = new Bird();
        Airplane airplane = new Airplane();


        car.move();
        bicycle.move();

        motorcycle.move();
        motorcycle.makeSound();

        bird.fly();
        bird.makeSound();

        airplane.fly();
        airplane.makeSound();
    }
}
