package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfDori;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfDori;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfDori;
import locationobject.person.bodypart.torso.TorsoOfDori;



public class Dori extends Person{
    public Dori() {
        super("Dori",
                "Goldman",
                new HeadOfDori(),
                new TorsoOfDori(),
                new HandOfDori(Orientation.LEFT),
                new HandOfDori(Orientation.RIGHT),
                new LegOfDori(Orientation.LEFT),
                new LegOfDori(Orientation.RIGHT));
    }
}
