package homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TV tv = new TV(47,"black");
        Channel channel1 = new Channel("Первый", 1);
        Channel channel2 = new Channel("Россия", 2);
        Channel channel3 = new Channel("ТВ3", 3);
        Programm programm1 = new Programm("Фильм", 1, 50);
        Programm programm2 = new Programm("Сериал", 2, 10);
        Programm programm3 = new Programm("Мультфильм", 8, 4);

        tv.addChannel(channel1);
        tv.addChannel(channel2);
        tv.addChannel(channel3);

        channel1.addProgramm(programm1);
        channel1.addProgramm(programm3);
        channel2.addProgramm(programm2);
        channel3.addProgramm(programm1);
        channel3.addProgramm(programm2);
        channel3.addProgramm(programm3);

        Scanner scanner = new Scanner(System.in);

        tv.TVon();

        System.out.println("Текущий канал: " + tv.getCurrentChannel().getName());
        for (Channel channel : tv.getChannels()) {
            System.out.println( "Доступен канал: " + channel.getName() + ", номер канала " + channel.getNumber());
        }

        System.out.println("Введите номер канала для переключения: ");
        int channelNumber = scanner.nextInt();
        tv.switchChannel(channelNumber);
        System.out.println("Текущий канал: " + tv.getCurrentChannel().getName());

        for (Programm programm : tv.getCurrentChannel().getProgramms()) {

            System.out.println("Программа: " + programm.getName());
            System.out.println("Программа: " + programm.getName() + ",рейтинг: " + programm.getRating() + ",зрители: " + programm.getViewers());
        }

    }
}