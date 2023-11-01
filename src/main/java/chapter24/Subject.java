package chapter24;

import java.util.Iterator;
import java.util.Vector;

public class Subject {
    private Vector observers = new Vector();

    protected void notifyObservers() {
        Iterator i = observers.iterator();
        while (i.hasNext()) {
            Observer observer = (Observer) i.next();
            observer.update();
        }
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
