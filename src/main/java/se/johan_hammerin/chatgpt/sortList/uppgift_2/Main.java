package se.johan_hammerin.chatgpt.sortList.uppgift_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1
        //ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        //Random;
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
        System.out.println(numbers);

        //2
        Collections.sort(numbers);

        //3
        System.out.println(numbers);


    }
}
