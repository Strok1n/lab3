package action;

import location.Buyable;
import location.TwoDimensionalPizzeria;
import locationobject.person.Person;
import java.util.List;

public class ToOrder implements Action{
    private final TwoDimensionalPizzeria twoDimensionalPizzeria;
    private final Person person;
    private final List<Buyable> buyables ;

    public ToOrder(TwoDimensionalPizzeria twoDimensionalPizzeria, Person person, List<Buyable> buyables) {
        this.twoDimensionalPizzeria = twoDimensionalPizzeria;
        this.person = person;
        this.buyables = buyables;
    }


    @Override
    public void execute() throws InterruptedException {
        this.twoDimensionalPizzeria.addOrder(this.person, buyables);
    }
}
