package locationobject;

import geometry.Point;

public interface Observable {
    void addObserver(Observer listener);
    void removeObserver(Observer listener);
    void notifyObservers(Point point) throws InterruptedException;
}

