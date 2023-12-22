package action;

import action.restriction.Restriction;
import location.Location;
import locationobject.LocationObject;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class LocationAction implements Action{

    protected final Location location;
    protected final ArrayList<LocationObject> locationObjects;
    protected final ArrayList<Restriction> restrictions;
    protected LocationAction(Location location, List<LocationObject> locationObjects,
                             ArrayList<Restriction> restrictions){
        this.location = location;
        this.locationObjects = new ArrayList<>(locationObjects);
        this.restrictions = new ArrayList<>(restrictions);
    }
    protected final boolean checkRestrictions(){
        for (Restriction restriction: this.restrictions)
            if (!restriction.check()) {
                System.out.println(restriction.failDescription());
                return false;
            }
        return true;
    }


    @Override
    public void execute() throws InterruptedException {
        if (this.checkRestrictions())
            this.actionLogic();
        else
            System.out.println("action " + this + " does not performed");
    }
    protected abstract void actionLogic() throws InterruptedException;


}
