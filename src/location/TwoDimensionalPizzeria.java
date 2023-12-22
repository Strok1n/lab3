package location;

import locationobject.item.Item;
import locationobject.item.Pizza;
import locationobject.person.Person;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalPizzeria extends TwoDimensionalLocation{

    private final ArrayList<Order> orders;

    public TwoDimensionalPizzeria(String name, int width, int length) {
        super(name, width, length);
        orders = new ArrayList<>();
    }

    public void addOrder(Person customer, List<Buyable> pizzas){
        this.orders.add(new Order(customer, pizzas));
        System.out.println(customer + " orders " + pizzas + " at " + this);
    }


}
