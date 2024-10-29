package se.johan_hammerin.lektion_9.builder_pattern;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.Builder().colour("Blue").engine("V8").seats(2).build();
        System.out.println(car);
    }
}
