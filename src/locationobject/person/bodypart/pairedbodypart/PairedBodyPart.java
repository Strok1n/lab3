package locationobject.person.bodypart.pairedbodypart;

import enumeration.Gender;
import enumeration.Orientation;
abstract public class PairedBodyPart {
    protected final Orientation orientation;
    protected final Gender type;

    protected PairedBodyPart(Orientation orientation, Gender type) {
        this.orientation = orientation;
        this.type = type;
    }
}
