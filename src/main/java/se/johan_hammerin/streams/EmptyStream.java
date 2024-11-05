package se.johan_hammerin.streams;

import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class EmptyStream {
    public static void main(String[] args) {

        //Stream.of()
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p -> System.out.println(p));

        //Stream.of(array)
        Stream<Integer> integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9,});
        integerStream.forEach(p -> System.out.println(p));



    }

}
