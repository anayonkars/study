package code.dp.factory;

/**
 * Created by anayonkar on 5/6/16.
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
        Shape square = shapeFactory.getShape(ShapeType.SQUARE);
        circle.draw();
        square.draw();
    }
}
