package code.dp.abstractfactory;

/**
 * Created by anayonkar on 5/6/16.
 */
class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(ColorType colorType) {
        switch (colorType) {
            case BLUE:
                return new Blue();
            case RED:
                return new Red();
            default:
                return null;
        }
    }

    @Override
    public Shape getShape(ShapeType shapeType) {
        return null;
    }
}
