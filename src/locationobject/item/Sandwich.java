package locationobject.item;

public class Sandwich extends Item{
    private final String name;

    public Sandwich(String name){
        this.name = name;
    }

    public String getName() {return name;}
    @Override
    public String toString(){
        return this.name;
    }
}
