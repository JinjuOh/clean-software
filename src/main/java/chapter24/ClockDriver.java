package chapter24;

public class ClockDriver {
    private TimeSink sink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.setDriver(this);
        this.sink = sink;
    }

    public void update(int hours, int minutes, int seconds) {
        this.sink.setTime(hours, minutes, seconds);
    }
}
