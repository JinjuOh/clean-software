package chapter24;

import lombok.Getter;

@Getter
public class MockTimeSink implements ClockObserver {

    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public void update(int hours, int minute, int seconds) {
       this.hours = hours;
       this.minutes = minute;
       this.seconds = seconds;
    }
}
