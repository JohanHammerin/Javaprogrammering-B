package se.johan_hammerin.lektion_3.övning_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //1
        //ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("Johan");
        stringArrayList.add("Håkan");
        stringArrayList.add("Linus");
        stringArrayList.add("Erik");

        for(String s: stringArrayList) {
            System.out.println(s);
        }
    }
}
