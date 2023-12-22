package locationobject.person.bodypart.pairedbodypart.hand;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.person.bodypart.pairedbodypart.PairedBodyPart;
import locationobject.person.bodypart.pairedbodypart.hand.palm.Palm;
import locationobject.person.bodypart.pairedbodypart.hand.shoulder.Shoulder;

public class Hand extends PairedBodyPart {

    protected final Shoulder shoulder;
    protected final Palm palm;

    protected HandState handState;

    protected Hand(Orientation orientation, Gender type, Shoulder shoulder, Palm palm) {
        super(orientation, type);
        this.shoulder = shoulder;
        this.palm = palm;
        this.handState = HandState.RELAXED;
    }


    public Shoulder getShoulder() {
        return shoulder;
    }

    public Palm getPalm() {
        return palm;
    }

    public HandState getHandState() {
        return handState;
    }
    public void setHandState(HandState handState) {
        this.handState = handState;
    }
}
