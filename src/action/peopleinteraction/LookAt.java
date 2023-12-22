package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.FacingRestriction;
import action.restriction.Restriction;
import enumeration.GazeModifier;
import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class LookAt extends LocationAction {

    private final GazeModifier gazeModifier;

    public LookAt(Location location, Person firstPerson, LocationObject locationObject, GazeModifier gazeModifier) {
        super(location,
                new ArrayList<>(List.of(new LocationObject[]{firstPerson, locationObject})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new LocationObject[]{firstPerson, locationObject}))
                })));
        this.gazeModifier = gazeModifier;
    }

    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);


        firstPerson.getHead().setGazeModifier(gazeModifier);
        firstPerson.getHead().setPointILookingAt(locationObjects.get(1).getPoint());
        locationObjects.get(1).addObserver(firstPerson.getHead());
        System.out.println(firstPerson + " started watching " + locationObjects.get(1) + " with " + gazeModifier);

    }

}

