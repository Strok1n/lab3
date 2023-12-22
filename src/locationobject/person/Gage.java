package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfGage;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfGage;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfGage;
import locationobject.person.bodypart.torso.TorsoOfGage;


public class Gage extends Person{
    public Gage() {
        super("Gage",
                "Creed",
                new HeadOfGage(),
                new TorsoOfGage(),
                new HandOfGage(Orientation.LEFT),
                new HandOfGage(Orientation.RIGHT),
                new LegOfGage(Orientation.LEFT),
                new LegOfGage(Orientation.RIGHT));
        this.isDead = true;
    }
}
