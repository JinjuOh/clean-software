package chapter24;

public class MockTimeSource extends TimeSource {
    public void setTime(int hours, int minutes, int seconds) {
        notify(hours, minutes, seconds);
    }
}
