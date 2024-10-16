package se.johan_hammerin.chatgpt.hashSet;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //1
        //HashSet
        HashSet<String> cars = new HashSet<>();

        cars.add("Volvo");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Porsche");


        System.out.println(cars);

        //2
        if (cars.contains("BMW")) {
            System.out.println("finns");
        } else {
            System.out.println("finns inte");
        }

        //3
        cars.remove("Volvo");
        System.out.println(cars);

        //4
        for (String s : cars) {
            System.out.println(s);
        }

        //5
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
    }
}
