package ru.rtk.java.homework2;

public class TV {
    private int size;
    private String colour;

    public TV(int size, String colour) {
        this.size = size;
        this.colour = colour;
    }

    public TV() {
        this(47, "черный");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size>0) {this.size = size;}
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void panasonicTVon() {
        System.out.println("Panasonic ТВ вкл");
    }

    public void lgTvon() {
        System.out.println("LG ТВ вкл");
    }
}

