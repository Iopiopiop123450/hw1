package homework06;

import java.util.Objects;

public class Programm {
    private String name;
    private int rating;
    private int viewers;

    public Programm(String name, int rating, int viewers) {
        this.name = name;
        this.rating = rating;
        this.viewers = viewers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Programm programm = (Programm) o;
        return rating == programm.rating && viewers == programm.viewers && Objects.equals(name, programm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, viewers);
    }

    @Override
    public String toString() {
        return "Programm{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", viewers=" + viewers +
                '}';
    }
}
