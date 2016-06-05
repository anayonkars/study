package code.dp.abstractfactory;

/**
 * Created by anayonkar on 5/6/16.
 */
class FactoryProducer {
    public static AbstractFactory getFactory(FactoryType factoryType) {
        switch (factoryType) {
            case COLOR:
                return new ColorFactory();
            case SHAPE:
                return new ShapeFactory();
            default:
                return null;
        }
    }
}
