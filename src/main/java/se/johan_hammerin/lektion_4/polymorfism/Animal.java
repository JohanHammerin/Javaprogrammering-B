package se.johan_hammerin.lektion_4.polymorfism;

public abstract class Animal {

    //Method
    public abstract void makeSound();
    public void sleep(){
        System.out.println(getClass().getSimpleName() + " is sleeping");
    };
}
