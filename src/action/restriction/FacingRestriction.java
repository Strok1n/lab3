package action.restriction;

import location.Location;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FacingRestriction extends Restriction {
    public FacingRestriction(Location location, Person firstPerson, Person secondPerson) {
        super(location, List.of(new Person[]{firstPerson, secondPerson}));
    }
    @Override
    public boolean check() {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);
        return firstPerson
                .getVector()
                .isCodirectedTo(secondPerson
                        .getPoint()
                        .subtract(firstPerson
                                .getPoint()));
    }

    @Override
    public String failDescription() {
        return this.locationObjects.get(0) + " is not facing " + this.locationObjects.get(1);
    }
}
