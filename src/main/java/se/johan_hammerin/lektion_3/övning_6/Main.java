package se.johan_hammerin.lektion_3.övning_6;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //1
        //LinkedList
        List<String> tasks = new LinkedList<>();

        //2
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");

        System.out.println(tasks);

        //3
        tasks.removeFirst();
        System.out.println(tasks);
    }
}
