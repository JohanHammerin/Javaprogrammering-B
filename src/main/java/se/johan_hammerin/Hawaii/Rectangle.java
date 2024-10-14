package se.johan_hammerin.Hawaii;

public class Rectangle implements Shape {
    //Attributes
    private double height;
    private double width;

    //Constructor
    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }

    //Methods
    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }

    @Override
    public double getCircumference() {
        return 2 * (getHeight() + getWidth());
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
