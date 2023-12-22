package locationobject.person.bodypart.pairedbodypart.hand.palm;

import enumeration.Gender;
import enumeration.Orientation;
import locationobject.item.Item;
import locationobject.person.ObjectOnShoulder;
import locationobject.person.bodypart.pairedbodypart.PairedBodyPart;

public class Palm extends PairedBodyPart implements ObjectOnShoulder {


    protected int palmGirthInCentimeters;
    protected Item item;


    protected Palm(Orientation orientation, Gender type, int palmGirthInCentimeters) {
        super(orientation, type);
        this.palmGirthInCentimeters = palmGirthInCentimeters;
        this.item = null;
    }


    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

}
