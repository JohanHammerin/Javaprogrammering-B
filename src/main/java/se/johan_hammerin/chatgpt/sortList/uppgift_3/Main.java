package se.johan_hammerin.chatgpt.sortList.uppgift_3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //1
        ArrayList<String> cars = new ArrayList<>();

        cars.add("BMW");
        cars.add("PORSCHE");
        cars.add("SAAB");
        cars.add("VOLVO");

        System.out.println(cars);

        //2
        cars.sort(Collections.reverseOrder());

        //3
        System.out.println(cars);
    }
}
