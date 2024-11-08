package se.johan_hammerin.streams.w3resource;

import java.util.List;

public class Uppgift_3 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Even
        int sumOfEven = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sumOfEven);


        //Odd
        int sumOfOdd = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sumOfOdd);
    }
}
