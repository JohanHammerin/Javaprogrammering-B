package se.johan_hammerin.lektion_3.övning_1;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //1
        //ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();

        //2
        stringArrayList.add("Apple");
        stringArrayList.add("Banana");
        stringArrayList.add("Pineapple");
        System.out.println("stringArrayList:" + stringArrayList);

        //3
        System.out.println("första elementet:" + stringArrayList.getFirst());
        System.out.println("tredje elementet:" + stringArrayList.get(2));

    }
}
