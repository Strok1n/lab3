package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfIrwin;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfRachel;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfIrwin;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfRachel;

public class HandOfIrwin extends Hand{
    public HandOfIrwin(Orientation orientation) {
        super(orientation, Gender.MALE,
                new ShoulderOfIrwin(orientation),
                new PalmOfIrwin(orientation));
    }
}