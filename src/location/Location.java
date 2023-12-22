package location;

import geometry.Point;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.HashSet;
import java.util.Set;

public abstract class Location {

    protected final String name;
    protected final Set<LocationObject> locationObjects;

    protected Location(String name) {
        this.name = name;
        locationObjects = new HashSet<>();
    }


    public Set<LocationObject> getLocationObjectsCopy() {
        return new HashSet<>(locationObjects);
    }

    public void clear(){
        this.locationObjects.clear();
    }
    public abstract void addLocationObject(LocationObject locationObject, Point toPoint) throws InterruptedException;
    public abstract void makeAPersonWalk(Person person, Point toPoint) throws InterruptedException;
    public abstract boolean areLocationObjectsCloseToEachOtherForInteraction(LocationObject firstObject, LocationObject secondObject);
    public abstract boolean canAPersonStandHere(Point point);

    @Override
    public String toString(){
        return this.name;
    }

}
