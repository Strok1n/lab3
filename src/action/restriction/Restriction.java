package action.restriction;

import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class Restriction {
    protected final Location location;
    protected final ArrayList<LocationObject> locationObjects;
    protected Restriction(Location location, List<LocationObject> locationObjectList) {
        this.location = location;
        this.locationObjects = new ArrayList<>(locationObjectList);
    }


    abstract public boolean check();
    abstract public String failDescription();

}




