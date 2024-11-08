package se.johan_hammerin.streams.w3resource;

import java.util.List;

public class Uppgift_1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5,10,10);
        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(average);
    }
}
