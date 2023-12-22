package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfEllie;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfEllie;

public class HandOfEllie extends Hand{
    public HandOfEllie(Orientation orientation) {
        super(orientation, Gender.FEMALE,
                new ShoulderOfEllie(orientation),
                new PalmOfEllie(orientation));
    }
}
