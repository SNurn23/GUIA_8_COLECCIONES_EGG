import java.util.Objects;

public class Product implements Comparable<Product>{
    private String product;
    private double price;

    public Product(String product, double price)  {
        this.product = product;
        this.price = price;
    }

    public Product() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return product.compareTo(o.getProduct());
    }
}
