package ru.rtk.java.homework3;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите букву алфавита:");
        String line = scanner.nextLine().toLowerCase();
        char left = getLeftLetter(line.charAt(0));
        System.out.println("Слева:" + left);
    }

private static char getLeftLetter(char letter) {
        String words = "qwertyuiopasdfghjklzxcvbnm";
        int index = words.indexOf(letter);
        if (index == 0) {
            return words.charAt(words.length()-1);
        }
        return words.charAt(index-1);
    }
}
