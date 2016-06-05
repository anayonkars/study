package code.dp.abstractfactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 5/6/16.
 */
public class AbstractFactoryDemoTest {
    private AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryType.COLOR);
    private AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryType.SHAPE);
    @Test
    public void testColorFactory() {
        Assert.assertTrue("message", ColorFactory.class.isAssignableFrom(colorFactory.getClass()));
    }
    @Test
    public void testColorFactoryNegative() {
        for(ShapeType shapeType : ShapeType.values()) {
            Assert.assertNull("message", colorFactory.getShape(shapeType));
        }
    }
    @Test
    public void testShapeFactory() {
        Assert.assertTrue("message", ShapeFactory.class.isAssignableFrom(shapeFactory.getClass()));
    }
    @Test
    public void testShapeFactoryNegative() {
        for(ColorType colorType : ColorType.values()) {
            Assert.assertNull("message", shapeFactory.getColor(colorType));
        }
    }
    @Test
    public void BlueTest() {
        Assert.assertTrue("message", Blue.class.isAssignableFrom(colorFactory.getColor(ColorType.BLUE).getClass()));
    }
    @Test
    public void BlueTestNegative() {
        Assert.assertFalse("message", Red.class.isAssignableFrom(colorFactory.getColor(ColorType.BLUE).getClass()));
    }
    @Test
    public void RedTest() {
        Assert.assertTrue("message", Red.class.isAssignableFrom(colorFactory.getColor(ColorType.RED).getClass()));
    }
    @Test
    public void RedTestNegative() {
        Assert.assertFalse("message", Blue.class.isAssignableFrom(colorFactory.getColor(ColorType.RED).getClass()));
    }
    @Test
    public void CircleTest() {
        Assert.assertTrue("message", Circle.class.isAssignableFrom(shapeFactory.getShape(ShapeType.CIRCLE).getClass()));
    }
    @Test
    public void CircleTestNegative() {
        Assert.assertFalse("message", Square.class.isAssignableFrom(shapeFactory.getShape(ShapeType.CIRCLE).getClass()));
    }
    @Test
    public void SquareTest() {
        Assert.assertTrue("message", Square.class.isAssignableFrom(shapeFactory.getShape(ShapeType.SQUARE).getClass()));
    }
    @Test
    public void SquareTestNegative() {
        Assert.assertFalse("message", Circle.class.isAssignableFrom(shapeFactory.getShape(ShapeType.SQUARE).getClass()));
    }
}
