package attestation01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private List<Product> bag;

    public Person (String name, int money) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Имя должно быть не менее 3 символов");
        }

        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом");
        }

        this.name = name;
        this.money = money;
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public List<Product> getBag() {
        return new ArrayList<>(bag);
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Имя должно быть не менее 3 символов");
        }
        this.name = name;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом");
        }
        this.money = money;
    }

    public boolean buyProduct(Product product) {
        if(product ==null) {
        throw new IllegalArgumentException("Продукт не может быть пустым");
    }
        if(money >=product.getPrice()) {
        bag.add(product);
        money -= product.getPrice();
        return true;
    }
        return false;
}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && Objects.equals(name, person.name) && Objects.equals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", bag=" + bag +
                '}';
    }
}
