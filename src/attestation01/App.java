package attestation01;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Person[] customers;
    private static Product[] products;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация массивов
        customers = new Person[10];
        products = new Product[10];


        // Ввод продуктов
        System.out.println("Введите данные о продуктах (формат: Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150):");
        String productsInput = scanner.nextLine();

        String[] productEntries = productsInput.split(";");
        for (int i = 0; i < productEntries.length; i++) {
            String entry = productEntries[i];
            String[] parts = entry.split("=");
            if (parts.length != 2) {
                System.out.println("Неверный формат ввода. Попробуйте еще раз.");
                continue;
            }
            String name = parts[0].trim();
            int price = getValidPrice(parts[1]);
            products[i] = new Product(name, price);
            System.out.println(Arrays.toString(products));

        }



        // Ввод покупателей
        System.out.println("\nВведите данные о покупателях (имя=сумма): Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10");
            String personsInput = scanner.nextLine();
            String[] personEntries = personsInput.split(";");
            for (int i = 0; i < personEntries.length; i++) {
                String entry = personEntries[i];
                String[] parts = entry.split("=");

            if (parts.length != 2) {
                System.out.println("Неверный формат ввода. Попробуйте еще раз.");
                continue;
            }

            String name = parts[0].trim();
            int money = getValidPrice(parts[1]);

            customers[i] = new Person(name, money);
            System.out.println(Arrays.toString(customers));
        }

        // Процесс покупок
        System.out.println("\nНачинаем покупки. Введите данные в формате Покупатель - Продукт или END для завершения:");
        boolean shopping = true;
        int currentCustomer = 0;

        while (shopping) {

            customers[currentCustomer].getName();

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("END")) {
                shopping = false;
                break;
            }

            String[] inputEntries = input.split("-");
            String customerName = inputEntries[0].trim();
            String productName = inputEntries[1].trim();
            System.out.println(customerName + " " + productName);

            int customerIndex = findCustomerIndex(customerName);
            System.out.println(customerIndex);

            currentCustomer = customerIndex;

            Product selectedProduct = findProduct(products, productName);

            if (selectedProduct != null) {
                if (customers[currentCustomer].buyProduct(selectedProduct)) {
                    System.out.println("Покупка успешна! " + selectedProduct.getName() + " добавлен в корзину.");
                } else {
                    System.out.println(customers[currentCustomer].getName() +
                            " не может позволить себе " + selectedProduct.getName());
                }
            } else {
                System.out.println("Продукт не найден!");
            }

            currentCustomer++;
            if (currentCustomer >= customers.length || customers[currentCustomer] == null) {
                currentCustomer = 0;
            }
        }

        // Вывод результатов
        System.out.println("\nРезультаты покупок:");
        for (Person customer : customers) {
            if (customer == null) {
                break;
            }
            if (customer.getBagSize() == 0) {
                System.out.println(customer.getName() + " - Ничего не куплено");
            } else {
                System.out.println(customer);
            }
        }

        scanner.close();
    }

    // Валидация цены/денег
    private static int getValidPrice(String input) {
        int price = -1;
        try {
            price = Integer.parseInt(input.trim());
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректная сумма! Должен быть положительный целый номер.");
            price = -1;
        }
        return price;
    }

    // Поиск продукта по названию
    private static Product findProduct(Product[] products, String name) {
        for (Product product : products) {
            if (product != null && product.getName().toUpperCase().equals(name)) {
                return product;
            }
        }
        return null;
    }

    private static int findCustomerIndex(String customerName) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getName().equalsIgnoreCase(customerName)) {
                return i;
            }
        }
        return -1; // Покупатель не найден
    }
}
