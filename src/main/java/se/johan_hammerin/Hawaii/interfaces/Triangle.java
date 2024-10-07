package se.johan_hammerin.Hawaii.interfaces;

public class Triangle implements Shape {
    //Attributes
    private double height;
    private double width;

    //Constructor
    public Triangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }

    //Methods
    @Override
    public double getArea() {
        // Area of a triangle (width = base)
        return 0.5 * getWidth() * getHeight();
    }

    @Override
    public double getCircumference() {
        // Assuming it's a right-angled triangle
        double hypotenuse = Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));
        return width + height + hypotenuse;
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
