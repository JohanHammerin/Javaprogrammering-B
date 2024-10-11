package se.johan_hammerin.chatgpt.sortList.uppgit_1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //1
        //ArrayList
        ArrayList<String> cars = new ArrayList<>();

        cars.add("BMW");
        cars.add("VOLVO");
        cars.add("FORD");
        cars.add("MAZDA");
        System.out.println(cars);

        //2
        Collections.sort(cars);

        //3
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
