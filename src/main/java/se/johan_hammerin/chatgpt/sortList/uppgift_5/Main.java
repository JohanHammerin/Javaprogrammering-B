package se.johan_hammerin.chatgpt.sortList.uppgift_5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //1
        try(Scanner input = new Scanner(System.in)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                numbers.add(input.nextInt());
            }
            System.out.println(numbers);

            //2
            Collections.sort(numbers);

            //3
            System.out.println(numbers);



        }
    }
}
