package chapter24;

public interface TimeSource {
    public void registerObserver(ClockObserver observer);
}
