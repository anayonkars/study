package code.tddsample;

/**
 * Created by anayonkar on 10/2/16.
 */
public class Product {
    private final String productName;
    private final double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
