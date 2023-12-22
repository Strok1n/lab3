package locationobject.item;

import enumeration.Liquid;
import location.Buyable;
import locationobject.item.Item;

public class Bottle extends Item implements Buyable {

    private Liquid liquidInside;
    private int fullnessPercent;

    public Bottle(Liquid liquidInside){
        this.liquidInside = liquidInside;
        this.fullnessPercent = 100;
    }

    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public String toString(){
        return "Bottle with " + liquidInside + " inside and " + fullnessPercent +" fullness percent";
    }
}
