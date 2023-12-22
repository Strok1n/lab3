package locationobject.item;

public class Photo extends Item {
    private final String name;

    public Photo(String name){
        this.name = name;
    }

    public String getName() {return name;}
    @Override
    public String toString(){
        return this.name;
    }
}
