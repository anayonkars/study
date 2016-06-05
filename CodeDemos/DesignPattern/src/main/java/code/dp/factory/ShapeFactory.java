package code.dp.factory;

/**
 * Created by anayonkar on 5/6/16.
 */
public class ShapeFactory {
    public Shape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
