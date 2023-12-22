package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfIrwin;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfIrwin;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfIrwin;
import locationobject.person.bodypart.torso.TorsoOfIrwin;


public class Irwin extends Person{
    public Irwin() {
        super("Irwin",
                "Goldman",
                new HeadOfIrwin(),
                new TorsoOfIrwin(),
                new HandOfIrwin(Orientation.LEFT),
                new HandOfIrwin(Orientation.RIGHT),
                new LegOfIrwin(Orientation.LEFT),
                new LegOfIrwin(Orientation.RIGHT));
    }
}
