package homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TV {
    private int size;
    private String colour;
    private List<Channel> channels = new ArrayList<>();
    private int currentChannelIndex = 1;

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

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void removeChannel (Channel channel) {
        channels.remove(channel);
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void TVon() {
        System.out.println("ТВ вкл");
    }

    public void switchChannel(int channelNumber) {
        if (channelNumber >= 1 && channelNumber <= channels.size()) {
            currentChannelIndex = channelNumber - 1;
        }
        else {
            System.out.println("Канал не найден");
        }
    }

    public Channel getCurrentChannel () {
        return channels.get(currentChannelIndex);
    }

    @Override
    public String toString() {
        return "TV{" +
                "colour='" + colour + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return size == tv.size && Objects.equals(colour, tv.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, colour);
    }
}


