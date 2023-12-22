package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfLouis;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfLouis;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfLouis;
import locationobject.person.bodypart.torso.TorsoOfLouis;

public class Louis extends Person{
    public Louis() {
        super("Louis",
                "Creed",
                new HeadOfLouis(),
                new TorsoOfLouis(),
                new HandOfLouis(Orientation.LEFT),
                new HandOfLouis(Orientation.RIGHT),
                new LegOfLouis(Orientation.LEFT),
                new LegOfLouis(Orientation.RIGHT));
    }
}