package ru.rtk.java.homework12;

public class Main {

    public static void main(String[] args) {
        int petya = (int) (Math.random() * 3);
        int vasya = (int) (Math.random() * 3);
        System.out.println("Петя:" + petya);
        System.out.println("Вася:" + vasya);

        String result = winner(petya, vasya);
        System.out.println("Результат игры: " + result);
    }

    private static String winner(int petya, int vasya) {
        if (petya == vasya) {
            return "Ничья";
        }

        String[][] results = {
                {"Ничья", "Петя", "Вася"},
                {"Вася", "Ничья", "Петя"},
                {"Петя", "Вася", "Ничья"}
        };
        return results[petya][vasya];
    }
}