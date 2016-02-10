package code.tddsample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anayonkar on 10/2/16.
 */
public class ShoppingCart {
    final List<Product> productList = new ArrayList<>();
    public int getProductCount() {
        return productList.size();
    }
    public void addProduct(int quantity, Product product) {
        for(int i = 0 ; i < quantity ; i++) {
            productList.add(product);
        }
    }
}
