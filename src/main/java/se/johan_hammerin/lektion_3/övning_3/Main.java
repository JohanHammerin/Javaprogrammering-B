package se.johan_hammerin.lektion_3.övning_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1
        List untypedList = new ArrayList();

        //2
        untypedList.add("Hej");
        untypedList.add(10);
        System.out.println(untypedList);

        //3
        String greeting = (String) untypedList.getFirst();
        int number = (int) untypedList.getLast();

        System.out.println("greeting:" + greeting);
        System.out.println("number:" + number);

    }
}
