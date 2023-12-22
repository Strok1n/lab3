package locationobject.person.bodypart.pairedbodypart.leg;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.PairedBodyPart;

public class Leg extends PairedBodyPart {

    protected int thighCircumferenceInCentimeters;
    protected Leg(Orientation orientation,
                  Gender type,
                  int thighCircumferenceInCentimeters) {
        super(orientation, type);
        this.thighCircumferenceInCentimeters = thighCircumferenceInCentimeters;
    }
}
