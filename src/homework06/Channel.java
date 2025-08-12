package homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Channel {
    private String name;
    private int number;
    private List<Programm> programms = new ArrayList<>();

    public Channel(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addProgramm(Programm programm){
        programms.add(programm);
    }

    public void removeProgramm(Programm programm) {
        programms.remove(programm);
    }

    public List<Programm> getProgramms() {
        return programms;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number && Objects.equals(name, channel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
