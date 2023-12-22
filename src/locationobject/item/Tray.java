package locationobject.item;

import enumeration.Color;

import java.util.ArrayList;

public class Tray extends Item{
    private final ArrayList<Item> itemsOnATray;
    private final Color color;

    public Tray(Color color){
        this.itemsOnATray = new ArrayList<Item>();
        this.color = color;
    }

    public void addItem(Item item){
        itemsOnATray.add(item);
    }
    public ArrayList<Item> getItemsOnATray() {
        return new ArrayList<>(itemsOnATray);
    }
    @Override
    public String toString(){
        return "Tray of " + color +" color with items on it: " + itemsOnATray;
    }
}
