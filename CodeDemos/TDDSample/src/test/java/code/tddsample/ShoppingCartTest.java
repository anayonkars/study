package code.tddsample;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 10/2/16.
 * Referred from http://www.basicsbehind.com/tdd-by-example/
 */
public class ShoppingCartTest {
    @Test
    public void testEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals("message", 0, cart.getProductCount());
    }
}
