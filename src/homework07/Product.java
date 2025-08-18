package homework07;

import java.util.Objects;

public class Product {
    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}

class DiscountProduct extends Product {
    private double discount;
    private int discountLength;

    public DiscountProduct(String name, int price, double discount, int discountLength) {
        super(name, price);
        this.discount = discount;
        this.discountLength = discountLength;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDiscountLength() {
        return discountLength;
    }

    public void setDiscountLength(int discountLength) {
        this.discountLength = discountLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Double.compare(discount, that.discount) == 0 && discountLength == that.discountLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountLength);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", discountLength=" + discountLength +
                '}';
    }
}

