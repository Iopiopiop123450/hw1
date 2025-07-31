package attestation01;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля");
        }
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

