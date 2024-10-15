package se.johan_hammerin.lektion_4.polymorfism;

public class Cat extends Animal {
    //Method
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
