package code.dp.abstractfactory;


/**
 * Created by anayonkar on 5/6/16.
 */
class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(ColorType colorType) {
        return null;
    }

    @Override
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
