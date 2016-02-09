package code.demoutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 9/2/16.
 */
public class FibonacciDemoTest {
    @Test
    public void testSimpleFibonacci() {
        Assert.assertEquals("message", Long.valueOf(75025), Long.valueOf(FibonacciDemo.simpleFibonacci(25)));
    }

    @Test
    public void testCacheFibonacci() {
        Assert.assertEquals("message", Long.valueOf(75025), Long.valueOf(FibonacciDemo.cacheFibonacci(25)));
    }
}
