package se.johan_hammerin.lektion_4.adventure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            while (true) {
                System.out.println("Ange nytt steg [north, south, east, west].");
                System.out.println("Ange [quit] för att avsluta.");
                String direction = input.nextLine();
                switch (direction) {
                    case "north", "east", "west", "south" -> System.out.println("Going " + direction);
                    case "quit" -> {
                        System.out.println("Programmet avslutas...");
                        return;
                    }
                }
            }
        }
    }
}
