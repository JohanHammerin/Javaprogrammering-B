package se.johan_hammerin.lektion_4.polymorfism;

public class Dog extends Animal {

    //Methods
    @Override
    public void makeSound() {
        System.out.println("Woff");
    }

    public void fetch() {
        System.out.println("Dog is running towards the ball!🥴🏃‍♂️");
    }
}
