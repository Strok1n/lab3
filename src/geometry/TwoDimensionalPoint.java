package geometry;

import java.util.Objects;

public class TwoDimensionalPoint implements Point{

    private final int x;
    private final int y;

    public TwoDimensionalPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point add(Vector vector) {
        return new TwoDimensionalPoint(this.x + ((TwoDimensionalVector) vector).getX(), this.y + ((TwoDimensionalVector) vector).getY());
    }

    @Override
    public Vector subtract(Point point) {
        return new TwoDimensionalVector(this.x - ((TwoDimensionalPoint)point).x, this.y - ((TwoDimensionalPoint)point).y);
    }

    @Override
    public int distanceSquared(Point toPoint) {
        return euclideanMetricSquared(this, (TwoDimensionalPoint) toPoint);
    }

    private static int euclideanMetricSquared(TwoDimensionalPoint a, TwoDimensionalPoint b){
        return ((a.getX() - b.getX()) * (a.getX() - b.getX())) +
                ((a.getY() - b.getY()) * (a.getY() - b.getY()));
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }


    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        TwoDimensionalPoint other = (TwoDimensionalPoint) otherObject;

        return Objects.equals(this.x, other.x) &&
                Objects.equals(this.y, other.y);
    }
}
