package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.FacingRestriction;
import action.restriction.Restriction;
import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Condole extends LocationAction {
    public Condole(Location location, Person firstPerson, Person secondPerson) {
        super(location,
                new ArrayList<>(List.of(new Person[]{firstPerson, secondPerson})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new Person[]{firstPerson, secondPerson})),
                        new ClosenessRestriction(location, firstPerson, secondPerson),
                        new FacingRestriction(location, firstPerson, secondPerson),
                        new FacingRestriction(location, secondPerson, firstPerson)

                })));
    }

    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);

        firstPerson.condole(secondPerson);
    }
}
