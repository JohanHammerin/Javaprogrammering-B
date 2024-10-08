package se.johan_hammerin.lektion_2.calculator;

public class Circle {
    public static final double PI = 3.13159;

    public static double getArea(double radius) {
        return Math.pow(radius,2) * PI;
    }
}
