package se.johan_hammerin.lektion_3.övning_2;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //0
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("Apple");
        stringArrayList.add("Banana");
        stringArrayList.add("Pineapple");
        System.out.println("stringArrayList:" + stringArrayList);

        //1
        stringArrayList.set(1,"Grape");
        System.out.println("stringArrayList:" + stringArrayList);

        //2
        stringArrayList.removeFirst();

        //3
        System.out.println("stringArrayList:" + stringArrayList);
    }
}
