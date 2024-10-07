package se.johan_hammerin.Hawaii.interfaces;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2, 2);
        Rectangle rectangle = new Rectangle(2, 2);
        Circle circle = new Circle(2, 2);

        //Triangle
        System.out.println("*TRIANGLE*");
        System.out.printf("area:%.2f\n", triangle.getArea());
        System.out.printf("circumference:%.2f\n", triangle.getCircumference());

        //Rectangle
        System.out.println("*RECTANGLE*");
        System.out.printf("area:%.2f\n", rectangle.getArea());
        System.out.printf("circumference:%.2f\n", rectangle.getCircumference());

        //Circle
        System.out.println("*CIRCLE*");
        System.out.printf("area:%.2f\n", circle.getArea());
        System.out.printf("circumference:%.2f\n", circle.getCircumference());
    }
}
