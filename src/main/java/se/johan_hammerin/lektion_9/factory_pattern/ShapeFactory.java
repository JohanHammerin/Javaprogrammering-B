package se.johan_hammerin.lektion_9.factory_pattern;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if(shapeType == null) return null;
        if(shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        return null;
    }
}
