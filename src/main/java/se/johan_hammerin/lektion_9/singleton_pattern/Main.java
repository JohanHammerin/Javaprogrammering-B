package se.johan_hammerin.lektion_9.singleton_pattern;

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
