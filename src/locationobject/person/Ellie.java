package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfEllie;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfEllie;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfEllie;
import locationobject.person.bodypart.torso.TorsoOfEllie;


public class Ellie extends Person{
    public Ellie() {
        super("Ellie",
                "Creed",
                new HeadOfEllie(),
                new TorsoOfEllie(),
                new HandOfEllie(Orientation.LEFT),
                new HandOfEllie(Orientation.RIGHT),
                new LegOfEllie(Orientation.LEFT),
                new LegOfEllie(Orientation.RIGHT));
    }
}
