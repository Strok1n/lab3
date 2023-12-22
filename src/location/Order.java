package location;


import action.Action;
import locationobject.person.Person;
import java.util.List;

public class Order implements Action {
    private final Person customer;
    private final List<Buyable> order;

    public Order(Person customer, List<Buyable> order) {
        this.customer = customer;
        this.order = order;
    }

    @Override
    public void execute() throws InterruptedException {

        int orderCost = 0;
        for (Buyable buyable: order) {
            orderCost += buyable.getPrice();
        }
        customer.setCash(customer.getCash() - orderCost);
    }
}
