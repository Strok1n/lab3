package action.peopleinteraction;

import action.LocationAction;
import action.Stoppable;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.FacingRestriction;
import action.restriction.Restriction;
import enumeration.Orientation;
import geometry.TwoDimensionalVector;
import location.Location;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PutHandOnShoulder extends LocationAction implements Stoppable {

    private Orientation handSide;
    private Orientation shoulderSide;


    public PutHandOnShoulder(Location location, Person firstPerson, Person secondPerson) {
        super(location,
                List.of(new Person[]{firstPerson, secondPerson}), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new Person[]{firstPerson, secondPerson})),
                        new ClosenessRestriction(location, firstPerson, secondPerson),
                        new FacingRestriction(location, firstPerson, secondPerson)
                })));
        if (firstPerson.getVector().isCodirectedTo(secondPerson.getVector())){
            this.handSide = Orientation.LEFT;
            this.shoulderSide = Orientation.LEFT;
            return;
        }
        if (firstPerson.getVector().isCodirectedTo(secondPerson.getVector().getOppositeVector())){
            this.handSide = Orientation.LEFT;
            this.shoulderSide = Orientation.RIGHT;
            return;
        }
        if (firstPerson.getVector().isCodirectedTo(
                ((TwoDimensionalVector)secondPerson.getVector()).getRightPerpendicularVector())){
            this.handSide = Orientation.RIGHT;
            this.shoulderSide = Orientation.LEFT;
            return;
        }
        if (firstPerson.getVector().isCodirectedTo(
                ((TwoDimensionalVector)secondPerson.getVector()).getLeftPerpendicularVector())){
            this.handSide = Orientation.LEFT;
            this.shoulderSide = Orientation.RIGHT;
        }
    }

    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);

        firstPerson.putPalmOnShoulder(secondPerson, this.handSide, this.shoulderSide);
    }

    @Override
    public void stop() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Person secondPerson = (Person) this.locationObjects.get(1);

        firstPerson.removePalmFromShoulder(secondPerson, this.handSide, this.shoulderSide);
    }
}
