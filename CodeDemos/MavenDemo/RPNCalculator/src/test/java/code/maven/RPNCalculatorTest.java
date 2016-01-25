package code.maven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by anayonkar on 25/1/16.
 */
public class RPNCalculatorTest {
    @Test
    public void testSimpleAddition() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int expectedResult = 15;
        int actualResult = rpnCalculator.evaluate("10 5 +");
        assertEquals(expectedResult, actualResult);

		/*expectedResult = 25;
		actualResult = rpnCalculator.evaluate("10 15 +");
		assertEquals(expectedResult, actualResult);*/

		/*expectedResult = 60;
		actualResult = rpnCalculator.evaluate("10 2 + 10 5 - *");
		assertEquals(expectedResult, actualResult);*/
    }
    @Test
    public void testExpression() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int expectedResult = 60;
        int actualResult = rpnCalculator.evaluate("10 2 + 10 5 - *");
        assertEquals(expectedResult, actualResult);
    }
}
