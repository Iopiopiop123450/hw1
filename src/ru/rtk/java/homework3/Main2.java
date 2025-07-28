package ru.rtk.java.homework3;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность символов > < - без пробелов");
        String input = scanner.nextLine();
        int count = 0;

        for (int i = 0; i <= input.length() - 5; i++) {
            if (input.substring(i, i + 5).equals(">>-->")) {
                count++;
            }
        }
        for (int i = 0; i <= input.length() - 5; i++) {
            if (input.substring(i, i + 5).equals("<--<<")) {
                count++;
            }
        }
        System.out.println("Количество стрел:" + count);
    }
}
