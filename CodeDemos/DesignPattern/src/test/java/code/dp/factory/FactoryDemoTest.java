package code.dp.factory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 5/6/16.
 */
public class FactoryDemoTest {
    private ShapeFactory shapeFactory = new ShapeFactory();
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
