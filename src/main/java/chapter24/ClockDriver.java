package chapter24;

public class ClockDriver implements ClockObserver {
    private TimeSink sink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.registerObserver(this);
        this.sink = sink;
    }

    public void update(int hours, int minutes, int seconds) {
        this.sink.setTime(hours, minutes, seconds);
    }
}
