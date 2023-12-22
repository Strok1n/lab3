package geometry;

public interface Point {

    Point add(Vector vector);
    Vector subtract(Point point);
    int distanceSquared(Point toPoint);
}
