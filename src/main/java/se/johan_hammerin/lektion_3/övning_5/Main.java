package se.johan_hammerin.lektion_3.övning_5;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    //Constants
    private static final int NUMBER_OF_ELEMENTS = 100_000;

    public static void main(String[] args) {

        //1
        //LinkedList
        LinkedList<Integer> integersLinkedList = new LinkedList<>();
        //ArrayList
        ArrayList<Integer> integersArrayList = new ArrayList<>();
        //Random
        Random random = new Random();

        //LinkedList
        long linkedList = runTime(integersLinkedList, random);
        //ArrayList
        long arrayList = runTime(integersArrayList, random);

        System.out.println(linkedList + " ns");
        System.out.println(arrayList + " ns");

        //2
        //Jag skulle använt mig av en LinkedList istället för en ArrayList!
    }

    private static long runTime(List<Integer> list, Random random) {
        long before = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            list.add(random.nextInt(10_000) + 1);
        }
        long after = System.nanoTime();
        return after - before;
    }
}
