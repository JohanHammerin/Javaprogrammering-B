package se.johan_hammerin.chatgpt.linkedList.uppgift_1;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {

        //1
        LinkedList<String> customers = new LinkedList<>();
        customers.add("Bob");
        customers.add("Test");
        customers.add("Peter");
        customers.add("Håkan");
        customers.add("Maxime");

        //2
        System.out.println(customers);

        //3
        customers.removeFirst();

        //4
        customers.addLast("Johan");

        //5
        System.out.println(customers.getFirst());

        //6
        System.out.println(customers);
    }


}
