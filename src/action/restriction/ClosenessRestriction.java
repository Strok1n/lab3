package action.restriction;

import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class ClosenessRestriction extends Restriction {
    public ClosenessRestriction(Location location, LocationObject firstLocationObject,
                                LocationObject secondLocationObject) {
        super(location,
                new ArrayList<>(new ArrayList<>(List.of(
                        new LocationObject[]{firstLocationObject, secondLocationObject}))));
    }

    @Override
    public boolean check() {
        return location.areLocationObjectsCloseToEachOtherForInteraction(locationObjects.get(0), locationObjects.get(1));
    }

    @Override
    public String failDescription() {
        return this.locationObjects.get(0) + " and " + locationObjects.get(1) + " are not close to each other";
    }
}
