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
            int index = 0;
            boolean flag = true;
            while (flag) {
                System.out.println("Aktuell sida: " + searchHistory.get(index));  // Visa nuvarande sida
                System.out.println("Vill du gå 'framåt', 'bakåt', eller avsluta med '*'.");
                String choice = input.nextLine();


                switch (choice) {
                    case "framåt":
                        if (index == searchHistory.size() - 1) {
                            System.out.println("Du kan inte gå längre framåt.");
                        } else {
                            index++;
                            System.out.println("Flyttat fram till: " + searchHistory.get(index));
                        }
                        break;
                    case "bakåt":
                        if (index == 0) {
                            System.out.println("Du kan inte gå längre bak.");
                        } else {
                            index--;
                            System.out.println("Flyttat bakåt till: " + searchHistory.get(index));
                        }
                        break;
                    case "*":
                        System.out.println("Programmet avslutas...");
                        flag = false;
                        break;

                    default:
                        System.out.println("Du kan endast ange 'framåt', 'bakåt', eller avsluta med '*'");
                        break;
                }

            }

        }
    }
}
