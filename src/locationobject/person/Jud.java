package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfJud;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfJud;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfJud;
import locationobject.person.bodypart.torso.TosroOfJud;


public class Jud extends Person{
    public Jud() {
        super("Jud",
                "Crandall",
                new HeadOfJud(),
                new TosroOfJud(),
                new HandOfJud(Orientation.LEFT),
                new HandOfJud(Orientation.RIGHT),
                new LegOfJud(Orientation.LEFT),
                new LegOfJud(Orientation.RIGHT));
    }
}
