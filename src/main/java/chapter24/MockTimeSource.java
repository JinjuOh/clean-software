package chapter24;

import java.util.Iterator;
import java.util.Vector;

public class MockTimeSource implements TimeSource {

    private Vector observers = new Vector();

    public void setTime(int hours, int minutes, int seconds) {
        Iterator i = observers.iterator();
        while (i.hasNext()) {
            ClockObserver observer = (ClockObserver) i.next();
            observer.update(hours, minutes, seconds);
        }
    }

    @Override
    public void registerObserver(ClockObserver observer) {
        observers.add(observer);
    }
}
