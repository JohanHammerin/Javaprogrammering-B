package se.johan_hammerin.streams;

import java.util.stream.Collectors;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("Adam", "Bertil", "Caesar", "David");


        //Filter
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredNames);


        //Map
        List<String> streamNamesUpperCase = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(streamNamesUpperCase);


        List<String> streamNamesLowerCase = names.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(streamNamesLowerCase);


        //Filter & Map
        List<String> filteredAndMappedNames = names.stream()
                .filter(name -> name.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredAndMappedNames);


        //Distinct
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 1);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNumbers);


        //Sorted
        List<Integer> randomNumbers = List.of(2, 3, 1, 62, 321, 541, 31321, 1);
        List<Integer> sortedNumbers = randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumbers);



        //Limit
        List<String> names2 = List.of("Johan","Håkan","Null");
        List<String> onlyTwoFirstNames = names2.stream()
                .limit(2).
                collect(Collectors.toList());

        System.out.println(onlyTwoFirstNames);


        //Skip
        List<String> skipFirstName = names.stream()
                .skip(1) //Börjar på 1 och inte 0
                .toList();

        System.out.println(skipFirstName);
    }
}
