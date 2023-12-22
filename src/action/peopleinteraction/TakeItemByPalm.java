package action.peopleinteraction;

import action.LocationAction;
import action.restriction.ClosenessRestriction;
import action.restriction.ContainmentRestriction;
import action.restriction.Restriction;
import enumeration.Orientation;
import location.Location;
import locationobject.LocationObject;
import locationobject.item.Item;
import locationobject.item.Tray;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class TakeItemByPalm extends LocationAction {

    private final Orientation palmOrientation;

    public TakeItemByPalm(Location location, Person firstPerson, Item item, Orientation palmOrientation) {
        super(location,
                new ArrayList<>(List.of(new LocationObject[]{firstPerson, item})), new ArrayList<>(List.of(new Restriction[]{
                        new ContainmentRestriction(location, List.of(new LocationObject[]{firstPerson, item})),
                        new ClosenessRestriction(location, firstPerson, item),
                })));
        this.palmOrientation = palmOrientation;
    }
    @Override
    protected void actionLogic() throws InterruptedException {
        Person firstPerson = (Person) this.locationObjects.get(0);
        Item item = (Item) this.locationObjects.get(1);


        firstPerson.takeItemByPalm(palmOrientation, item);
        firstPerson.addObserver(item);

        if (item instanceof Tray){
            Tray tray = (Tray)item;
            for (int i = 0; i < tray.getItemsOnATray().size(); i++)
                firstPerson.addObserver(tray.getItemsOnATray().get(i));
        }


    }
}
