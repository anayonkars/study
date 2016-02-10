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
        Assert.assertEquals(50.0, cart.getTotalCartValue(), 0.0);
    }

    @Test
    public void testMultipleProducts() {
        ShoppingCart cart = new ShoppingCart();
        Product cream = new Product("cream", 50.0);
        cart.addProduct(2, cream);
        Product soap = new Product("soap", 90.0);
        cart.addProduct(1, soap);
        Assert.assertEquals("message", 3, cart.getProductCount());
        Assert.assertEquals(190.0, cart.getTotalCartValue(), 0.0);
    }
}
