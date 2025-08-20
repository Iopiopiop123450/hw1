package homework07;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Person[] customers;
    private static Product[] products;
    private static DiscountProduct[] discountProducts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация массивов
        customers = new Person[10];
        products = new Product[10];
        discountProducts = new DiscountProduct[10];


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

                    if (name == null || name.length() < 3) {
                        System.out.println("Имя должно быть не менее 3 символов");
                        continue;
                    }

                    int money = getValidPrice(parts[1]);

                    customers[i] = new Person(name, money);
                }


        // Ввод продуктов без скидки
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

                if (!isValidProductName(name)) {
                    System.out.println("Название продукта должно быть не менее 3 символов и не должно состоять из цифр");
                    continue;
                }

                int price = getValidPrice(parts[1]);
                products[i] = new Product(name, price);
            }

        // Ввод продуктов со скидкой
        boolean discounts = true;
            boolean check = true;
            int discountIndex = 0;
        while (discounts) {
            System.out.println("Введите продукт со скидкой в формате Название;Цена;Скидка;Длительность (пример: Хлеб;40;0.2;3) или END для перехода к покупкам");
            String discountProductsInput = scanner.nextLine();
            if (discountProductsInput.equals("END")) {
                 break;
            }
            String[] parts = discountProductsInput.split(";");
            String name = parts[0].trim();
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].getName().equals(name))
                {
                    System.out.println("Продукт был введен ранее");
                    check = false;
                    break;
                }
            }
            if (!check) {
                continue;
            }

            if (!isValidProductName(name)) {
                System.out.println("Название продукта должно быть не менее 3 символов и не должно состоять из цифр");
                continue;
            }

            double discount = Double.parseDouble(parts[2].trim());
            int validPrice = getValidPrice(parts[1]);
            double discountedPrice = validPrice * (1 - discount);
            int price = (int) Math.round(discountedPrice);
            if (!isValidDiscountedPrice(price)) {
                System.out.println("Если стоимость продукта или скидочного продукта 0 или отрицательная, то такая цена неправильная");
                continue;
            }

            int discountLength = Integer.parseInt(parts[3].trim());
                discountProducts[discountIndex] = new DiscountProduct(name, price, discount, discountLength);
                discountIndex++;
            }


        System.out.println(Arrays.toString(discountProducts));
        System.out.println(Arrays.toString(products));

        Product[] combined = new Product[products.length + discountProducts.length];
        System.arraycopy(discountProducts,0,combined,0,discountProducts.length);
        System.arraycopy(products,0,combined,discountProducts.length,products.length);
        System.out.println(Arrays.toString(combined));

        products = combined;

        System.out.println(Arrays.toString(products));

        // Процесс покупок
        System.out.println("\nНачинаем покупки. Введите данные в формате: Покупатель - Продукт или введите END для завершения:");
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

           currentCustomer = findCustomerIndex(customerName);

            Product selectedProduct = findProduct(products, productName);

            if (selectedProduct != null) {
                if (customers[currentCustomer].buyProduct(selectedProduct)) {
                    System.out.println(customers[currentCustomer].getName() + " купил(а) " + selectedProduct.getName());
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
                StringBuilder purchased = new StringBuilder();
                Product[] products = customer.getBag();

                for (int i = 0; i < products.length; i++) {
                    if (i>0) {
                        purchased.append(", ");
                    }
                    purchased.append(products[i].getName());
                }
                System.out.println(customer.getName() + "-" + purchased.toString());
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
            System.exit(0);
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

    public static boolean isValidProductName(String name) {
       return name.length() >= 3 && !name.matches("\\d+");
    }

    public static boolean isValidDiscountedPrice (int price) {
        if (price <= 0) {
            return false;
        }
        return  true;
    }

}
