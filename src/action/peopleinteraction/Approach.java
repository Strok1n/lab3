package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ContainmentRestriction;
import action.restriction.Restriction;
import enumeration.Arrangement;
import geometry.Point;
import geometry.TwoDimensionalVector;
import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Approach extends LocationAction {

    private final Arrangement arrangement;


    public Approach(Location location, Person person, LocationObject locationObject, Arrangement arrangement) {
        super(location,
                new ArrayList<>(List.of(new LocationObject[]{person, locationObject})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new LocationObject[]{person, locationObject})),
                })));
        this.arrangement = arrangement;
    }

    @Override
    protected void actionLogic() throws InterruptedException {
        Person person = (Person) this.locationObjects.get(0);
        LocationObject locationObject = this.locationObjects.get(1);
        Point destination =  locationObject.getPoint();

        switch (this.arrangement){
            case LEFT -> destination = destination.add(
                    ((TwoDimensionalVector)locationObject.getVector()).getLeftPerpendicularVector());
            case RIGHT -> destination = destination.add(
                    ((TwoDimensionalVector)locationObject.getVector()).getRightPerpendicularVector());
            case FRONT -> destination = destination.add(locationObject.getVector());
            case BEHIND -> destination = destination.add(locationObject.getVector().getOppositeVector());
            default -> {}
        }
        if (location.canAPersonStandHere(destination)){
            location.makeAPersonWalk(person, destination);
            System.out.println(person + " approached " + locationObject + " from " + this.arrangement);
        } else
            System.out.println(person + " can't approach " + locationObject + " from " + this.arrangement);
        }
    }

