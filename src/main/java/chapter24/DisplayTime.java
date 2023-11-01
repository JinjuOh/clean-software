package chapter24;

public class DisplayTime {
    public static void main(String[] args) {
        Clock clock = new Clock();
        while (true) {
            int sec = clock.getSecond();
            int min = clock.getMinute();
            int hour = clock.getHour();
            showTime(hour, min, sec);
        }
    }

    private static void showTime(int hour, int min, int sec) {
        System.out.println(hour+":"+min+":"+sec);
    }
}
