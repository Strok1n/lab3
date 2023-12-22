package locationobject;

import geometry.Point;
import geometry.Vector;

import java.util.ArrayList;
import java.util.Objects;

public abstract class LocationObject implements Observable, Observer{

    protected Point point;
    protected Vector vector;

    protected ArrayList<Observer> observers;

    public LocationObject(){
        this.observers = new ArrayList<>();
    }

    public Point getPoint() {
        return point;
    }

    public Vector getVector() {
        return vector;
    }

    public void setPoint(Point point) throws InterruptedException {

        this.point = point;
        notifyObservers(point);
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }
    @Override
    public void notifyObservers(Point point) throws InterruptedException{
        for (Observer obj : observers) {
            obj.handleEvent(point);
        }
    }

    @Override
    public void handleEvent(Point point){
        this.point = point;
    }

    @Override
    public boolean equals(Object otherObject){

        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        LocationObject other = (LocationObject) otherObject;

        return Objects.equals(this.point, other.point) &&
                Objects.equals(this.vector, other.vector);

    }

    @Override
    public int hashCode(){
        return Objects.hash(point, vector);
    }
    @Override
    public String toString(){
        return getClass().getName()
                +"[point=" + point
                +",vector=" + vector
                +"]";
    }


}
