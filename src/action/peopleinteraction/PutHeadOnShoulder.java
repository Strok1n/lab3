package action.peopleinteraction;

import action.LocationAction;
import action.Stoppable;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.FacingRestriction;
import action.restriction.Restriction;
import enumeration.Orientation;
import location.Location;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PutHeadOnShoulder extends LocationAction implements Stoppable {

    private final Orientation shoulderSide;

    public PutHeadOnShoulder(Location location, Person firstPerson, Person secondPerson, Orientation shoulderSide) {
        super(location,
                new ArrayList<>(List.of(new Person[]{firstPerson, secondPerson})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new Person[]{firstPerson, secondPerson})),
                        new ClosenessRestriction(location, firstPerson, secondPerson),
                        new FacingRestriction(location, firstPerson, secondPerson),
                        new FacingRestriction(location, secondPerson, firstPerson)
                })));
        this.shoulderSide = shoulderSide;
    }


    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);

        firstPerson.putHeadOnShoulder(secondPerson, this.shoulderSide);
    }

    @Override
    public void stop() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);

        firstPerson.removeHeadFromShoulder(secondPerson, this.shoulderSide);
    }

}
