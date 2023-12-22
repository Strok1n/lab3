package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfLouis;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfLouis;

public class HandOfLouis extends Hand{
    public HandOfLouis(Orientation orientation) {
        super(orientation, Gender.MALE,
                new ShoulderOfLouis(orientation),
                new PalmOfLouis(orientation));
    }
}
