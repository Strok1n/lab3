package action;

import location.Buyable;
import location.Location;
import location.TwoDimensionalShop;
import locationobject.person.Person;

public class Buy implements Action{
    private final TwoDimensionalShop twoDimensionalShop;
    private final Person person;
    private final Buyable buyable;

    public Buy(TwoDimensionalShop twoDimensionalShop, Person person, Buyable buyable) {
        this.twoDimensionalShop = twoDimensionalShop;
        this.person = person;
        this.buyable = buyable;
    }

    @Override
    public void execute() throws InterruptedException {
        this.twoDimensionalShop.buy(this.person, this.buyable);
    }
}
