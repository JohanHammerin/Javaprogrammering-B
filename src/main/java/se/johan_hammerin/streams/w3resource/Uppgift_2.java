package se.johan_hammerin.streams.w3resource;

import java.util.List;

public class Uppgift_2 {
    public static void main(String[] args) {

        List<String> names = List.of("johan","viktor");
        List<String> namesStream = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(namesStream);
    }
}
