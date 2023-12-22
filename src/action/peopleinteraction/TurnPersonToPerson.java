package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.FacingRestriction;
import action.restriction.Restriction;
import geometry.TwoDimensionalVector;
import location.Location;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class TurnPersonToPerson extends LocationAction {


    public TurnPersonToPerson(Location location, Person firstPerson, Person secondPerson) {
        super(location,
                new ArrayList<>(List.of(new Person[]{firstPerson, secondPerson})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new Person[]{firstPerson, secondPerson})),
                        new ClosenessRestriction(location, firstPerson, secondPerson)
                })));
    }

    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);



        firstPerson.setVector(secondPerson.getPoint().subtract(firstPerson.getPoint()));
        System.out.println(firstPerson +" turned to face " + secondPerson);
    }
}
