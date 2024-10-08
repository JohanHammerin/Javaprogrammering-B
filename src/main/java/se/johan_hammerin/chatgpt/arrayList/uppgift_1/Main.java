package se.johan_hammerin.chatgpt.arrayList.uppgift_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        //1
        students.add("Bob");
        students.add("Håkan");
        students.add("John");
        students.add("Test");
        students.add("Adam");

        //2
        System.out.println(students);

        //3
        students.set(1, "newName");

        //4
        students.removeLast();

        //5
        System.out.println(students.get(2));

        //6
        System.out.println(students);
    }
}
