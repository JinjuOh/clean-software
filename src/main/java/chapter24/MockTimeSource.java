package chapter24;

public class MockTimeSource implements TimeSource {

    private ClockObserver observer;

    public void setTime(int hours, int minutes, int seconds) {
        this.observer.update(hours, minutes, seconds);
    }

    @Override
    public void setObserver(ClockObserver observer) {
        this.observer = observer;
    }
}
