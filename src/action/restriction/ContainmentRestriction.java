package action.restriction;

import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class ContainmentRestriction extends Restriction {
    public ContainmentRestriction(Location location, List<LocationObject> locationObjects) {
        super(location, locationObjects);
    }

    @Override
    public boolean check() {
        for (LocationObject locationObject : this.locationObjects)
            if (!this.location.getLocationObjectsCopy().contains(locationObject))
                return false;
        return true;
    }

    @Override
    public String failDescription() {
        return "Some objects are not contained in the location.";
    }
}
