package locationobject.person;

import enumeration.Orientation;
import locationobject.person.bodypart.head.HeadOfRachel;
import locationobject.person.bodypart.pairedbodypart.hand.HandOfRachel;
import locationobject.person.bodypart.pairedbodypart.leg.LegOfRachel;
import locationobject.person.bodypart.torso.TorsoOfRachel;

public class Rachel extends Person{
    public Rachel() {
        super("Rachel",
                "Creed",
                new HeadOfRachel(),
                new TorsoOfRachel(),
                new HandOfRachel(Orientation.LEFT),
                new HandOfRachel(Orientation.RIGHT),
                new LegOfRachel(Orientation.LEFT),
                new LegOfRachel(Orientation.RIGHT));
    }

}