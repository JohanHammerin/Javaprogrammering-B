package se.johan_hammerin.chatgpt.linkedList.uppgift_2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //1
        LinkedList<String> searchHistory = new LinkedList<>();
        searchHistory.add("Google.com");
        searchHistory.add("Youtube.com");
        searchHistory.add("Facebook.com");
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                int i = 0;
                System.out.println(searchHistory.get(i));
                System.out.println("Vill du gå fram eller bakåt!");
                if (input.next().equals("framåt")) {
                    i++;
                } else if (input.next().equals("bakåt")) {
                    if(i == 0) {
                        System.out.println("Du är ");
                    }
                    i--;
                }

            }

        }
    }
}
