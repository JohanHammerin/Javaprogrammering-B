package se.johan_hammerin.chatgpt.arrayList.uppgift_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            integerArrayList.add(random.nextInt(100) + 1);
        }

        //2
        System.out.println(integerArrayList);

        //3
        integerArrayList.addFirst(100);

        //4
        if(integerArrayList.getFirst() == 100) {
            System.out.println("100 finns på första platsen i ArrayListen");
        }

        //5
        System.out.println("Innan sortering");
        System.out.println(integerArrayList);
        Collections.sort(integerArrayList);
        System.out.println("Efter sortering");
        System.out.println(integerArrayList);
    }
}
