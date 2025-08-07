package attestation01;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private Product[] bag;
    private int size;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.bag = new Product[10];
        this.size = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {

        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBagSize() {
        return size;
    }

    public Product[] getBag() {
        Product[] result = new Product[size];
        System.arraycopy(bag, 0, result, 0, size);
        return result;
    }

    public boolean buyProduct(Product product) {
        if (money >= product.getPrice()) {
            if (size >= bag.length) {
                Product[] newBag = new Product[bag.length + 2];
                System.arraycopy(bag, 0, newBag, 0, bag.length);
                bag = newBag;
            }

            bag[size] = product;
            size++;
            money -= product.getPrice();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", bag=" + Arrays.toString(bag) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && Objects.equals(name, person.name) && Objects.deepEquals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(bag));
    }
}



