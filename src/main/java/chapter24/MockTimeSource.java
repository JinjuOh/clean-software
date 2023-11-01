package chapter24;

public class MockTimeSource implements TimeSource {

    private ClockDriver driver;

    public void setTime(int hours, int minutes, int seconds) {
        this.driver.update(hours, minutes, seconds);
    }

    @Override
    public void setDriver(ClockDriver driver) {
        this.driver = driver;
    }
}
