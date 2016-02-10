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

    @Test
    public void testSingleProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("cream", 50.0);
        cart.addProduct(1, product);
        Assert.assertEquals("message", 1, cart.getProductCount());
    }
}
