package se.johan_hammerin.Hawaii;

public class Triangle implements Shape {
    //Methods
    @Override
    public double getArea(double height, double width) {
        return (height * width) / 2;
    }

    @Override
    public double getCircumference() {
        return 0;
    }
}
