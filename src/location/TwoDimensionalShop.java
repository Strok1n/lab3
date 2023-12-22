package location;

import locationobject.person.Person;

import java.util.ArrayList;

public class TwoDimensionalShop extends TwoDimensionalLocation{
    public TwoDimensionalShop(String name, int width, int length) {
        super(name, width, length);
    }

    public void buy(Person person, Buyable buyable){
        person.setCash(person.getCash() - buyable.getPrice());
    }

}
