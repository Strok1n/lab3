package locationobject.item;

import location.Buyable;

public class Pizza extends Item implements Buyable {
    private final String name;

    public Pizza(String name){
        this.name = name;
    }

    public String getName() {return name;}

    @Override
    public int getPrice() {
        return 15;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
