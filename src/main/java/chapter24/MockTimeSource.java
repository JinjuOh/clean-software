package chapter24;

public class MockTimeSource implements TimeSource {

    TimeSourceImpl timeSource = new TimeSourceImpl();

    @Override
    public void registerObserver(ClockObserver observer) {
        timeSource.registerObserver(observer);
    }

    public void setTime(int hours, int minutes, int seconds) {
        timeSource.notify(hours, minutes, seconds);
    }
}
