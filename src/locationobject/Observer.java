package locationobject;

import geometry.Point;

public interface Observer {
    void handleEvent(Point point) throws InterruptedException;
}

