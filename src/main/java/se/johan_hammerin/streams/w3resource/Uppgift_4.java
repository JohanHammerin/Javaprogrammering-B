package se.johan_hammerin.streams.w3resource;

import java.util.List;

public class Uppgift_4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 1, 1, 1, 12, 2, 5, 2, 3, 2, 2, 4, 23, 3, 3);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println(uniqueNumbers);

    }
}
