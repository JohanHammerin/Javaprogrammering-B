package se.johan_hammerin.chatgpt.sortList.uppgift_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        //1
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println(numbers);

        //2
        numbers.sort(Collections.reverseOrder());

        //3
        System.out.println(numbers);
    }

}
