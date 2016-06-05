package code.dp.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 5/6/16.
 */
public class SingletonDemoTest {
    @Test
    public void singletonTest() {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Assert.assertTrue("message", obj1 != null && obj2 != null && obj1 == obj2);
    }
}
