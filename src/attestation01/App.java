package attestation01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Person person = new Person("0000",1);
        Product product = new Product("0000",1);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Имя покупателя:");
        String personName = scanner.nextLine();
        person.setName(personName);

        System.out.println("Количество денег:");
        int personMoney = scanner.nextInt();
        person.setMoney(personMoney);

        System.out.println(personName + " " + personMoney);

        }
    }
