package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfGage;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfGage;


public class HandOfGage extends Hand{
    public HandOfGage(Orientation orientation) {
        super(orientation, Gender.MALE,
                new ShoulderOfGage(orientation),
                new PalmOfGage(orientation));
    }
}
