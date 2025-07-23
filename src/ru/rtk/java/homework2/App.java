package ru.rtk.java.homework2;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        TV panasonic = new TV((int) (Math.random() * 150+20), "белый");
        TV lg = new TV ((int) (Math.random() * 150 + 20),"черный");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цвет ТВ Panasonic:");
        String panasonicColour = scanner.nextLine();
        panasonic.setColour(panasonicColour);

        System.out.println("Введите цвет ТВ LG:");
        String lgColour = scanner.nextLine();
        lg.setColour(lgColour);


        System.out.println("Параметры ТВ Panasonic:" +  panasonic.getSize()+ " дюймов, цвет " + panasonicColour);
        System.out.println("Параметры ТВ LG:" + lg.getSize() + " дюймов, цвет " + lgColour);
        panasonic.panasonicTVon();
        lg.lgTvon();
    }
}
