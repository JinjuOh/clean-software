package chapter24;

import lombok.Getter;

@Getter
public class MockTimeSink implements Observer {

    private int hours;
    private int minutes;
    private int seconds;
    private TimeSource timeSource;

    public MockTimeSink(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public void update() {
       this.hours = timeSource.getHours();
       this.minutes = timeSource.getMinutes();
       this.seconds = timeSource.getSeconds();
    }
}
