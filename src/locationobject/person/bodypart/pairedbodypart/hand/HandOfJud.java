package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfJud;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfJud;

public class HandOfJud extends Hand{
    public HandOfJud(Orientation orientation) {
        super(orientation, Gender.MALE,
                new ShoulderOfJud(orientation),
                new PalmOfJud(orientation));
    }
}
