package se.johan_hammerin.Hawaii.interfaces;

public class Circle implements Shape {
    //Attributes
    private double height;
    private double width;

    //Constructor
    public Circle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }


    //Methods
    @Override
    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * getRadius();
    }

    private double getRadius() {
        return getWidth() / 2;
    }

    //Getters & Setters
    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}
