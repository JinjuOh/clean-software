package chapter24;

import lombok.Getter;

@Getter
public class MockTimeSink implements TimeSink {

    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public void setTime(int hours, int minute, int seconds) {
       this.hours = hours;
       this.minutes = minute;
       this.seconds = seconds;
    }
}
