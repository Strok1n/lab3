package action;

import locationobject.person.Person;

public class PlungeIntoSorrowsAndFantasies implements Action{
    private final Person person;

    public PlungeIntoSorrowsAndFantasies(Person person) {
        this.person = person;
    }

    @Override
    public void execute() throws InterruptedException {
        this.person.plungeIntoSorrowsAndFantasies();
    }
}
