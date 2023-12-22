package locationobject.person.bodypart.pairedbodypart.hand.shoulder;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.ObjectOnShoulder;
import locationobject.person.bodypart.pairedbodypart.PairedBodyPart;
public class Shoulder extends PairedBodyPart {
    protected ObjectOnShoulder objectOnShoulder;

    protected Shoulder(Orientation orientation, Gender type) {
        super(orientation, type);
    }

    public ObjectOnShoulder getObjectOnShoulder() {
        return objectOnShoulder;
    }

    public void setObjectOnShoulder(ObjectOnShoulder objectOnShoulder) {
        this.objectOnShoulder = objectOnShoulder;
    }


}
