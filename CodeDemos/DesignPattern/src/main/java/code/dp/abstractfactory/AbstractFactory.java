package code.dp.abstractfactory;

/**
 * Created by anayonkar on 5/6/16.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(ColorType colorType);
    public abstract Shape getShape(ShapeType shapeType);
}
