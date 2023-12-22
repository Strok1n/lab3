package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ContainmentRestriction;
import action.restriction.Restriction;
import enumeration.Arrangement;
import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class WalkAroundPeople extends LocationAction {
    public WalkAroundPeople(Location location, List<LocationObject> people) {
        super(location,
                people, new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, people),
                })));
    }


    @Override
    protected void actionLogic() throws InterruptedException {
        Person person = (Person) this.locationObjects.get(0);

        for (int i = 1; i < this.locationObjects.size(); i++) {
            Approach approach = new Approach(location, person, this.locationObjects.get(i), Arrangement.FRONT);
            approach.execute();
        }
    }
}
