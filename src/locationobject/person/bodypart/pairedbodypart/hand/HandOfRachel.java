package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfRachel;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfRachel;

public class HandOfRachel extends Hand{
    public HandOfRachel(Orientation orientation) {
        super(orientation, Gender.FEMALE,
                new ShoulderOfRachel(orientation),
                new PalmOfRachel(orientation));
    }
}
