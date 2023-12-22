package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.hand.palm.PalmOfDori;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.ShoulderOfDori;

public class HandOfDori extends Hand{
    public HandOfDori(Orientation orientation) {
        super(orientation, Gender.FEMALE,
                new ShoulderOfDori(orientation),
                new PalmOfDori(orientation));
    }
}