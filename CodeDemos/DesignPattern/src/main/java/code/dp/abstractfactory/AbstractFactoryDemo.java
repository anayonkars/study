package code.dp.abstractfactory;

/**
 * Created by anayonkar on 5/6/16.
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryType.COLOR);
        AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryType.SHAPE);
        Color blue = colorFactory.getColor(ColorType.BLUE);
        Color red = colorFactory.getColor(ColorType.RED);
        Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
        Shape square = shapeFactory.getShape(ShapeType.SQUARE);
        blue.fill();
        red.fill();
        circle.draw();
        square.draw();
    }
}
