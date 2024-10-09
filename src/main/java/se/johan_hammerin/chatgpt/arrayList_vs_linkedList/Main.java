package se.johan_hammerin.chatgpt.arrayList_vs_linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int INITIAL_SIZE = 100_000;
    private static final int ADDITIONAL_ELEMENTS = 10_000;
    private static final int RANDOM_BOUND = 100;

    public static void main(String[] args) {
        Random random = new Random();

        // Skapa och fyll listorna
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Mät och skriv ut tid för insättning i slutet av ArrayList och LinkedList
        System.out.println("Tid för insättning i ArrayList: " + measureInsertionTime(arrayList, random) + " ns");
        System.out.println("Tid för insättning i LinkedList: " + measureInsertionTime(linkedList, random) + " ns");

        // Mät och skriv ut tid för insättning i början av ArrayList och LinkedList
        System.out.println("Tid för insättning i början av ArrayList: " + measureInsertionAtBeginningTime(arrayList, random) + " ns");
        System.out.println("Tid för insättning i början av LinkedList: " + measureInsertionAtBeginningTime(linkedList, random) + " ns");
    }



    // Mäter tiden för att lägga till element i slutet av en lista
    private static long measureInsertionTime(List<Integer> list, Random random) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ADDITIONAL_ELEMENTS; i++) {
            list.add(random.nextInt(RANDOM_BOUND) + 1);
        }
        return System.nanoTime() - startTime;
    }

    // Mäter tiden för att lägga till element i början av en lista
    private static long measureInsertionAtBeginningTime(List<Integer> list, Random random) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ADDITIONAL_ELEMENTS; i++) {
            list.addFirst(random.nextInt(RANDOM_BOUND) + 1);
        }
        return System.nanoTime() - startTime;
    }
}
